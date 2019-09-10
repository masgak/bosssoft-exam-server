package com.bosssoft.bes.userpermission.controller;

import com.bosssoft.bes.base.annotation.GlobalExceptionLog;
import com.bosssoft.bes.base.coredata.vo.CommonResponse;
import com.bosssoft.bes.base.coredata.vo.CommonRequest;
import com.bosssoft.bes.base.coredata.vo.ResponseHead;

import com.bosssoft.bes.base.exception.BusinessException;
import com.bosssoft.bes.base.exception.ServiceException;
import com.bosssoft.bes.base.utils.FileUtils;
import com.bosssoft.bes.base.utils.SnowFlake;
import com.bosssoft.bes.userpermission.pojo.dto.SubjectAnswerDTO;
import com.bosssoft.bes.userpermission.pojo.dto.SubjectDTO;
import com.bosssoft.bes.userpermission.pojo.entity.Subject;
import com.bosssoft.bes.userpermission.pojo.entity.SubjectAnswer;
import com.bosssoft.bes.userpermission.pojo.vo.SubjectDataItemVO;
import com.bosssoft.bes.userpermission.pojo.vo.SubjectQueryConditionVO;
import com.bosssoft.bes.userpermission.service.SubjectAnswerService;
import com.bosssoft.bes.userpermission.service.SubjectService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wukeqiang
 * @date 2019-09-01
 */
@RestController
public class SubjectController{

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private SubjectAnswerService subjectAnswerService;

    @GlobalExceptionLog
    @CrossOrigin
    @PostMapping("api/deleteSubjects")
    public CommonResponse<String> delete(@RequestBody CommonRequest<List<SubjectDataItemVO>> commonRequest  ) {
        //将前端传的数据转为list
        List<SubjectDataItemVO> voList = commonRequest.getBody();
        System.out.println(commonRequest.getBody().toString());
        //前端传输的数据不为空则调用service层
        if (voList != null && voList.size()> 0){
            List<SubjectDTO> subjectDTOList = new ArrayList<>(voList.size());
            List<SubjectAnswerDTO> subjectAnswerDTOS = new ArrayList<>();
            //记录题目答案ID列表
            List<SubjectAnswerDTO> answerIdList = new ArrayList<>();

            SubjectDTO subjectDTO = null;
            //将vo转为dto后，将dto存入dto列表
            for (SubjectDataItemVO vo:voList){
                subjectDTO = new SubjectDTO();
                BeanUtils.copyProperties(vo,subjectDTO);
                subjectDTOList.add(subjectDTO);
                //获取该题目的所有答案ID，再根据答案ID先删除答案
                answerIdList = subjectAnswerService.queryAnswerId(subjectDTO.getId());
                subjectAnswerDTOS.addAll(answerIdList);
            }
            //删除计数器
            int answerResult = 0;
            try {
                answerResult = subjectAnswerService.delete(subjectAnswerDTOS);
            }catch (ServiceException serviceException){
                throw new BusinessException(serviceException);
            }

            int subjectResult = 0;
            try {
                subjectResult = subjectService.delete(subjectDTOList);
            }catch (ServiceException serviceException){
                throw new BusinessException(serviceException);
            }
            //返回前端的CommonResponse
            CommonResponse<String> response = new CommonResponse<>();
            //返回前端的ResponseHead
            ResponseHead head = new ResponseHead();
            head.setCode("0");
            //在相应头中插入提示信息
            if (subjectResult>0){
                head.setMessage("题目删除成功");
            }else {
                head.setMessage("题目删除失败");
            }
            response.setResponseHead(head);
            return response;
        }
        return null;
    }

