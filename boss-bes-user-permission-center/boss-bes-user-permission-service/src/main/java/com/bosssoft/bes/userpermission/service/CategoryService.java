package com.bosssoft.bes.userpermission.service;

import com.bosssoft.bes.userpermission.pojo.dto.CategoryDTO;
import com.bosssoft.bes.userpermission.pojo.dto.CategoryTreeDTO;
import com.bosssoft.bes.userpermission.pojo.entity.Category;
import com.bosssoft.bes.userpermission.service.base.BaseService;

import java.util.List;

/**
 * @author : huangyuhui
 * @version : 1.0
 * @date : 2019/9/2 0002
 */
public interface CategoryService  extends BaseService<CategoryDTO> {
	public List<CategoryTreeDTO> getTree();
}
