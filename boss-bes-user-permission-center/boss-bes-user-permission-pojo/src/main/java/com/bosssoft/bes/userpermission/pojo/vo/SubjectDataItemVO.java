package com.bosssoft.bes.userpermission.pojo.vo;

import com.bosssoft.bes.userpermission.pojo.base.DataItemVO;

/**
 * 增删改页面VO
 * @author wukeqiang
 * @date 2019-09-01
 */
public class SubjectDataItemVO extends DataItemVO {
    /**
     * 题目类别
     */
    protected String category;
    /**
     * 题型
     */
    protected String subjectType;
    /**
     * 题目难度
     */
    protected String subjectDifficulty;
    /**
     * 题目名称
     */
    protected String name;
    /**
     * 题目选项
     */
    protected String subjectOptions;
    /**
     * 题目答案
     */
    protected String subjectAnswers;
    /**
     * 状态位
     */
    protected Byte status;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubjectOptions() {
        return subjectOptions;
    }

    public void setSubjectOptions(String subjectOptions) {
        this.subjectOptions = subjectOptions;
    }

    public String getSubjectAnswers() {
        return subjectAnswers;
    }

    public void setSubjectAnswers(String subjectAnswers) {
        this.subjectAnswers = subjectAnswers;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SubjectDataItemVO{" +
                "category='" + category + '\'' +
                ", subjectType='" + subjectType + '\'' +
                ", subjectDifficulty='" + subjectDifficulty + '\'' +
                ", name='" + name + '\'' +
                ", subjectOptions='" + subjectOptions + '\'' +
                ", subjectAnswers='" + subjectAnswers + '\'' +
                ", status=" + status +
                ", id=" + id +
                '}';
    }
}
