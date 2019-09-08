package com.bosssoft.bes.userpermission.pojo.vo;

import com.bosssoft.bes.userpermission.pojo.base.DataListVO;

/**
 * 页面数据VO
 * @author wukeqiang
 * @date 2019-09-01
 */
public class SubjectDataListVO extends DataListVO {
    /**
     * 题目名称
     */
    private String name;
    /**
     * 题目类别
     */
    private String category;
    /**
     * 题型
     */
    private String subjectType;
    /**
     * 题目难度
     */
    private Long difficulty;
    /**
     * 更新时间
     */
    private String updateTime;

    /**
     * 状态位
     */
    private Byte status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Long getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Long difficulty) {
        this.difficulty = difficulty;
    }
}
