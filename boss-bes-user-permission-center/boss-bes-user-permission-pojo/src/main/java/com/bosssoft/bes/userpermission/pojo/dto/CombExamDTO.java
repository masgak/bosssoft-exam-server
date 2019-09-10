package com.bosssoft.bes.userpermission.pojo.dto;

import com.bosssoft.bes.userpermission.pojo.entity.CombExam;

import java.util.List;

/**
 * @author wukeqiang
 * @date 2019-09-01
 */
public class CombExamDTO extends CombExam {
    public CombExamDTO(){
    }
    /**
     * 组卷配置详细列表
     */
    private List<CombExamItemDTO> combExamItemDTOS;

    public List<CombExamItemDTO> getCombExamItemDTOS() {
        return combExamItemDTOS;
    }

    public void setCombExamItemDTOS(List<CombExamItemDTO> combExamItemDTOS) {
        this.combExamItemDTOS = combExamItemDTOS;
    }

    @Override
    public String toString() {
        return "CombExamDTO{" +
                "combExamItemDTOS=" + combExamItemDTOS +
                ", name='" + name + '\'' +
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
