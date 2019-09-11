package com.bosssoft.bes.basedata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author wukeqiang
 * @date 2019-08-19 19:10
 */
@MapperScan("com.bosssoft.bes.basedata.dao")
@SpringBootApplication
//@EnableEurekaClient
//@RestController
public class BaseDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseDataApplication.class);
    }

}
