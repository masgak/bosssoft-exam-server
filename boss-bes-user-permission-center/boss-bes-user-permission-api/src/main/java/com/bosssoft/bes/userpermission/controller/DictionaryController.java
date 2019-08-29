package com.bosssoft.bes.userpermission.controller;

import com.bosssoft.bes.base.coredata.vo.CommonResponse;
import com.bosssoft.bes.base.coredata.vo.CommonRequest;
import com.bosssoft.bes.base.coredata.vo.ResponseHead;
import com.bosssoft.bes.base.utils.JsonUtils;

import com.bosssoft.bes.userpermission.pojo.dto.DictionaryDTO;
import com.bosssoft.bes.userpermission.pojo.entity.Dictionary;
import com.bosssoft.bes.userpermission.pojo.vo.DictionaryDataItemVO;
import com.bosssoft.bes.userpermission.service.DictionaryService;
import com.google.gson.Gson;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DictionaryController{

    @Autowired
    private DictionaryService dictionaryService;

    @CrossOrigin
    @PostMapping("api/add")
    public CommonResponse add(@RequestBody CommonRequest commonRequest) {
        System.out.println("接收数据为"+commonRequest.getBody().toString());
//        Gson gson = new Gson();
//        DictionaryDataItemVO dictionaryDataItemVO = new DictionaryDataItemVO();
//        dictionaryDataItemVO.setId((long) 555);
//        dictionaryDataItemVO = gson.fromJson((String) commonRequest.getBody(),DictionaryDataItemVO.class);
//        DictionaryDTO dictionaryDTO = new DictionaryDTO();
//        BeanUtils.copyProperties(dictionaryDataItemVO, dictionaryDTO);
//        System.out.println(dictionaryDTO.toString());
//        try {
//            dictionaryService.add(dictionaryDTO);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return null;
    }

    @CrossOrigin
    @PostMapping("api/delete")
    public CommonResponse delete(CommonRequest commonRequest) {
        return null;
    }

    @CrossOrigin
    @PostMapping("api/delete1")
    public CommonResponse<String> delete1(@RequestBody CommonRequest<List<DictionaryDataItemVO>> commonRequest  ) {
        List<DictionaryDTO> dictionaryDTOS = JsonUtils.jsonToList(commonRequest.getBody().toString(),DictionaryDTO.class);
        if (commonRequest.getBody() != null){
            try {
                dictionaryService.delete(dictionaryDTOS);
                return null;
            } catch (Exception e) {
                e.printStackTrace();
            }
//            DictionaryDataItemVO dictionaryDataItemVO = (DictionaryDataItemVO)commonRequest.getBody();
//            DictionaryDTO dictionaryDTO = new DictionaryDTO();
//            BeanUtils.copyProperties(dictionaryDataItemVO, dictionaryDTO);
//            System.out.println("获得的数据为"+dictionaryDTO);
//            try {
//                return null;
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
        }
        CommonResponse<String> response = new CommonResponse<>();
        ResponseHead head = new ResponseHead();
        head.setEncryption(0);
        head.setCode("0");
        response.setResponseHead(head);
        response.setBody("33333333");
        return response;
    }

    @CrossOrigin
    @PostMapping("api/add1")
    public CommonResponse<String> add1(@RequestBody CommonRequest<DictionaryDataItemVO> commonRequest  ) {
        //返回前端的CommonResponse
        CommonResponse<String> response = new CommonResponse<>();
        //返回前端的ResponseHead
        ResponseHead head = new ResponseHead();
        //前端传输的数据不为空则调用service层
        if (commonRequest.getBody() != null){
            DictionaryDataItemVO dictionaryDataItemVO = (DictionaryDataItemVO)commonRequest.getBody();
            System.out.println("状态为"+dictionaryDataItemVO.getStatus());
            DictionaryDTO dictionaryDTO = new DictionaryDTO();
            BeanUtils.copyProperties(dictionaryDataItemVO, dictionaryDTO);
            System.out.println("获得的数据为"+dictionaryDTO);
            try {
                dictionaryService.add(dictionaryDTO);
                head.setEncryption(0);
                head.setCode("0");
                response.setResponseHead(head);
                return response;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @CrossOrigin
    @PostMapping("api/update")
    public CommonResponse update(CommonRequest<DictionaryDTO> commonRequest) {
        //返回前端的CommonResponse
        CommonResponse<String> response = new CommonResponse<>();
        //返回前端的ResponseHead
        ResponseHead head = new ResponseHead();
        //前端传输的数据不为空则调用service层
        if (commonRequest.getBody() != null){
            DictionaryDataItemVO dictionaryDataItemVO = (DictionaryDataItemVO)commonRequest.getBody();
            DictionaryDTO dictionaryDTO = new DictionaryDTO();
            BeanUtils.copyProperties(dictionaryDataItemVO, dictionaryDTO);
            try {
                dictionaryService.update(dictionaryDTO);
                head.setEncryption(0);
                head.setCode("0");
                response.setResponseHead(head);
                return response;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public CommonResponse queryByPrimaryKey(CommonRequest commonRequest) {
        return null;
    }

    public CommonResponse queryByCondition(CommonRequest commonRequest) {
        return null;
    }

    @CrossOrigin
    @GetMapping("api/dictionaries")
    public List<DictionaryDTO> list() throws Exception {
        DictionaryDTO dto = new DictionaryDTO();
        return  dictionaryService.queryByCondition(dto);
    }
}
