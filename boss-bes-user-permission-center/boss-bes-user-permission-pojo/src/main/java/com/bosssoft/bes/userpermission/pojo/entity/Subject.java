package com.bosssoft.bes.userpermission.pojo.entity;

import com.bosssoft.bes.userpermission.pojo.base.BaseEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import java.io.Serializable;

@Repository
@Table(name = "t_subject")
public class Subject extends BaseEntity implements Serializable {

    public Subject(){
    }

}
