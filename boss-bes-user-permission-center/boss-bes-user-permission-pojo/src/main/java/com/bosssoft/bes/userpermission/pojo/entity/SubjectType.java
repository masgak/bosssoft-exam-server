package com.bosssoft.bes.userpermission.pojo.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.bosssoft.bes.userpermission.pojo.base.BaseEntity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "`t_subject_type`")
public class SubjectType   extends BaseEntity implements Serializable {

    public SubjectType() {
    }

    /**
     * 题型名称
     */
    @Excel(name = "题型",width = 15)
    @Column(name = "`name`")
    protected String name;

    /**
     * 状态位
     */
    @Column(name = "`status`")
    protected Byte status;

    /**
     * 备注
     */
    @Excel(name = "备注",width = 15)
    @Column(name = "`remark`")
    protected String remark;


    //getter and setter

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
        return "SubjectType{" +
                " id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", remark='" + remark + '\'' +
                ", createdBy=" + createdBy +
                ", createdTime=" + createdTime +
                ", updatedBy=" + updatedBy +
                ", updatedTime=" + updatedTime +
                ", version=" + version +
                '}';
    }
}
