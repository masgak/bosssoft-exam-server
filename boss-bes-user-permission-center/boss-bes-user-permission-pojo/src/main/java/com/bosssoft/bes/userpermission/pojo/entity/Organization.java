package com.bosssoft.bes.userpermission.pojo.entity;

import com.bosssoft.bes.userpermission.pojo.base.BaseEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author 章邴瀚
 * @date 2019-08-15 10:49

 */
@Repository
@Table(name = "t_organization")
public class Organization extends BaseEntity implements Serializable {
    //private static final long serialVersionUID = 1L;

    /**
     * 机构名称
     */
    protected String name;

    /**
     * 机构代码
     */
    protected String code;

    /**
     * 负责人
     */
    protected String master;

    /**
     * 电话
     */
    protected String tel;

    /**
     * 状态位
     */
    protected Byte status;
    /**
     * 地址
     */
    protected String address;

    public Organization() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}