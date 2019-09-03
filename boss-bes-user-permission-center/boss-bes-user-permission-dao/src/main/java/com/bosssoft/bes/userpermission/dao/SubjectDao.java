package com.bosssoft.bes.userpermission.dao;

import com.bosssoft.bes.userpermission.pojo.dto.SubjectDTO;
import com.bosssoft.bes.userpermission.pojo.entity.Subject;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

/**
 * @author wukeqiang
 * @date 2019-09-01 10:06
 */
@Repository
public interface SubjectDao extends Mapper<Subject>, MySqlMapper<Subject> {
    List<SubjectDTO> loadSubjects();
}
