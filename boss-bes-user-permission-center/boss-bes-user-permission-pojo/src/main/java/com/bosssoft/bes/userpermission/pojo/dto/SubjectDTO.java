package com.bosssoft.bes.userpermission.pojo.dto;

import com.bosssoft.bes.userpermission.pojo.entity.Subject;

/**
 * @author wukeqiang
 * @date 2019-09-01
 */
public class SubjectDTO extends Subject {
    public SubjectDTO(){
    }

    private int category;
    private int subjectType;
    private int subjectDifficulty;

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(int subjectType) {
        this.subjectType = subjectType;
    }


    public int getSubjectDifficulty() {
        return subjectDifficulty;
    }

    public void setSubjectDifficulty(int subjectDifficulty) {
        this.subjectDifficulty = subjectDifficulty;
    }

    @Override
    public String toString() {
        return "SubjectDTO{" +
                "category=" + category +
                ", subjectType=" + subjectType +
                ", subjectDifficulty=" + subjectDifficulty +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", id=" + id +
                ", createdBy=" + createdBy +
                ", createdTime=" + createdTime +
                ", updatedBy=" + updatedBy +
                ", updatedTime=" + updatedTime +
                ", version=" + version +
                '}';
    }
}
