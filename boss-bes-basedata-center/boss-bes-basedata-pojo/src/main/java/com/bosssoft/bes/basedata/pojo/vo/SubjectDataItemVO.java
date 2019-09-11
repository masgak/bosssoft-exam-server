package com.bosssoft.bes.basedata.pojo.vo;

import com.bosssoft.bes.basedata.pojo.base.DataItemVO;
import com.bosssoft.bes.basedata.pojo.dto.SubjectAnswerDTO;
import com.bosssoft.bes.basedata.pojo.entity.SubjectAnswer;

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
    private Long categoryId;
    /**
     * 题型
     */
    private Long subjectTypeId;
    /**
     * 题目难度
     */
    private Long difficulty;
    /**
     * 题目名称
     */
    private String name;

    /**
     *题目ID
     */
    private List<SubjectAnswerDTO> subjectAnswers;

    /**
     * 状态位
     */
    private Byte status;

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

    public Long getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Long difficulty) {
        this.difficulty = difficulty;
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
                "categoryId=" + categoryId +
                ", subjectTypeId=" + subjectTypeId +
                ", difficulty=" + difficulty +
                ", name='" + name + '\'' +
                ", subjectAnswers=" + subjectAnswers +
                ", status=" + status +
                ", id=" + id +
                '}';
    }
}
