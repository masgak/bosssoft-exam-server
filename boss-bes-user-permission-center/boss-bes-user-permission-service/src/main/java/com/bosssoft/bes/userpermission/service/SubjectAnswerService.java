package com.bosssoft.bes.userpermission.service;

import com.bosssoft.bes.userpermission.pojo.dto.SubjectAnswerDTO;
import com.bosssoft.bes.userpermission.service.base.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SubjectAnswerService extends BaseService<SubjectAnswerDTO> {
    public List<SubjectAnswerDTO> queryAnswerId(Long subjectId);
}
