package com.bosssoft.bes.userpermission.pojo.vo;

import com.bosssoft.bes.userpermission.pojo.base.QueryConditionVO;

public class DictionaryQueryConditionVO extends QueryConditionVO {
    /**
     * 数据字典名称
     */
    protected String name;
    /**
     * 数据字典类别
     */
    protected String category;
    /**
     * 启用标记
     */
    protected Byte status;

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

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "DictionaryQueryConditionVO{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", status=" + status +
                '}';
    }
}
