package com.bosssoft.bes.userpermission.service.impl;

import com.bosssoft.bes.base.utils.DateUtils;
import com.bosssoft.bes.base.utils.SnowFlake;
import com.bosssoft.bes.userpermission.dao.CategoryDao;
import com.bosssoft.bes.userpermission.pojo.dto.CategoryDTO;
import com.bosssoft.bes.userpermission.pojo.entity.Category;
import com.bosssoft.bes.userpermission.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : huangyuhui
 * @version : 1.0
 * @date : 2019/9/2 0002
 */
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private DataSourceTransactionManager dataSourceTransactionManager;

	/**
	 * 增加题目类别
	 * @param categoryDTO
	 * @return
	 */
	public int add(CategoryDTO categoryDTO) {
		if(categoryDTO!=null){
			SnowFlake snowFlake=new SnowFlake(2,3);
			Date createdTime= DateUtils.getDate();
			//设置id（雪花算法获得）
			categoryDTO.setId(snowFlake.nextId());
			//更新时间和创建时间一样
			categoryDTO.setCreatedTime(createdTime);
			categoryDTO.setUpdatedTime(createdTime);
			//创建者和更新者后续从登录信息中获取
			categoryDTO.setCreatedBy((long)9527);
			categoryDTO.setUpdatedBy((long)9527);
			//设置版本
			categoryDTO.setVersion((long)1.0);
			try{
				categoryDao.insert(categoryDTO);
				return 1;
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		return 0;
	}

	/**
	 * 删除题目类别
	 * @param categoryDtos
	 * @return
	 */
	public int delete(List<CategoryDTO> categoryDtos) {
		CategoryDTO categoryDTO=new CategoryDTO();
		if(categoryDtos!=null){
			for(CategoryDTO categoryDto : categoryDtos){
				categoryDTO=categoryDto;
				categoryDao.delete(categoryDTO);
			}
		}
		return 0;
	}

	/**
	 * 修改题目类别信息
	 * @param categoryDTO
	 * @return
	 */
	public int update(CategoryDTO categoryDTO) {
		//省略版本号对比

		Category category =new Category();
		BeanUtils.copyProperties(categoryDTO,category);
		category.setUpdatedTime(DateUtils.getDate());
		return categoryDao.updateByPrimaryKeySelective(category);
	}


	/**
	 * 通过id查找题目类别
	 * @param id
	 * @return
	 */
	public CategoryDTO getByPrimaryKey(Long id) {
		Category category=categoryDao.selectByPrimaryKey(id);
		CategoryDTO dto= new CategoryDTO();
		BeanUtils.copyProperties(category,dto);
		return dto;
	}

	/**
	 * 根据条件查找
	 * @param categoryDTO
	 * @return
	 */
	public List<CategoryDTO> queryByCondition(CategoryDTO categoryDTO) {
		Condition condition = new Condition(Category.class);
		Example.Criteria criteria=condition.createCriteria();
		if(!StringUtils.isEmpty(categoryDTO.getName())){
			criteria.andLike("name","%"+categoryDTO.getName()+"%");
		}
		List<Category> categories=categoryDao.selectByExample(condition);
		List<CategoryDTO> dtos=null;
		CategoryDTO dto=null;
		if(categories!=null){
			dtos=new ArrayList<CategoryDTO>(categories.size());
			for(Category category:categories){
					dto=new CategoryDTO();
					BeanUtils.copyProperties(category,dto);
					dtos.add(dto);
			}
		}else{
			dtos=new ArrayList<CategoryDTO>();
		}
		return dtos;
	}

	/**
	 * 查找所有题目类别
	 * @return List<CategoryDTO> 不会为null
	 */
	public List<CategoryDTO> queryAll() {
		List<CategoryDTO> dtos=new ArrayList<CategoryDTO>();
		List<Category> categories=categoryDao.selectAll();
		CategoryDTO dto=null;
		if(categories!=null){
			for(Category category:categories){
				dto=new CategoryDTO();
				BeanUtils.copyProperties(category,dto);
				dtos.add(dto);
			}
		}
		return dtos;
	}
}
