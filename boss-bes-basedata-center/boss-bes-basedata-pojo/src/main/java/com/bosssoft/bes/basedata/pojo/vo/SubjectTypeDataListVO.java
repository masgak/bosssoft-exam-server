package com.bosssoft.bes.basedata.pojo.vo;

import com.bosssoft.bes.basedata.pojo.base.DataListVO;

/**
 * @author : huangyuhui
 * @version : 1.0
 * @date : 2019/9/1 0001
 */
public class SubjectTypeDataListVO extends DataListVO {


	public SubjectTypeDataListVO() {
	}

	/**
	 * 题型名称
	 */
	protected String name;

	/**
	 * 备注
	 */
	protected String remark;

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


	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}
}
