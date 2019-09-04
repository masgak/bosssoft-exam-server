package com.bosssoft.bes.userpermission.pojo.dto;


import java.util.List;

/**
 * @author : huangyuhui
 * @version : 1.0
 * @date : 2019/9/4 0004
 */
public class CategoryTreeDTO {

	public CategoryTreeDTO() {
	}

	/**
	 * 主键id
	 */
	private Long id;

	/**
	 * 类别名称
	 */
	private String name;

	/**
	 * 父类别 ID
	 */
	private Long parentId;


	private List<CategoryTreeDTO> childList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public List<CategoryTreeDTO> getChildList() {
		return childList;
	}

	public void setChildList(List<CategoryTreeDTO> childList) {
		this.childList = childList;
	}
}
