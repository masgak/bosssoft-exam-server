package com.bosssoft.bes.userpermission.pojo.dto;

import com.bosssoft.bes.userpermission.pojo.entity.Dictionary;

/**
 * @author wukeqiang
 * @date 2019-09-01
 */
public class DictionaryDTO extends Dictionary {
    public DictionaryDTO(){
    }

    @Override
    public String toString() {
        return "DictionaryDTO{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", id=" + id +
                ", status=" + status +
                ", createdBy=" + createdBy +
                ", createdTime=" + createdTime +
                ", updatedBy=" + updatedBy +
                ", updatedTime=" + updatedTime +
                ", version=" + version +
                '}';
    }
}
