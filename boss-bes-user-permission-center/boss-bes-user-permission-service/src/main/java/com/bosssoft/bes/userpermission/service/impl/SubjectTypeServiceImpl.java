package com.bosssoft.bes.userpermission.service.impl;

import com.bosssoft.bes.base.utils.DateUtils;
import com.bosssoft.bes.base.utils.SnowFlake;
import com.bosssoft.bes.userpermission.dao.SubjectTypeDao;
import com.bosssoft.bes.userpermission.pojo.dto.SubjectTypeDTO;
import com.bosssoft.bes.userpermission.pojo.entity.SubjectType;
import com.bosssoft.bes.userpermission.service.SubjectTypeService;
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
 * @date : 2019/9/1 0001
 */
@Service
public class SubjectTypeServiceImpl implements SubjectTypeService {

	@Autowired
	private SubjectTypeDao subjectTypeDao;

	@Autowired
	private DataSourceTransactionManager dataSourceTransactionManager;

	/**
	 * 增加题型
	 * @param subjectTypeDTO
	 * @return 增加成功的数量
	 */
	public int add(SubjectTypeDTO subjectTypeDTO)  {
		if (subjectTypeDTO != null){
			//由雪花算法生成相关id
			SnowFlake snowFlake = new SnowFlake(2,3);
			subjectTypeDTO.setId(snowFlake.nextId());
			//插入生成时间以及更新时间，第一次创建时两者相同
			Date createTime = DateUtils.getDate();
			subjectTypeDTO.setCreatedTime(createTime);
			subjectTypeDTO.setUpdatedTime(createTime);
			//插入创建者以及更新者，后续从redis中获取登录信息
			subjectTypeDTO.setCreatedBy((long)9527);
			subjectTypeDTO.setUpdatedBy((long)9527);
			//插入当前版本
			subjectTypeDTO.setVersion((long)1.0);
			try {
				subjectTypeDao.insert(subjectTypeDTO);
				return 1;
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		return 0;
	}

	/**
	 * 批量删除题型
	 * @param subjectTypeDtos
	 * @return
	 */
	public int delete(List<SubjectTypeDTO> subjectTypeDtos)  {
		SubjectTypeDTO subjectTypeDTO = new SubjectTypeDTO();
		if (subjectTypeDtos != null){
			for(SubjectTypeDTO attribute : subjectTypeDtos) {
				subjectTypeDTO = attribute;
				//System.out.println("删除的参数为"+subjectTypeDTO);
				subjectTypeDao.delete(subjectTypeDTO);
			}
		}
		return 0;
	}

	/**
	 * 修改题型信息
	 * @param subjectTypeDTO
	 * @return
	 */
	public int update(SubjectTypeDTO subjectTypeDTO)  {
		Long dbVersion = subjectTypeDao.selectByPrimaryKey(subjectTypeDTO.getId()).getVersion();

		//省略对比版本号

		SubjectType subjectType = new SubjectType();
		BeanUtils.copyProperties(subjectTypeDTO,subjectType);
		subjectType.setUpdatedTime(DateUtils.getDate());
		return subjectTypeDao.updateByPrimaryKeySelective(subjectType);
	}

	/**
	 * 通过id查询题型
	 * @param id 题型id
	 * @return dto
	 */
	public SubjectTypeDTO getByPrimaryKey(Long id)  {
		SubjectType subjectType = subjectTypeDao.selectByPrimaryKey(id);
		SubjectTypeDTO dto = new SubjectTypeDTO();
		BeanUtils.copyProperties(subjectType,dto);
		return dto;
	}

	/**
	 * 根据条件查询
	 * @param subjectTypeDTO
	 * @return
	 */
	public List<SubjectTypeDTO> queryByCondition(SubjectTypeDTO subjectTypeDTO)  {
		Condition condition = new Condition(SubjectType.class);
		Example.Criteria criteria = condition.createCriteria();
		if (!StringUtils.isEmpty(subjectTypeDTO.getName())){
			criteria.andLike("name","%"+subjectTypeDTO.getName()+"%");
		}
		List<SubjectType> results = subjectTypeDao.selectByExample(condition);
		List<SubjectTypeDTO> dtos = null;
		SubjectTypeDTO dto = null;
		if (results != null) {
			dtos = new ArrayList<SubjectTypeDTO>(results.size());
			for (SubjectType result : results){

				//待修改
				dto = new SubjectTypeDTO();
				BeanUtils.copyProperties(result, dto);
				dtos.add(dto);
			}
		} else {
			dtos = new ArrayList<SubjectTypeDTO>();
		}
		return dtos;
	}

	/**
	 * 查询所有题型
	 * @return
	 */
	public List<SubjectTypeDTO> queryAll()  {
		List<SubjectTypeDTO> dtos =new ArrayList<SubjectTypeDTO>();
		List<SubjectType> subjectTypes = subjectTypeDao.selectAll();
		SubjectTypeDTO dto = null;
		if (subjectTypes != null){
			for (SubjectType subjectType:subjectTypes){
				dto = new SubjectTypeDTO();
				BeanUtils.copyProperties(subjectType,dto);
				dtos.add(dto);
			}
		}
		//System.out.println("返回的dto是"+subjectTypes.toString());
		return dtos;
	}

	public int delete(SubjectTypeDTO subjectTypeDTO) {
		return 0;
	}
}
