package com.bosssoft.bes.userpermission.service;

import com.bosssoft.bes.userpermission.pojo.dto.CombExamItemDTO;
import com.bosssoft.bes.userpermission.service.base.BaseService;

import java.util.List;

/**
 * @author wukeqiang
 * @date 2019-09-01
 */
public interface CombExamItemService extends BaseService<CombExamItemDTO> {
    List<CombExamItemDTO> queryItemId(Long combExamId);
}
