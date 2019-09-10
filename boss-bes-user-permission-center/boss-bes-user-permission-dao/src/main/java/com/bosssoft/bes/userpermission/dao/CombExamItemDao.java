package com.bosssoft.bes.userpermission.dao;

import com.bosssoft.bes.userpermission.pojo.dto.CombExamItemDTO;
import com.bosssoft.bes.userpermission.pojo.entity.CombExamItem;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

/**
 * @author wukeqiang
 * @date 2019-09-01 10:06
 */
@Repository
public interface CombExamItemDao extends Mapper<CombExamItem>, MySqlMapper<CombExamItem> {
    /**
     * 加载组卷配置详情
     * @return 配置性情entity
     * @param id 组卷配置id
     */
    List<CombExamItemDTO> queryCombExamItem(Long id);

    /**
     * 加载组卷配置Id
     * @param id 配置Id
     * @return 组卷配置Id
     */
    List<CombExamItemDTO> queryItemId(Long id);
}
