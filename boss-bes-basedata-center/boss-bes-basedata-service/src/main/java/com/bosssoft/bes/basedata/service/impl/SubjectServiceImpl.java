package com.bosssoft.bes.basedata.service.impl;

import com.bosssoft.bes.base.utils.DateUtils;
import com.bosssoft.bes.basedata.dao.SubjectAnswerDao;
import com.bosssoft.bes.basedata.dao.SubjectDao;
import com.bosssoft.bes.basedata.pojo.dto.SubjectDTO;
import com.bosssoft.bes.basedata.pojo.entity.Subject;
import com.bosssoft.bes.basedata.service.SubjectService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author wukeqiang
 * @date 2019-09-01
 */
@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectDao subjectDao;

    @Autowired
    private SubjectAnswerDao subjectAnswerDao;

    public int add(SubjectDTO subjectDTO) {
       if (subjectDTO != null){
            //插入生成时间以及更新时间，第一次创建时两者相同
            Date createTime = DateUtils.getDate();
            Date updateTime = createTime;
            subjectDTO.setCreatedTime(createTime);
            subjectDTO.setUpdatedTime(updateTime);
            //插入创建者以及更新者，后续从redis中获取登录信息
            subjectDTO.setCreatedBy((long)9600);
            subjectDTO.setUpdatedBy((long)9600);
            //插入当前版本
            subjectDTO.setVersion((long)1.0);
            System.out.println("插入的DTO:"+subjectDTO.toString());
            try {
                subjectDao.insert(subjectDTO);
                return 1;
            }catch (Exception e){
                e.printStackTrace();
                return 0;
            }
        }else {
            return 0;
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public int delete(List<SubjectDTO> subjectDTOS) {
        SubjectDTO subjectDTO = new SubjectDTO();
        if (subjectDTOS != null){
            for(SubjectDTO attribute : subjectDTOS) {
                subjectDTO = attribute;
                System.out.println("删除的参数为"+subjectDTO);
                subjectDao.delete(subjectDTO);
            }
        }
        return 0;
    }

    public int update(SubjectDTO subjectDTO) {
        Long dbVersion = subjectDao.selectByPrimaryKey(subjectDTO.getId()).getVersion();
        //对比版本号，不同则抛出异常
//        if (!dictionaryDTO.getVersion().equals(dbVersion)){
//            throw new Exception();
//        }
        Subject subject = new Subject();
        subject.setUpdatedTime(DateUtils.getDate());
        BeanUtils.copyProperties(subjectDTO,subject);
        return subjectDao.updateByPrimaryKeySelective(subject);
    }

    public SubjectDTO getByPrimaryKey(Long id) {
        return null;
    }

    public List<SubjectDTO> queryByCondition(SubjectDTO subjectDTO)  {
        List<SubjectDTO> dto = subjectDao.queryByCondition(subjectDTO.getCategoryId(), subjectDTO.getSubjectTypeId(),subjectDTO.getName());
        return dto;
    }

    public List<SubjectDTO> queryAll() {
        List<SubjectDTO> results = subjectDao.loadSubjects();
        System.out.println(results);
        return results;
    }

    public int delete(SubjectDTO subjectDTO) {
        return 0;
    }
}
