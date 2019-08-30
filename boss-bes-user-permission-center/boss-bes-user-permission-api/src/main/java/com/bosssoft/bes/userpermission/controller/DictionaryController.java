package com.bosssoft.bes.userpermission.controller;

import com.bosssoft.bes.base.coredata.vo.CommonResponse;
import com.bosssoft.bes.base.coredata.vo.CommonRequest;
import com.bosssoft.bes.base.coredata.vo.ResponseHead;

import com.bosssoft.bes.base.utils.FileUtils;
import com.bosssoft.bes.userpermission.pojo.dto.DictionaryDTO;
import com.bosssoft.bes.userpermission.pojo.entity.Dictionary;
import com.bosssoft.bes.userpermission.pojo.vo.DictionaryDataItemVO;
import com.bosssoft.bes.userpermission.service.DictionaryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DictionaryController{

    @Autowired
    private DictionaryService dictionaryService;

    @CrossOrigin
    @PostMapping("api/delete")
    public CommonResponse<String> delete(@RequestBody CommonRequest<List<DictionaryDataItemVO>> commonRequest  ) {
        //返回前端的CommonResponse
        CommonResponse<String> response = new CommonResponse<>();
        //返回前端的ResponseHead
        ResponseHead head = new ResponseHead();
        head.setEncryption(0);
        //将前端传的数据转为list
        List<DictionaryDataItemVO> voList = commonRequest.getBody();
        //前端传输的数据不为空则调用service层
        if (voList != null && voList.size()> 0){
            List<DictionaryDTO> dtoList = new ArrayList<>(voList.size());
            DictionaryDTO dictionaryDTO = null;
            for (DictionaryDataItemVO vo:voList){
                dictionaryDTO = new DictionaryDTO();
                BeanUtils.copyProperties(vo,dictionaryDTO);
                dtoList.add(dictionaryDTO);
            }
            try {
                dictionaryService.delete(dtoList);
                head.setCode("0");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        response.setResponseHead(head);
        return response;
    }

    @CrossOrigin
    @PostMapping("api/add")
    public CommonResponse<String> add(@RequestBody CommonRequest<DictionaryDataItemVO> commonRequest  ) {
        //返回前端的CommonResponse
        CommonResponse<String> response = new CommonResponse<>();
        //返回前端的ResponseHead
        ResponseHead head = new ResponseHead();
        //前端传输的数据不为空则调用service层
        if (commonRequest.getBody() != null){
            DictionaryDataItemVO dictionaryDataItemVO = commonRequest.getBody();
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
    public CommonResponse<String> update(@RequestBody CommonRequest<DictionaryDataItemVO> commonRequest) {
        //返回前端的CommonResponse
        CommonResponse<String> response = new CommonResponse<>();
        //返回前端的ResponseHead
        ResponseHead head = new ResponseHead();
        //前端传输的数据不为空则调用service层
        System.out.println("接收数据"+commonRequest.getBody());
        if (commonRequest.getBody() != null){
            DictionaryDataItemVO dictionaryDataItemVO = commonRequest.getBody();
            DictionaryDTO dictionaryDTO = new DictionaryDTO();
            BeanUtils.copyProperties(dictionaryDataItemVO, dictionaryDTO);
            System.out.println("DTO为"+dictionaryDTO);
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

    @CrossOrigin
    @GetMapping("/api/execel")
    public void export(HttpServletResponse response){
        try {
            List<DictionaryDTO> dto = dictionaryService.queryAll();
            FileUtils.exportExcel(dto,"数据字典表","导出",Dictionary.class,
                    "数据字典.xls",response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
