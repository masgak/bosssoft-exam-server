package com.bosssoft.bes.basedata.pojo.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.bosssoft.bes.basedata.pojo.base.BaseEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author wukeqiang
 * @date 2019-09-01
 */
@Repository
@Table(name = "t_dictionary")
public class Dictionary extends BaseEntity implements Serializable {

    public Dictionary(){
    }
    /**
     * 数据字典名称
     */
    @Excel(name = "字典名称",width = 15)
    protected String name;
    /**
     * 数据字典类别
     */
    @Excel(name = "字典类别",width = 15)
    protected String category;
    /**
     * 数据字典值
     */
    @Excel(name = "字典值",width = 15)
    protected String value;
    /**
     * 状态位
     */
    protected Byte status;
    /**
     * 备注
     */
    @Excel(name = "备注",width = 15)
    protected String remark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}
