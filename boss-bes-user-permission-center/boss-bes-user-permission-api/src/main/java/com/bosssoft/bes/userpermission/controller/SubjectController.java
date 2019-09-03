package com.bosssoft.bes.userpermission.controller;

import com.bosssoft.bes.base.annotation.GlobalExceptionLog;
import com.bosssoft.bes.base.coredata.vo.CommonResponse;
import com.bosssoft.bes.base.coredata.vo.CommonRequest;
import com.bosssoft.bes.base.coredata.vo.ResponseHead;

import com.bosssoft.bes.base.exception.BusinessException;
import com.bosssoft.bes.base.exception.ServiceException;
import com.bosssoft.bes.base.utils.FileUtils;
import com.bosssoft.bes.userpermission.pojo.dto.SubjectAnswerDTO;
import com.bosssoft.bes.userpermission.pojo.dto.SubjectDTO;
import com.bosssoft.bes.userpermission.pojo.entity.Subject;
import com.bosssoft.bes.userpermission.pojo.entity.SubjectAnswer;
import com.bosssoft.bes.userpermission.pojo.vo.SubjectDataItemVO;
import com.bosssoft.bes.userpermission.pojo.vo.SubjectQueryConditionVO;
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

    @GlobalExceptionLog
    @CrossOrigin
    @PostMapping("api/subject/delete")
    public CommonResponse<String> delete(@RequestBody CommonRequest<List<SubjectDataItemVO>> commonRequest  ) {
        //将前端传的数据转为list
        List<SubjectDataItemVO> voList = commonRequest.getBody();
        System.out.println(commonRequest.getBody().toString());
        //前端传输的数据不为空则调用service层
        if (voList != null && voList.size()> 0){
            List<SubjectDTO> dtoList = new ArrayList<>(voList.size());
            SubjectDTO subjectDTO = null;
            //将vo转为dto后，将dto存入dto列表
            for (SubjectDataItemVO vo:voList){
                subjectDTO = new SubjectDTO();
                BeanUtils.copyProperties(vo,subjectDTO);
                dtoList.add(subjectDTO);
            }
            int result = 0;
            try {
                result = subjectService.delete(dtoList);
            }catch (ServiceException serviceException){
                throw new BusinessException(serviceException);
            }
            //返回前端的CommonResponse
            CommonResponse<String> response = new CommonResponse<>();
            //返回前端的ResponseHead
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
    @PostMapping("api/addSubject")
    public CommonResponse<String> add(@RequestBody CommonRequest<SubjectDataItemVO> commonRequest  ) {
        //传输数据不为空进入service层
        if (commonRequest.getBody() != null){
            SubjectDataItemVO subjectDataItemVO = commonRequest.getBody();
            //将题目VO转为DTO
            SubjectDTO subjectDTO = new SubjectDTO();
            BeanUtils.copyProperties(subjectDataItemVO,subjectDTO);

            //题目答案长度
            int size = subjectDataItemVO.getSubjectAnswers().size();
            //将传输信息中的answer信息存入answerdto中
            List<SubjectAnswerDTO> subjectAnswers = subjectDataItemVO.getSubjectAnswers();
            List<SubjectAnswerDTO> subjectOptions = subjectDataItemVO.getSubjectOptions();
            for (SubjectAnswerDTO dto:subjectAnswers){
                System.out.println("ansdto数据"+dto.toString());
            }
            for (SubjectAnswerDTO dto:subjectOptions){
                System.out.println("optdto数据"+dto.toString());
            }
//            SubjectDTO subjectDTO = new SubjectDTO();
//            BeanUtils.copyProperties(subjectDataItemVO, subjectDTO);
//            System.out.println("获得的数据为"+subjectDTO);
//            int result = 0;
//            try {
//                result = subjectService.add(subjectDTO);
//            } catch (ServiceException serviceException) {
//                throw new BusinessException(serviceException);
//            }
//            //返回前端的CommonResponse
//            CommonResponse<String> response = new CommonResponse<>();
//            //返回前端的ResponseHead
//            ResponseHead head = new ResponseHead();
//            //前端传输的数据不为空则调用service层
//            head.setEncryption(0);
//            head.setCode("0");
//            if (result > 0){
//                head.setMessage("增加成功");
//            }else {
//                head.setMessage("增加失败");
//            }
//            response.setResponseHead(head);
//            return response;
        }
        return null;
    }

    @GlobalExceptionLog
    @CrossOrigin
    @PostMapping("api/subject/updateSubject")
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

    @GlobalExceptionLog
    @CrossOrigin
    @PostMapping("api/subject/querySubject")
    public CommonResponse<String> query(@RequestBody CommonRequest<SubjectQueryConditionVO> commonRequest) {
        System.out.println(commonRequest.getBody());
        return null;
    }


}
