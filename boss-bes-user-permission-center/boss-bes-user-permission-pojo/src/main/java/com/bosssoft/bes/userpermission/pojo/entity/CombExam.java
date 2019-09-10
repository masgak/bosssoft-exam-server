package com.bosssoft.bes.userpermission.pojo.entity;

import com.bosssoft.bes.userpermission.pojo.base.BaseEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author wukeqiang
 * @date 2019-09-01
 */
@Repository
@Table(name = "`t_comb_exam_config`")
public class CombExam extends BaseEntity implements Serializable {
    public CombExam(){
    }

    /**
     * 组卷配置名称
     */
    protected String name;
    /**
     * 组卷配置难度
     */
//    protected Integer difficulty;
    /**
     * 组卷配置启用标记
     */
    protected Byte status;
    /**
     * 组卷配置公司Id
     */
    protected Long companyId;
    /**
     * 组卷配置备注
     */
    protected String remark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Integer getDifficulty() {
//        return difficulty;
//    }
//
//    public void setDifficulty(Integer difficulty) {
//        this.difficulty = difficulty;
//    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "CombExam{" +
                "name='" + name + '\'' +
                ", status=" + status +
                ", companyId=" + companyId +
                ", remark='" + remark + '\'' +
                ", id=" + id +
                ", createdBy=" + createdBy +
                ", createdTime=" + createdTime +
                ", updatedBy=" + updatedBy +
                ", updatedTime=" + updatedTime +
                ", version=" + version +
                '}';
    }
}
