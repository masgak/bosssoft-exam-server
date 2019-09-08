package com.bosssoft.bes.userpermission.pojo.vo;

import com.bosssoft.bes.userpermission.pojo.base.QueryConditionVO;

/**
 * 查询条件VO
 * @author wukeqiang
 * @date 2019-09-01
 */
public class SubjectQueryConditionVO extends QueryConditionVO {
    /**
     * 题目类别
     */
    private String category;
    /**
     * 题型
     */
    private String subjectType;
    /**
     * 题目名称
     */
    private String name;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SubjectQueryConditionVO{" +
                "category='" + category + '\'' +
                ", subjectType='" + subjectType + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
