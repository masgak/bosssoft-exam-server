package com.bosssoft.bes.basedata.pojo.vo;

import com.bosssoft.bes.basedata.pojo.base.QueryConditionVO;

/**
 * @author : huangyuhui
 * @version : 1.0
 * @date : 2019/9/1 0001
 */
public class SubjectTypeQueryConditionVO  extends QueryConditionVO {

	public SubjectTypeQueryConditionVO() {
	}

	/**
	 * 题型名称
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
		return "SubjectTypeQueryConditionVO{" +
				"name='" + name + '\'' +
				", status=" + status +
				'}';
	}
}
