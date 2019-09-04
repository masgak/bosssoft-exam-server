package com.bosssoft.bes.userpermission.controller;

import com.bosssoft.bes.base.annotation.GlobalExceptionLog;
import com.bosssoft.bes.base.coredata.vo.CommonResponse;
import com.bosssoft.bes.base.coredata.vo.CommonRequest;
import com.bosssoft.bes.base.coredata.vo.ResponseHead;

import com.bosssoft.bes.base.exception.BusinessException;
import com.bosssoft.bes.base.exception.ServiceException;
import com.bosssoft.bes.base.utils.FileUtils;
import com.bosssoft.bes.userpermission.pojo.dto.DictionaryDTO;
import com.bosssoft.bes.userpermission.pojo.entity.Dictionary;
import com.bosssoft.bes.userpermission.pojo.vo.DictionaryDataItemVO;
import com.bosssoft.bes.userpermission.pojo.vo.DictionaryQueryConditionVO;
import com.bosssoft.bes.userpermission.service.DictionaryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wukeqiang
 * @date 2019-08-28 9:30
 */
@RestController
public class DictionaryController{

    @Autowired
    private DictionaryService dictionaryService;

    private String filename="数据字典";

    @GlobalExceptionLog
    @CrossOrigin
    @PostMapping("api/delete")
    public CommonResponse<String> delete(@RequestBody CommonRequest<List<DictionaryDataItemVO>> commonRequest  ) {
        //将前端传的数据转为list
        List<DictionaryDataItemVO> voList = commonRequest.getBody();
        System.out.println(commonRequest.getBody().toString());
        //前端传输的数据不为空则调用service层
        if (voList != null && voList.size()> 0){
            List<DictionaryDTO> dtoList = new ArrayList<>(voList.size());
            DictionaryDTO dictionaryDTO = null;
            //将vo转为dto后，将dto存入dto列表
            for (DictionaryDataItemVO vo:voList){
                dictionaryDTO = new DictionaryDTO();
                BeanUtils.copyProperties(vo,dictionaryDTO);
                dtoList.add(dictionaryDTO);
            }
            int result = 0;
            try {
                result = dictionaryService.delete(dtoList);
            }catch (ServiceException serviceException){
                throw new BusinessException(serviceException);
            }
            //CommonResponse
            CommonResponse<String> response = new CommonResponse<>();
            //ResponseHead
            ResponseHead head = new ResponseHead();
            head.setEncryption(0);
            head.setCode("0");
            //在相应头中插入提示信息
            if (result>0){
                head.setMessage("删除成功");
            }else {
                head.setMessage("删除失败");
            }
            response.setResponseHead(head);
            return response;
        }
        return null;
    }

    @GlobalExceptionLog
    @CrossOrigin
    @PostMapping("api/addDictionary")
    public CommonResponse<String> add(@RequestBody CommonRequest<DictionaryDataItemVO> commonRequest  ) {
        //传输数据不为空进入service层
        if (commonRequest.getBody() != null){
            DictionaryDataItemVO dictionaryDataItemVO = commonRequest.getBody();
            System.out.println("状态为"+dictionaryDataItemVO.getStatus());
            DictionaryDTO dictionaryDTO = new DictionaryDTO();
            BeanUtils.copyProperties(dictionaryDataItemVO, dictionaryDTO);
            System.out.println("获得的数据为"+dictionaryDTO);
            int result = 0;
            try {
                result = dictionaryService.add(dictionaryDTO);
            } catch (ServiceException serviceException) {
                throw new BusinessException(serviceException);
            }
            //返回前端的CommonResponse
            CommonResponse<String> response = new CommonResponse<>();
            //返回前端的ResponseHead
            ResponseHead head = new ResponseHead();
            //前端传输的数据不为空则调用service层
            head.setEncryption(0);
            head.setCode("0");
            if (result > 0){
                head.setMessage("增加成功");
            }else {
                head.setMessage("增加失败");
            }
            response.setResponseHead(head);
            return response;
        }
        return null;
    }

    @GlobalExceptionLog
    @CrossOrigin
    @PostMapping("api/updateDictionary")
    public CommonResponse<String> update(@RequestBody CommonRequest<DictionaryDataItemVO> commonRequest) {
        //前端传输的数据不为空则调用service层
        if (commonRequest.getBody() != null){
            DictionaryDataItemVO dictionaryDataItemVO = commonRequest.getBody();
            DictionaryDTO dictionaryDTO = new DictionaryDTO();
            BeanUtils.copyProperties(dictionaryDataItemVO, dictionaryDTO);
            System.out.println("DTO为"+dictionaryDTO);
            int result = 0;
            try {
                result = dictionaryService.update(dictionaryDTO);
            } catch (ServiceException serviceException) {
                throw new BusinessException(serviceException);
            }
            //返回前端的CommonResponse
            CommonResponse<String> response = new CommonResponse<>();
            //返回前端的ResponseHead
            ResponseHead head = new ResponseHead();
            head.setEncryption(0);
            head.setCode("0");
            if (result > 0){
                head.setMessage("更改成功");
            }else {
                head.setMessage("更改失败");
            }
            response.setResponseHead(head);
            return response;
        }
        return null;
    }

    public CommonResponse queryByPrimaryKey(CommonRequest commonRequest) {
        return null;
    }

    @CrossOrigin
    @GetMapping("api/loadDictionaries")
    public List<DictionaryDTO> list() throws Exception {
        DictionaryDTO dto = new DictionaryDTO();
        return  dictionaryService.queryByCondition(dto);
    }

    @GlobalExceptionLog
    @CrossOrigin
    @GetMapping("api/excelDictionary")
    public void export(HttpServletResponse response){
        try {
            List<DictionaryDTO> dto = dictionaryService.queryAll();
            FileUtils.exportExcel(dto,"数据字典表","导出",Dictionary.class,
                    filename+".xls",response);
        }catch (ServiceException serviceException){
            throw new BusinessException(serviceException);
        }
    }

    @GlobalExceptionLog
    @CrossOrigin
    @PostMapping("api/queryDictionary")
    public CommonResponse<String> query(@RequestBody CommonRequest<DictionaryQueryConditionVO> commonRequest) {
        System.out.println(commonRequest.getBody());
        return null;
    }

    @GlobalExceptionLog
    @CrossOrigin
    @PostMapping("api/setDictionaryFilename")
    public void setFilename(@RequestBody String filename) throws UnsupportedEncodingException {
        this.filename = URLDecoder.decode(filename.substring(0,filename.length()-1), "UTF-8");
    }
}
