package com.bosssoft.bes.basedata.service;

import com.bosssoft.bes.basedata.pojo.dto.CategoryDTO;
import com.bosssoft.bes.basedata.pojo.dto.CategoryTreeDTO;
import com.bosssoft.bes.basedata.pojo.entity.Category;
import com.bosssoft.bes.basedata.service.base.BaseService;

import java.util.List;

/**
 * @author : huangyuhui
 * @version : 1.0
 * @date : 2019/9/2 0002
 */
public interface CategoryService  extends BaseService<CategoryDTO> {
	public List<CategoryTreeDTO> getTree();
}
