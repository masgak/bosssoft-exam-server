package com.bosssoft.bes.userpermission.pojo.vo;

import com.bosssoft.bes.userpermission.pojo.base.DataItemVO;

/**
 * 增删改页面VO
 * @author wukeqiang
 * @date 2019-09-01
 */
public class DictionaryDataItemVO extends DataItemVO {
    /**
     * 数据字典名称
     */
    protected String name;
    /**
     * 数据字典类别
     */
    protected String category;
    /**
     * 数据字典值
     */
    protected String value;
    /**
     * 状态位
     */
    protected Byte status;
    /**
     * 备注
     */
    protected String remark;

    public DictionaryDataItemVO() {
    }

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

    @Override
    public String toString() {
        return "DictionaryDataItemVO{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", value='" + value + '\'' +
                ", status=" + status +
                ", remark='" + remark + '\'' +
                ", id=" + id +
                '}';
    }
}