    @GlobalExceptionLog
    @CrossOrigin
    @PostMapping("api/addSubject")
    public CommonResponse<String> add(@RequestBody CommonRequest<SubjectDataItemVO> commonRequest  ) {
        //传输数据不为空进入service层
        if (commonRequest.getBody() != null){
            SubjectDataItemVO subjectDataItemVO = commonRequest.getBody();
            System.out.println("VO接收的数据为"+subjectDataItemVO);
            //将题目VO转为DTO
            SubjectDTO subjectDTO = new SubjectDTO();
            BeanUtils.copyProperties(subjectDataItemVO,subjectDTO);
            System.out.println("DTO接收到的数据为"+subjectDTO);
            //为题目DTO赋予ID用于传给答案DTO
            SnowFlake snowFlake = new SnowFlake(2,3);
            subjectDTO.setId(snowFlake.nextId());
			int result = 0;
			try {
				result = subjectService.add(subjectDTO);
			} catch (ServiceException serviceException) {
				throw new BusinessException(serviceException);
			}

            //将传输信息中的answer信息存入answerdto中
            List<SubjectAnswerDTO> subjectAnswerDTOs = subjectDataItemVO.getSubjectAnswers();
			//判断该题目是否有答案
			if(subjectAnswerDTOs!=null){
                SubjectAnswerDTO subjectAnswerDTO = null;
                for (SubjectAnswerDTO dto:subjectAnswerDTOs){
                    //将题目ID存入答案中
                    dto.setSubjectId(subjectDTO.getId());
                    //将题目答案DTO存入数据库中
                    subjectAnswerService.add(dto);
                }
            }
           //返回前端的CommonResponse
           CommonResponse<String> response = new CommonResponse<>();
           //返回前端的ResponseHead
           ResponseHead head = new ResponseHead();
           //前端传输的数据不为空则调用service层
           head.setEncryption(0);
           head.setCode("0");
           if (result > 0){
               head.setMessage("题目增加成功");
           }else {
               head.setMessage("题目增加失败");
           }
           response.setResponseHead(head);
           return response;
        }
        return null;
    }

    @GlobalExceptionLog
    @CrossOrigin
    @PostMapping("api/querySubject")
    public List<SubjectDTO> query(@RequestBody CommonRequest<SubjectQueryConditionVO> commonRequest) {
        SubjectQueryConditionVO vo=commonRequest.getBody();
        if(vo!=null){
            SubjectDTO dto=new SubjectDTO();
            BeanUtils.copyProperties(vo,dto);
            System.out.println(dto);
            List<SubjectDTO> list=subjectService.queryByCondition(dto);
            System.out.println("查询到的DTO为"+list.toString());
            return list;
        }
        return null;
    }

//    @GlobalExceptionLog
//    @CrossOrigin
//    @PostMapping("api/querySubject")
//    public CommonResponse<String> query(@RequestBody CommonRequest<SubjectQueryConditionVO> commonRequest) {
//        //返回前端的CommonResponse,查询的VO应放在response.body中
//        CommonResponse<String> response = new CommonResponse<>();
//        //前端传输的数据不为空则调用service层
//        if (commonRequest.getBody() != null) {
//            SubjectQueryConditionVO subjectQueryConditionVO = commonRequest.getBody();
//            System.out.println("查询VO数据为"+subjectQueryConditionVO);
//            //将查询VO转为DTO
//            SubjectDTO subjectDTO = new SubjectDTO();
//            BeanUtils.copyProperties(subjectQueryConditionVO,subjectDTO);
//            System.out.println("DTO接收到的数据为"+subjectDTO);
//            try{
//                subjectService.queryByCondition(subjectDTO);
//            }catch (ServiceException serviceException){
//                throw new BusinessException(serviceException);
//            }
//            //返回前端的ResponseHead
//            ResponseHead head = new ResponseHead();
//            //前端传输的数据不为空则调用service层
//            head.setEncryption(0);
//            head.setCode("0");
//            return response;
//        }
//        return null;
//    }

    @GlobalExceptionLog
    @CrossOrigin
    @PostMapping("api/updateSubject")
    public CommonResponse<String> update(@RequestBody CommonRequest<SubjectDataItemVO> commonRequest) {
        //前端传输的数据不为空则调用service层
        if (commonRequest.getBody() != null){
            SubjectDataItemVO subjectDataItemVO = commonRequest.getBody();
            SubjectDTO subjectDTO = new SubjectDTO();
            BeanUtils.copyProperties(subjectDataItemVO, subjectDTO);
            System.out.println("DTO为"+subjectDTO);
            int result = 0;
            try {
                result = subjectService.update(subjectDTO);
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
    @GetMapping("api/loadSubjects")
    public List<SubjectDTO> list() throws Exception {
        return subjectService.queryAll();
    }

    @GlobalExceptionLog
    @CrossOrigin
    @GetMapping("api/subject/execel")
    public void export(HttpServletResponse response){
        try {
            List<SubjectDTO> dto = subjectService.queryAll();
            FileUtils.exportExcel(dto,"数据字典表","导出",Subject.class,
                    "数据字典.xls",response);
        }catch (ServiceException serviceException){
            throw new BusinessException(serviceException);
        }
    }


}
