package com.bosssoft.bes.userpermission.pojo.dto;

import com.bosssoft.bes.userpermission.pojo.entity.Subject;

/**
 * @author wukeqiang
 * @date 2019-09-01
 */
public class SubjectDTO extends Subject {
    public SubjectDTO(){
    }

    private String category;
    private String subjectType;

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

    @Override
    public String toString() {
        return "SubjectDTO{" +
                "category='" + category + '\'' +
                ", subjectType='" + subjectType + '\'' +
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
