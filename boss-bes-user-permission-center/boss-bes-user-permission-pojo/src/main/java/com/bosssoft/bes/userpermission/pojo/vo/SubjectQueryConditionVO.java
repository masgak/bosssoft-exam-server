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
    private Long categoryId;
    /**
     * 题型
     */
    private Long subjectTypeId;
    /**
     * 题目名称
     */
    private String name;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getSubjectTypeId() {
        return subjectTypeId;
    }

    public void setSubjectTypeId(Long subjectTypeId) {
        this.subjectTypeId = subjectTypeId;
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
                "categoryId=" + categoryId +
                ", subjectTypeId=" + subjectTypeId +
                ", name='" + name + '\'' +
                '}';
    }
}
