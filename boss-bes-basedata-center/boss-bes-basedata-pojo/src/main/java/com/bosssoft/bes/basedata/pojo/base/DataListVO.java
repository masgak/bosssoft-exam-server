package com.bosssoft.bes.basedata.pojo.base;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * @author ztanker
 * @date 2019-08-25 19:39
 */
public class DataListVO {
    /**
     * 主键id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    protected Long id;

    public DataListVO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
