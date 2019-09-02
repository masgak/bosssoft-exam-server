package com.bosssoft.bes.userpermission.pojo.dto;

import com.bosssoft.bes.userpermission.pojo.entity.SubjectType;

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
		return "OrganizationDTO{" +
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
