package com.bosssoft.bes.basedata.pojo.vo;

import com.bosssoft.bes.basedata.pojo.base.DataItemVO;
import com.bosssoft.bes.basedata.pojo.dto.CombExamItemDTO;

import java.util.List;

/**
 * 组卷配置VO
 * @author wukeqiang
 * @date 2019-09-08
 */
public class CombExamDataItemVO extends DataItemVO {
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
        return "CombExamDataItemVO{" +
                "name='" + name + '\'' +
                ", status=" + status +
                ", companyId=" + companyId +
                ", remark='" + remark + '\'' +
                ", combExamItemDTOS=" + combExamItemDTOS +
                ", id=" + id +
                '}';
    }
}
