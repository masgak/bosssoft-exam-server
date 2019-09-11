package com.bosssoft.bes.basedata.pojo.vo;

import com.bosssoft.bes.basedata.pojo.base.QueryConditionVO;

/**
 * 查询条件VO
 * @author wukeqiang
 * @date 2019-09-01
 */
public class DictionaryQueryConditionVO extends QueryConditionVO {
    /**
     * 数据字典名称
     */
    private String name;
    /**
     * 数据字典类别
     */
    private String category;
    /**
     * 启用标记
     */
    private Byte status;

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
