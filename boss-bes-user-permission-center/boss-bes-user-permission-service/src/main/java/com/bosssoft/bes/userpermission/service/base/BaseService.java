package com.bosssoft.bes.userpermission.service.base;

import java.util.List;

/**
 * @author 章邴瀚
 * @date 2019-08-15 11:24
 */
public interface BaseService<DTO> {
    /**
     * 增加记录
     * @param dto
     * @return
     * @throws
     */
    int add(DTO dto) ;

    /**
     * 根据删除多条记录
     * @param dtos
     * @return
     * @throws Exception
     */
    int delete(List<DTO> dtos);

    /**
     * 删除单条记录
     * @param dto
     * @return
     */
    int delete(DTO dto);

    /**
     * 更新记录
     * @param dto
     * @return
     * @throws Exception
     */
    int update(DTO dto) ;

    /**
     * 根据主键查询记录
     * @param id
     * @return
     * @throws Exception
     */
    DTO getByPrimaryKey(Long id) ;

    /**
     * 根据条件查询记录，当Condition为空时，返回所有
     * @param dto
     * @return
     * @throws Exception
     */
    List<DTO> queryByCondition(DTO dto) ;

    /**
     * 查询所有
     * @return
     * @throws Exception
     */
    List<DTO> queryAll() ;
}
