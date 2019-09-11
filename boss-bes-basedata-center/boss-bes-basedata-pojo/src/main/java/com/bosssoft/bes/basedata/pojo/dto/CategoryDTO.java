package com.bosssoft.bes.basedata.pojo.dto;

import com.bosssoft.bes.base.utils.DateUtils;
import com.bosssoft.bes.basedata.pojo.entity.Category;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : huangyuhui
 * @version : 1.0
 * @date : 2019/9/3 0003
 */
public class CategoryDTO extends Category {
	public CategoryDTO() {
	}

	@Override
	public String toString() {
		return "CategoryDTO{" +
				" name='" + name + '\'' +
				", id=" + id +
				", parentId="+parentId+
				", status=" + status +
				", orgId=" + orgId+
				", remark=" + remark+
				", createdBy=" + createdBy +
				", createdTime=" + createdTime +
				", updatedBy=" + updatedBy +
				", updatedTime=" + updatedTime +
				", version=" + version +
				'}';
	}
}
