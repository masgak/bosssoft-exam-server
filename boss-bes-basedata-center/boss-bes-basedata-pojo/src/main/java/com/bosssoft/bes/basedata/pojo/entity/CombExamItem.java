package com.bosssoft.bes.basedata.pojo.entity;

import com.bosssoft.bes.basedata.pojo.base.BaseEntity;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author wukeqiang
 * @date 2019-09-01
 */
@Repository
@Table(name = "`t_comb_exam_config_item`")
public class CombExamItem implements Serializable {
    public CombExamItem(){
    }

    /**
     * 配置详情id
     */
    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    protected Long id;
    /**
     * 配置题目数量
     */
    protected Integer num;
    /**
     * 配置详情难度
     */
    protected Integer difficult;
    /**
     * 配置详情分数
     */
    protected BigDecimal score;
    /**
     * 组卷配置项Id
     */
    protected Long combExamId;
    /**
     * 组卷题型Id
     */
    protected Long subjectTypeId;
    /**
     * 题目类别Id
     */
    protected Long categoryId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getDifficult() {
        return difficult;
    }

    public void setDifficult(Integer difficult) {
        this.difficult = difficult;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public Long getCombExamId() {
        return combExamId;
    }

    public void setCombExamId(Long combExamId) {
        this.combExamId = combExamId;
    }

    public Long getSubjectTypeId() {
        return subjectTypeId;
    }

    public void setSubjectTypeId(Long subjectTypeId) {
        this.subjectTypeId = subjectTypeId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
