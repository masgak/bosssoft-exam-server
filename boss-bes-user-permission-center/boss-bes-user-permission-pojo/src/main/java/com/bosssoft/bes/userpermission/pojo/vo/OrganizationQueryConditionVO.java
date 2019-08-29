package com.bosssoft.bes.userpermission.pojo.vo;

import com.bosssoft.bes.userpermission.pojo.base.QueryConditionVO;
import com.bosssoft.bes.userpermission.pojo.dto.OrganizationDTO;

/**
 * @author 章邴瀚
 * @date 2019-08-15 14:05

 */
public class OrganizationQueryConditionVO extends QueryConditionVO {

    /**
     * 机构名称
     */
    private String name;

    public OrganizationQueryConditionVO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
