package com.bosssoft.bes.userpermission;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author wukeqiang
 * @date 2019-08-19 19:10
 */
@MapperScan("com.bosssoft.bes.userpermission.dao")
@SpringBootApplication
//@EnableEurekaClient
//@RestController
public class BossBesUserPermissionApplication {

    public static void main(String[] args) {
        SpringApplication.run(BossBesUserPermissionApplication.class);
    }

}
