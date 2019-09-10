package com.bosssoft.bes.userpermission.dao;

import com.bosssoft.bes.userpermission.pojo.dto.CombExamDTO;
import com.bosssoft.bes.userpermission.pojo.entity.CombExam;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

/**
 * @author wukeqiang
 * @date 2019-09-01 10:06
 */
@Repository
public interface CombExamDao extends Mapper<CombExam>, MySqlMapper<CombExam> {
    /**
     * 加载组卷配置数据
     * @return 配置DTO
     */
    List<CombExamDTO> loadCombExams();
}
