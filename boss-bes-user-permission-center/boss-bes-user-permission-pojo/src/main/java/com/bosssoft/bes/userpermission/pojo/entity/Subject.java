package com.bosssoft.bes.userpermission.pojo.entity;

import com.bosssoft.bes.userpermission.pojo.base.BaseEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import java.io.Serializable;

@Repository
@Table(name = "t_subject")
public class Subject extends BaseEntity implements Serializable {

    public Subject(){
    }

    /**
     * 题目名称
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
}
