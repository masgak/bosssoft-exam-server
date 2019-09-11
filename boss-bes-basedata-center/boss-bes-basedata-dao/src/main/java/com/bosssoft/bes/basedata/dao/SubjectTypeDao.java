package com.bosssoft.bes.basedata.dao;

import com.bosssoft.bes.basedata.pojo.entity.SubjectType;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author : huangyuhui
 * @version : 1.0
 * @date : 2019/9/1 0001
 */
@Repository
public interface SubjectTypeDao extends Mapper<SubjectType>, MySqlMapper<SubjectType> {

}
