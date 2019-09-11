package com.bosssoft.bes.basedata.pojo.dto;

import com.bosssoft.bes.basedata.pojo.entity.SubjectType;

/**
 * @author : huangyuhui
 * @version : 1.0
 * @date : 2019/9/1 0001
 */
public class SubjectTypeDTO extends SubjectType {
	public SubjectTypeDTO() {
	}
	@Override
	public String toString() {
		return "SubjectTypeDTO{" +
				"name='" + name + '\'' +
				", id=" + id +
				", status=" + status +
				",remark=" + remark+
				", createdBy=" + createdBy +
				", createdTime=" + createdTime +
				", updatedBy=" + updatedBy +
				", updatedTime=" + updatedTime +
				", version=" + version +
				'}';
	}
}
