package com.bosssoft.bes.userpermission.dao;


import com.bosssoft.bes.userpermission.pojo.entity.Dictionary;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@Repository
public interface DictionaryDao extends Mapper<Dictionary>, MySqlMapper<Dictionary> {
}
