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
    protected long category;
    /**
     * 题型
     */
    protected long subjectType;
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
     * 状态位
     */
    protected Byte status;

    public long getCategory() {
        return category;
    }

    public void setCategory(long category) {
        this.category = category;
    }

    public long getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(long subjectType) {
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


    @Override
    public String toString() {
        return "SubjectDataItemVO{" +
                "category='" + category + '\'' +
                ", subjectType='" + subjectType + '\'' +
                ", subjectDifficulty='" + subjectDifficulty + '\'' +
                ", name='" + name + '\'' +
                ", subjectAnswers=" + subjectAnswers +
                ", status=" + status +
                ", id=" + id +
                '}';
    }
}
