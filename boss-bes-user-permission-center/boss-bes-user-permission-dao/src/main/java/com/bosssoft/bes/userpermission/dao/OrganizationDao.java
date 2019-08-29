package com.bosssoft.bes.userpermission.dao;

import com.bosssoft.bes.userpermission.pojo.entity.Organization;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author 章邴瀚
 * @date 2019-08-16 10:06
 */
@Repository
public interface OrganizationDao extends Mapper<Organization>, MySqlMapper<Organization> {
}
