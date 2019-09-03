package com.bosssoft.bes.userpermission.dao;

import com.bosssoft.bes.userpermission.pojo.entity.Category;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author : huangyuhui
 * @version : 1.0
 * @date : 2019/9/3 0003
 */
@Repository
public interface CategoryDao extends Mapper<Category>, MySqlMapper<Category> {

}
