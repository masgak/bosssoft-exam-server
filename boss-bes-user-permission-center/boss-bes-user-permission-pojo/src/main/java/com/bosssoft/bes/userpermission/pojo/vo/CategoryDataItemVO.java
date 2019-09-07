package com.bosssoft.bes.userpermission.pojo.vo;

import com.bosssoft.bes.userpermission.pojo.base.DataItemVO;

/**
 * @author : huangyuhui
 * @version : 1.0
 * @date : 2019/9/3 0003
 */
public class CategoryDataItemVO extends DataItemVO {

	public CategoryDataItemVO() {
	}

	/**
	 * 类别名称
	 */
	protected String name;

	/**
	 * 状态位
	 */
	protected Byte status;

	/**
	 * 备注
	 */
	protected String remark;

	/**
	 * 父类别ID
	 * 增加需要根据前端返回的父类别增加
	 */
	protected long parentId;

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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	@Override
	public String toString() {
		return "CategoryDataItemVO{" +
				"name='" + name + '\'' +
				", status=" + status +
				", remark='" + remark + '\'' +
				", id=" + id +
				", parentId="+parentId+
				'}';
	}
}
