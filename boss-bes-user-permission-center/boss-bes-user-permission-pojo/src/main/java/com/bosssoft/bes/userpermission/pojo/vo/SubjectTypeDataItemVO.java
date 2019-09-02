package com.bosssoft.bes.userpermission.pojo.vo;

import com.bosssoft.bes.userpermission.pojo.base.DataItemVO;

/**
 * @author : huangyuhui
 * @version : 1.0
 * @date : 2019/9/1 0001
 * @description : 增删改页面VO
 */
public class SubjectTypeDataItemVO extends DataItemVO {
	/**
	 * 题型名称
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

	@Override
	public String toString() {
		return "SubjectTypeDataItemVO{" +
				"name='" + name + '\'' +
				", status='" + status +'\'' +
				", remark='" + remark + '\'' +
				", id=" + id +
				'}';
	}
}
