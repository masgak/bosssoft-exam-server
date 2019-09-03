package com.bosssoft.bes.userpermission.pojo.vo;

import com.bosssoft.bes.userpermission.pojo.base.QueryConditionVO;

/**
 * @author : huangyuhui
 * @version : 1.0
 * @date : 2019/9/2 0003
 */
public class CategoryQueryConditionVO extends QueryConditionVO {
	public CategoryQueryConditionVO() {
	}

	/**
	 * 类别名称
	 */
	protected String name;

	/**
	 * 状态位
	 */
	protected Byte status;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CategoryQueryConditionVO{" +
				"name='" + name + '\'' +
				", status=" + status +
				'}';
	}
}
