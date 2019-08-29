package com.bosssoft.network.bes.feign.controller;

import com.bosssoft.network.bes.feign.service.SchedualBesUserPermissionCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ztanker
 * @date 2019-08-23 10:17
 */

@RestController
public class SchedualBesUserPermissionCenterController {

    @Autowired
    SchedualBesUserPermissionCenter schedualBesUserPermissionCenter;

    @RequestMapping(value = "/fun-queryOneF")
    public String testme(){
        return schedualBesUserPermissionCenter.funq1();
    }

}
