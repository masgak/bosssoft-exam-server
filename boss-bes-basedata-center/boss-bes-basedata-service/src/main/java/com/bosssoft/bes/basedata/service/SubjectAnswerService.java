package com.bosssoft.bes.basedata.service;

import com.bosssoft.bes.basedata.pojo.dto.SubjectAnswerDTO;
import com.bosssoft.bes.basedata.service.base.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SubjectAnswerService extends BaseService<SubjectAnswerDTO> {
     List<SubjectAnswerDTO> queryAnswerId(Long subjectId);
}
