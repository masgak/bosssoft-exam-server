package com.bosssoft.bes.userpermission.controller;

import com.bosssoft.bes.base.annotation.GlobalExceptionLog;
import com.bosssoft.bes.base.coredata.vo.CommonRequest;
import com.bosssoft.bes.base.coredata.vo.CommonResponse;
import com.bosssoft.bes.base.coredata.vo.ResponseHead;
import com.bosssoft.bes.base.exception.BusinessException;
import com.bosssoft.bes.base.exception.ServiceException;
import com.bosssoft.bes.base.utils.SnowFlake;
import com.bosssoft.bes.userpermission.pojo.dto.CombExamDTO;
import com.bosssoft.bes.userpermission.pojo.dto.CombExamItemDTO;
import com.bosssoft.bes.userpermission.pojo.vo.CombExamDataItemVO;
import com.bosssoft.bes.userpermission.service.CombExamItemService;
import com.bosssoft.bes.userpermission.service.CombExamService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : wukeqiang
 * @version : 1.0
 * @date : 2019/9/8 0003
 */
@RestController
public class CombExamController {
    @Autowired
    private CombExamService combExamService;

    @Autowired
    private CombExamItemService combExamItemService;

    @CrossOrigin
    @GetMapping("api/loadCombExams")
    public List<CombExamDTO> list() throws Exception {
        System.out.println("查询到的数" + combExamService.queryAll());
        return combExamService.queryAll();
    }

    @GlobalExceptionLog
    @CrossOrigin
    @PostMapping("api/deleteCombExams")
    public CommonResponse<String> delete(@RequestBody CommonRequest<List<CombExamDataItemVO>> commonRequest) {
        //将前端传的数据转为list
        List<CombExamDataItemVO> voList = commonRequest.getBody();
        System.out.println(commonRequest.getBody().toString());

        if (voList != null && voList.size() > 0) {
            //组卷配置DTO
            List<CombExamDTO> combExamDTOList = new ArrayList<>(voList.size());
            //组卷配置项DTO
            List<CombExamItemDTO> combExamItemDTOList = new ArrayList<>();
            //记录配置项ID列表
            List<CombExamItemDTO> combItemIdList = new ArrayList<>();

            CombExamDTO combExamDTO = null;
            //将vo转为dto后，将dto存入dto列表
            for (CombExamDataItemVO vo : voList) {
                combExamDTO = new CombExamDTO();
                BeanUtils.copyProperties(vo, combExamDTO);
                combExamDTOList.add(combExamDTO);
                //获取该配置的所有子项，再根据子项ID先删除子项
                combItemIdList = combExamItemService.queryItemId(combExamDTO.getId());
                combExamItemDTOList.addAll(combItemIdList);
            }
            System.out.println("删除的子项数据"+combExamDTOList.toString());
            //先删除该配置项下的子项
            int answerResult = 0;
            try {
                answerResult = combExamItemService.delete(combExamItemDTOList);
            } catch (ServiceException serviceException) {
                throw new BusinessException(serviceException);
            }

            int combExamResult = 0;
            try {
                combExamResult = combExamService.delete(combExamDTOList);
            }catch (ServiceException serviceException){
                throw new BusinessException(serviceException);
            }
            //返回前端的CommonResponse
            CommonResponse<String> response = new CommonResponse<>();
            //返回前端的ResponseHead
            ResponseHead head = new ResponseHead();
            head.setCode("0");
            //在相应头中插入提示信息
            if (combExamResult>0){
                head.setMessage("配置删除成功");
            }else {
                head.setMessage("配置删除失败");
            }
            response.setResponseHead(head);
            return response;
        }
        return null;
    }

    @GlobalExceptionLog
    @CrossOrigin
    @PostMapping("api/updateCombExam")
    public CommonResponse<String> update(@RequestBody CommonRequest<CombExamDTO> commonRequest  ) {
        //传输数据不为空进入service层
        if (commonRequest.getBody() != null){
//            CombExamItemDTO subjectDataItemVO = commonRequest.getBody();
//            System.out.println("VO接收的数据为"+subjectDataItemVO);
            //将VO转为DTO
            CombExamDTO combExamDTO = commonRequest.getBody();
            System.out.println("更新DTO为"+combExamDTO.toString());
            int result = 0;
            try {
                result = combExamService.update(combExamDTO);
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
                head.setMessage("配置项更新成功");
            }else {
                head.setMessage("配置项更新失败");
            }
            response.setResponseHead(head);
            return response;
        }
        return null;
    }
}
