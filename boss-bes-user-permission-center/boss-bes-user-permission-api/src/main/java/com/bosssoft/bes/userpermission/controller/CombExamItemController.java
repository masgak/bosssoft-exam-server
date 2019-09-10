package com.bosssoft.bes.userpermission.controller;

import com.bosssoft.bes.base.annotation.GlobalExceptionLog;
import com.bosssoft.bes.base.coredata.vo.CommonRequest;
import com.bosssoft.bes.base.coredata.vo.CommonResponse;
import com.bosssoft.bes.base.coredata.vo.ResponseHead;
import com.bosssoft.bes.base.exception.BusinessException;
import com.bosssoft.bes.base.exception.ServiceException;
import com.bosssoft.bes.base.utils.SnowFlake;
import com.bosssoft.bes.userpermission.pojo.dto.CombExamItemDTO;
import com.bosssoft.bes.userpermission.service.CombExamItemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : wukeqiang
 * @version : 1.0
 * @date : 2019/9/8 0003
 */
@RestController
public class CombExamItemController {
    @Autowired
    private CombExamItemService combExamItemService;

    @GlobalExceptionLog
    @CrossOrigin
    @PostMapping("api/addCombExamItem")
    public CommonResponse<String> add(@RequestBody CommonRequest<CombExamItemDTO> commonRequest  ) {
        //传输数据不为空进入service层
        if (commonRequest.getBody() != null){
//            CombExamItemDTO subjectDataItemVO = commonRequest.getBody();
//            System.out.println("VO接收的数据为"+subjectDataItemVO);
            //将VO转为DTO
            CombExamItemDTO combExamItemDTO = commonRequest.getBody();
            //为题目DTO赋予ID用于传给答案DTO
            SnowFlake snowFlake = new SnowFlake(2,3);
            combExamItemDTO.setId(snowFlake.nextId());
            int result = 0;
            try {
                result = combExamItemService.add(combExamItemDTO);
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
                head.setMessage("配置项详情增加成功");
            }else {
                head.setMessage("配置项详情增加失败");
            }
            response.setResponseHead(head);
            return response;
        }
        return null;
    }

    @GlobalExceptionLog
    @CrossOrigin
    @PostMapping("api/updateCombExamItem")
    public CommonResponse<String> update(@RequestBody CommonRequest<CombExamItemDTO> commonRequest  ) {
        //传输数据不为空进入service层
        if (commonRequest.getBody() != null){
//            CombExamItemDTO subjectDataItemVO = commonRequest.getBody();
//            System.out.println("VO接收的数据为"+subjectDataItemVO);
            //将VO转为DTO
            CombExamItemDTO combExamItemDTO = commonRequest.getBody();
            System.out.println("更新DTO为"+combExamItemDTO.toString());
            int result = 0;
            try {
                result = combExamItemService.update(combExamItemDTO);
            } catch (ServiceException serviceException) {
                throw new BusinessException(serviceException);
            }
            //返回前端的CommonResponse
            CommonResponse<String> response = new CommonResponse<>();
            //返回的ResponseHead
            ResponseHead head = new ResponseHead();
            //前端传输的数据不为空则调用service层
            head.setMessage("ss");
            head.setEncryption(0);
            head.setCode("0");
            if (result > 0){
                head.setMessage("配置项详情更新成功");
            }else {
                head.setMessage("配置项详情更新失败");
            }
            response.setResponseHead(head);
            return response;
        }
        return null;
    }

    @GlobalExceptionLog
    @CrossOrigin
    @PostMapping("api/deleteCombExamItem")
    public CommonResponse<String> delete(@RequestBody CommonRequest<CombExamItemDTO> commonRequest  ) {
        //前端传输的数据不为空则调用service层
        if (commonRequest.getBody()!=null){
            CombExamItemDTO combExamItemDTO = commonRequest.getBody();
            int result = 0;
            try {
                result = combExamItemService.delete(combExamItemDTO);
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
}
