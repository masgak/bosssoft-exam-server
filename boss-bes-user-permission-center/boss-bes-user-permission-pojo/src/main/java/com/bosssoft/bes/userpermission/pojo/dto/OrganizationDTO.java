package com.bosssoft.bes.userpermission.pojo.dto;

import com.bosssoft.bes.userpermission.pojo.entity.Organization;

/**
 * @author 章邴瀚
 * @date 2019-08-15 14:09
 */
public class OrganizationDTO extends Organization {
    public OrganizationDTO() {
    }

    @Override
    public String toString() {
        return "OrganizationDTO{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", master='" + master + '\'' +
                ", tel='" + tel + '\'' +
                ", address='" + address + '\'' +
                ", id=" + id +
                ", status=" + status +
                ", createdBy=" + createdBy +
                ", createdTime=" + createdTime +
                ", updatedBy=" + updatedBy +
                ", updatedTime=" + updatedTime +
                ", version=" + version +
                '}';
    }
}
