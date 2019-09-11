package com.bosssoft.bes.basedata.pojo.entity;

import com.bosssoft.bes.basedata.pojo.base.BaseEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author wukeqiang
 * @date 2019-09-01
 */
@Repository
@Table(name = "t_subject")
public class Subject extends BaseEntity implements Serializable {

    public Subject(){
    }

    /**
     * 题目名称
     */
    protected String name;
    /**
     * 状态位
     */
    protected Byte status;
    /**
     * 题目类型ID
     */
    protected Long categoryId;
    /**
     * 题型ID
     */
    protected Long subjectTypeId;
    /**
     * 题目难度
     */
    protected Long difficulty;

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
}
