package com.bosssoft.bes.userpermission.pojo.dto;

import com.bosssoft.bes.base.utils.DateUtils;
import com.bosssoft.bes.userpermission.pojo.entity.Category;

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

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 String dateString = formatter.format(updatedTime);
		return "CategoryDTO{" +
				" name='" + name + '\'' +
				", id=" + id +
				", parentId="+parentId+
				", status=" + status +
				", orgId=" + orgId+
				", remark=" + remark+
				", createdBy=" + createdBy +
				", createdTime=" + dateString +
				", updatedBy=" + updatedBy +
				", updatedTime=" + updatedTime +
				", version=" + version +
				'}';
	}
}
