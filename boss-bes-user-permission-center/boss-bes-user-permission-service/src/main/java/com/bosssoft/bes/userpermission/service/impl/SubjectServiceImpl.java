package com.bosssoft.bes.userpermission.service.impl;

import com.bosssoft.bes.userpermission.dao.SubjectDao;
import com.bosssoft.bes.userpermission.pojo.dto.SubjectDTO;
import com.bosssoft.bes.userpermission.pojo.entity.Subject;
import com.bosssoft.bes.userpermission.service.SubjectService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wukeqiang
 * @date 2019-09-01
 */
@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectDao subjectDao;

    public int add(SubjectDTO subjectDTO) {
       if (subjectDTO != null){
            //插入生成时间以及更新时间，第一次创建时两者相同
            Date createTime = DateUtils.getDate();
            Date updateTime = createTime;
            subjectDTO.setCreatedTime(createTime);
            subjectDTO.setUpdatedTime(updateTime);
            //插入创建者以及更新者，后续从redis中获取登录信息
            subjectDTO.setCreatedBy((long)9527);
            subjectDTO.setUpdatedBy((long)9527);
            //插入当前版本
            subjectDTO.setVersion((long)1.0);
            try {
                subjectDao.insert(subjectDao);
                return 1;
            }catch (Exception e){
                e.printStackTrace();
                return 0;
            }
        }else {
            return 0;
        }
    }

    public int delete(List<SubjectDTO> subjectDTOS) {
        return 0;
    }

    public int update(SubjectDTO subjectDTO) {
        return 0;
    }

    public SubjectDTO getByPrimaryKey(Long id) {
        return null;
    }

    public List<SubjectDTO> queryByCondition(SubjectDTO subjectDTO)  {
        Condition condition = new Condition(Subject.class);
        Example.Criteria criteria = condition.createCriteria();
        if (!StringUtils.isEmpty(subjectDTO.getName())){
            criteria.andLike("name","%"+subjectDTO.getName()+"%");
        }
        List<Subject> results = subjectDao.selectByExample(condition);
        List<SubjectDTO> dtos = null;
        SubjectDTO dto = null;
        if (results != null) {
            dtos = new ArrayList<SubjectDTO>(results.size());
            for (Subject result : results){
                //此处new的做法有待商讨……
                dto = new SubjectDTO();
                BeanUtils.copyProperties(result, dto);
                dtos.add(dto);
            }
        } else {
            dtos = new ArrayList<SubjectDTO>();
        }
        return dtos;
    }

    public List<SubjectDTO> queryAll() {
        List<SubjectDTO> results = subjectDao.loadSubjects();
        System.out.println(results);
        return results;
    }
}
