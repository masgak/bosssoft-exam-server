package com.bosssoft.network.bes.feign.service;

import com.bosssoft.network.bes.feign.service.impl.SchedualBesUserPermissionCenterHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ztanker
 * @date 2019-08-23 9:57
 */
@FeignClient(value = "boss-bes-user-permission-center", fallback = SchedualBesUserPermissionCenterHystrix.class)
public interface SchedualBesUserPermissionCenter {
    @RequestMapping(value = "/fun-queryOne")
    String funq1();
}
