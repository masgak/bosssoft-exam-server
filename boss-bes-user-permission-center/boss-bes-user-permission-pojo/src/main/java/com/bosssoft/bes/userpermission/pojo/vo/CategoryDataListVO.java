package com.bosssoft.bes.userpermission.pojo.vo;

import com.bosssoft.bes.userpermission.pojo.base.DataListVO;

/**
 * @author : huangyuhui
 * @version : 1.0
 * @date : 2019/9/2 0002
 */
public class CategoryDataListVO extends DataListVO {
	public CategoryDataListVO() {
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
	 * 更新时间
	 */
	protected String updateTime;

//	/**
//	 * 父类别 ID
//	 */
//	protected Long parentId;


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

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

}
