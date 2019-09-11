package com.bosssoft.bes.basedata.pojo.dto;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.util.List;

/**
 * @author : huangyuhui
 * @version : 1.0
 * @date : 2019/9/4 0004
 */
public class CategoryTreeDTO {

	public CategoryTreeDTO() {
		this.leaf=1;
	}

	/**
	 * 主键id
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;

	/**
	 * 类别名称
	 */
	private String name;

	/**
	 * 父类别 ID
	 */
	private Long parentId;

	/**
	 * 是否是叶子节点
	 */
	private byte leaf;

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

	public byte getLeaf() {
		return leaf;
	}

	public void setLeaf(byte leaf) {
		this.leaf = leaf;
	}
}
