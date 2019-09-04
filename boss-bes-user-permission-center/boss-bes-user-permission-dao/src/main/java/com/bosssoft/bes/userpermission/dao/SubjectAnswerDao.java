package com.bosssoft.bes.userpermission.dao;

import com.bosssoft.bes.userpermission.pojo.entity.SubjectAnswer;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author wukeqiang
 * @date 2019-09-01 10:06
 */
@Repository
public interface SubjectAnswerDao extends Mapper<SubjectAnswer>, MySqlMapper<SubjectAnswer> {
}
