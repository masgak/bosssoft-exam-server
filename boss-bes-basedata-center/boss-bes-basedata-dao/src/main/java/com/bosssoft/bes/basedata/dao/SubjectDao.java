package com.bosssoft.bes.basedata.dao;

import com.bosssoft.bes.basedata.pojo.dto.SubjectDTO;
import com.bosssoft.bes.basedata.pojo.entity.Subject;
import org.apache.ibatis.annotations.Param;
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
    /**
     * 加载题目数据
     * @return 题目DTO
     */
    List<SubjectDTO> loadSubjects();
    /**
     * 题目查询
     */
    List<SubjectDTO> queryByCondition(@Param("categoryId")Long categoryId, @Param("subjectTypeId")Long subjectTypeId,@Param("name")String name);
}
