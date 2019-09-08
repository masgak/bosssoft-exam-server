package com.bosssoft.bes.userpermission.service.impl;

import com.bosssoft.bes.base.utils.SnowFlake;
import com.bosssoft.bes.userpermission.dao.SubjectAnswerDao;
import com.bosssoft.bes.userpermission.pojo.dto.SubjectAnswerDTO;
import com.bosssoft.bes.userpermission.service.SubjectAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectAnswerServiceImpl implements SubjectAnswerService {

    @Autowired
    SubjectAnswerDao subjectAnswerDao;

    public int add(SubjectAnswerDTO subjectAnswerDTO) {
        if (subjectAnswerDTO != null){
            //由雪花算法生成相关id
            SnowFlake snowFlake = new SnowFlake(2,3);
            subjectAnswerDTO.setId(snowFlake.nextId());
            try {
                subjectAnswerDao.insert(subjectAnswerDTO);
                return 1;
            }catch (Exception e){
                e.printStackTrace();
                return 0;
            }
        }else {
            return 0;
        }
    }

    public int delete(List<SubjectAnswerDTO> subjectAnswerDTOS) {
        SubjectAnswerDTO subjectAnswerDTO = new SubjectAnswerDTO();
        if (subjectAnswerDTOS != null){
            for(SubjectAnswerDTO attribute : subjectAnswerDTOS) {
                subjectAnswerDTO = attribute;
                System.out.println("删除的参数为"+subjectAnswerDTO);
                subjectAnswerDao.delete(subjectAnswerDTO);
            }
        }
        return 0;
    }

    public int update(SubjectAnswerDTO subjectAnswerDTO) {
        return 0;
    }

    public SubjectAnswerDTO getByPrimaryKey(Long id) {
        return null;
    }

    public List<SubjectAnswerDTO> queryByCondition(SubjectAnswerDTO subjectAnswerDTO) {
        return null;
    }

    public List<SubjectAnswerDTO> queryAll() {
        return null;
    }

    public List<SubjectAnswerDTO> queryAnswerId(Long subjectId) {
        List<SubjectAnswerDTO> results = subjectAnswerDao.queryAnswerId(subjectId);
        System.out.println(results);
        return results;
    }
}
