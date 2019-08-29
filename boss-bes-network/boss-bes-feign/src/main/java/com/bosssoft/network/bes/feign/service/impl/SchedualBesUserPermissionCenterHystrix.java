package com.bosssoft.network.bes.feign.service.impl;

import com.bosssoft.network.bes.feign.service.SchedualBesUserPermissionCenter;
import org.springframework.stereotype.Component;

/**
 * @author ztanker
 * @date 2019-08-23 9:57
 */
@Component
public class SchedualBesUserPermissionCenterHystrix implements SchedualBesUserPermissionCenter {
    @Override
    public String funq1() {
        return "failed, q1";
    }
}
