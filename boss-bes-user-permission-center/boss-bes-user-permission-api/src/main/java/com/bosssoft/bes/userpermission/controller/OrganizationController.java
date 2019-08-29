package com.bosssoft.bes.userpermission.controller;

import com.bosssoft.bes.base.coredata.vo.CommonRequest;
import com.bosssoft.bes.base.coredata.vo.CommonResponse;

import com.bosssoft.bes.userpermission.pojo.dto.OrganizationDTO;
import com.bosssoft.bes.userpermission.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 章邴瀚
 * @date 2019-08-16 9:30
 */
@RestController
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @RequestMapping(value = "/organization", method = RequestMethod.POST)
    public CommonResponse add(CommonRequest commonRequest) {
        return null;
    }

    @RequestMapping(value = "/organization", method = RequestMethod.DELETE)
    public CommonResponse delete(CommonRequest commonRequest) {
        return null;
    }

    @RequestMapping(value = "/organization", method = RequestMethod.PUT)
    public CommonResponse update(CommonRequest commonRequest) {
        return null;
    }

    public CommonResponse queryByPrimaryKey(CommonRequest commonRequest) {
        return null;
    }

    public CommonResponse queryByCondition(CommonRequest commonRequest) {
        return null;
    }

    @CrossOrigin
    @GetMapping("api/organizations")
    public List<OrganizationDTO> list() throws Exception {
        OrganizationDTO dto = new OrganizationDTO();
        return  organizationService.queryByCondition(dto);
    }
}
