package com.bosssoft.bes.userpermission.dao;

import com.bosssoft.bes.userpermission.pojo.entity.Subject;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@Repository
public interface SubjectDao extends Mapper<Subject>, MySqlMapper<Subject> {
}
