package com.bosssoft.bes.basedata.pojo.dto;

import com.bosssoft.bes.basedata.pojo.entity.CombExamItem;

import java.math.BigDecimal;

/**
 * @author wukeqiang
 * @date 2019-09-01
 */
public class CombExamItemDTO extends CombExamItem{
    public CombExamItemDTO(){
    }

    /**
     * 组卷配置题目类别
     */
    private String category;
    /**
     * 组卷配置题型
     */
    private String subjectType;
    /**
     * 组卷配置难度
     */
    private String difficulty;

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

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public String toString() {
        return "CombExamItemDTO{" +
                "category='" + category + '\'' +
                ", subjectType='" + subjectType + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", id=" + id +
                ", num=" + num +
                ", difficult=" + difficult +
                ", score=" + score +
                ", combExamId=" + combExamId +
                ", subjectTypeId=" + subjectTypeId +
                ", categoryId=" + categoryId +
                '}';
    }
}
