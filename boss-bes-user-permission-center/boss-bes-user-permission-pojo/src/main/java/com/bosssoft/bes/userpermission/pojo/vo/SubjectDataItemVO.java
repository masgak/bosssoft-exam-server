package com.bosssoft.bes.userpermission.pojo.vo;

import com.bosssoft.bes.userpermission.pojo.base.DataItemVO;
import com.bosssoft.bes.userpermission.pojo.dto.SubjectAnswerDTO;
import com.bosssoft.bes.userpermission.pojo.entity.SubjectAnswer;

import java.util.List;

/**
 * 增删改页面VO
 * @author wukeqiang
 * @date 2019-09-01
 */
public class SubjectDataItemVO extends DataItemVO {
    /**
     * 题目类别
     */
    protected int category;
    /**
     * 题型
     */
    protected int subjectType;
    /**
     * 题目难度
     */
    protected int subjectDifficulty;
    /**
     * 题目名称
     */
    protected String name;

    /**
     *题目ID
     */
    protected List<SubjectAnswerDTO> subjectAnswers;
    /**
     * 题目选项
     */
    protected List<SubjectAnswerDTO> subjectOptions;
    /**
     * 状态位
     */
    protected Byte status;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public List<SubjectAnswerDTO> getSubjectAnswers() {
        return subjectAnswers;
    }

    public void setSubjectAnswers(List<SubjectAnswerDTO> subjectAnswers) {
        this.subjectAnswers = subjectAnswers;
    }

    public List<SubjectAnswerDTO> getSubjectOptions() {
        return subjectOptions;
    }

    public void setSubjectOptions(List<SubjectAnswerDTO> subjectOptions) {
        this.subjectOptions = subjectOptions;
    }

    @Override
    public String toString() {
        return "SubjectDataItemVO{" +
                "category='" + category + '\'' +
                ", subjectType='" + subjectType + '\'' +
                ", subjectDifficulty='" + subjectDifficulty + '\'' +
                ", name='" + name + '\'' +
                ", subjectAnswers=" + subjectAnswers +
                ", subjectOptions=" + subjectOptions +
                ", status=" + status +
                ", id=" + id +
                '}';
    }
}
