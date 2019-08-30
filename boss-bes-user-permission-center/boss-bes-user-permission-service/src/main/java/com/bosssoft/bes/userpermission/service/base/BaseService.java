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
     * @throws Exception
     */
    int add(DTO dto) throws Exception;

    /**
     * 根据删除记录
     * @param dtos
     * @return
     * @throws Exception
     */
    int delete(List<DTO> dtos) throws Exception;

    /**
     * 更新记录
     * @param dto
     * @return
     * @throws Exception
     */
    int update(DTO dto) throws Exception;

    /**
     * 根据主键查询记录
     * @param id
     * @return
     * @throws Exception
     */
    DTO getByPrimaryKey(Long id) throws Exception;

    /**
     * 根据条件查询记录，当Condition为空时，返回所有
     * @param dto
     * @return
     * @throws Exception
     */
    List<DTO> queryByCondition(DTO dto) throws Exception;

    /**
     * 查询所有
     * @return
     * @throws Exception
     */
    List<DTO> queryAll() throws Exception;
}
