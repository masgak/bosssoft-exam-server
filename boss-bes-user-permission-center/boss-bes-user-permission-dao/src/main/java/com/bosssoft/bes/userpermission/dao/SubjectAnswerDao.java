package com.bosssoft.bes.userpermission.dao;

import com.bosssoft.bes.userpermission.pojo.dto.SubjectAnswerDTO;
import com.bosssoft.bes.userpermission.pojo.entity.SubjectAnswer;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

/**
 * @author wukeqiang
 * @date 2019-09-01 10:06
 */
@Repository
public interface SubjectAnswerDao extends Mapper<SubjectAnswer>, MySqlMapper<SubjectAnswer> {
    /**
     * 查询该题目的答案ID
     * @param id 题目ID
     * @return 答案ID列表
     */
    List<SubjectAnswerDTO> queryAnswerId(Long id);
}
