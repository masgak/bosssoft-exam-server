package com.bosssoft.bes.userpermission.pojo.vo;

import com.bosssoft.bes.userpermission.pojo.base.DataListVO;

/**
 * 页面数据VO
 * @author wukeqiang
 * @date 2019-09-01
 */
public class DictionaryDataListVO extends DataListVO {
    /**
     * 数据字典名称
     */
    private String name;
    /**
     * 数据字典类别
     */
    private String category;

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
}
