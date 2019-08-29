package com.bosssoft.bes.userpermission.pojo.base;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * @author ztanker
 * @date 2019-08-25 19:42
 */
public class DataItemVO {
    /**
     * 主键id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    protected Long id;

    public DataItemVO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
