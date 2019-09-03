package com.bosssoft.bes.userpermission.pojo.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.bosssoft.bes.userpermission.pojo.base.BaseEntity;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Repository
@Table(name = "`t_category`")
public class Category extends BaseEntity implements Serializable {
    public Category() {
    }

    /**
     * 类别名称
     */
    @Excel(name="类别名称",width = 15)
    @Column(name = "`name`")
    protected String name;

    /**
     * 父类别 ID
     */
    @Excel(name="父类别ID", width = 15)
    @Column(name = "`parent_id`")
    protected Long parentId;

    /**
     * 状态位
     */
    @Excel(name="状态位", width = 15)
    @Column(name = "`status`")
    protected Byte status;

    /**
     * 组织机构 ID
     */
    @Excel(name="组织机构ID", width = 15)
    @Column(name = "`org_id`")
    protected Long orgId;

    /**
     * 备注
     */
    @Column(name = "`remark`")
    @Excel(name="备注", width = 15)
    protected String remark;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
