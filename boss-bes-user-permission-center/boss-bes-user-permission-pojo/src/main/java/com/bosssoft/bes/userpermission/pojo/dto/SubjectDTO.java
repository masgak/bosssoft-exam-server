package com.bosssoft.bes.userpermission.pojo.dto;

import com.bosssoft.bes.userpermission.pojo.entity.Subject;

/**
 * @author wukeqiang
 * @date 2019-09-01
 */
public class SubjectDTO extends Subject {
    public SubjectDTO(){
    }

    /**
     * 题目分类
     */
    private String category;
    /**
     * 题目类型
     */
    private String subjectType;
    /**
     * 题目难度
     */
    private String subjectDifficulty;

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

    public String getSubjectDifficulty() {
        return subjectDifficulty;
    }

    public void setSubjectDifficulty(String subjectDifficulty) {
        this.subjectDifficulty = subjectDifficulty;
    }

    @Override
    public String toString() {
        return "SubjectDTO{" +
                "category='" + category + '\'' +
                ", subjectType='" + subjectType + '\'' +
                ", subjectDifficulty='" + subjectDifficulty + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", categoryId=" + categoryId +
                ", subjectTypeId=" + subjectTypeId +
                ", difficulty=" + difficulty +
                ", id=" + id +
                ", createdBy=" + createdBy +
                ", createdTime=" + createdTime +
                ", updatedBy=" + updatedBy +
                ", updatedTime=" + updatedTime +
                ", version=" + version +
                '}';
    }
}
