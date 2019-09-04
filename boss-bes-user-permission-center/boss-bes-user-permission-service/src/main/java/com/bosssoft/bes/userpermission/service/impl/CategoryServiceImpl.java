package com.bosssoft.bes.userpermission.service.impl;

import com.bosssoft.bes.base.utils.DateUtils;
import com.bosssoft.bes.base.utils.SnowFlake;
import com.bosssoft.bes.userpermission.dao.CategoryDao;
import com.bosssoft.bes.userpermission.pojo.dto.CategoryDTO;
import com.bosssoft.bes.userpermission.pojo.dto.CategoryTreeDTO;
import com.bosssoft.bes.userpermission.pojo.entity.Category;
import com.bosssoft.bes.userpermission.service.CategoryService;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

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

	public List<CategoryTreeDTO> getTree(){
		List<Category> categories=categoryDao.selectAll();
		//实体List转化为dto的list,后面处理的对象都是dto
		List<CategoryTreeDTO> categoryNodes=new ArrayList<CategoryTreeDTO>(categories.size());
		//存放顶层节点（结果集）
		List<CategoryTreeDTO> resultList=new ArrayList<CategoryTreeDTO>();

		//存放所有数据，方便根据id查找，不用多次查询数据库
		Map<Object,Object> treeMap=new HashMap<Object,Object>();

		CategoryTreeDTO categoryTreeDTO=null;

		int i;
		for(i=0;i<categories.size();i++){
			//取实体对象转化为dto对象
			Category item=categories.get(i);
			categoryTreeDTO=new CategoryTreeDTO();
			BeanUtils.copyProperties(item,categoryTreeDTO);
			//放入dto的List
			categoryNodes.add(categoryTreeDTO);
			//放入Map
			treeMap.put(categoryTreeDTO.getId(),categoryTreeDTO);
		}

		for( i=0;i<categoryNodes.size();i++){
			//以元素的父id为键，在map里取值，若取不到则，对应的元素不存在，即没有父节点，为顶层节点或游离节点，加入resultList
			if(!treeMap.containsKey(categoryNodes.get(i).getParentId())){
				resultList.add(categoryNodes.get(i));
			}
		}

		for(i=0;i<categoryNodes.size();i++){
			//对于某个元素，查找其父节点
			CategoryTreeDTO category=(CategoryTreeDTO) treeMap.get(categoryNodes.get(i).getParentId());
			if(category!=null){
				if(category.getChildList()==null){
					category.setChildList(new ArrayList<CategoryTreeDTO>());
				}
				//把该元素加入其父节点的子节点列表
				category.getChildList().add(categoryNodes.get(i));
			}
		}
		return resultList;
	}

}
