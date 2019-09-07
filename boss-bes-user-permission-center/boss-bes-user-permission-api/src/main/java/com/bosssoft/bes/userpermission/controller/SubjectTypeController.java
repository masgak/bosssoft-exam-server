package com.bosssoft.bes.userpermission.controller;

import com.bosssoft.bes.base.annotation.GlobalExceptionLog;
import com.bosssoft.bes.base.coredata.vo.CommonRequest;
import com.bosssoft.bes.base.coredata.vo.CommonResponse;
import com.bosssoft.bes.base.coredata.vo.ResponseHead;
import com.bosssoft.bes.base.exception.BusinessException;
import com.bosssoft.bes.base.exception.ServiceException;
import com.bosssoft.bes.base.logging.annotation.ApiLog;
import com.bosssoft.bes.base.utils.FileUtils;
import com.bosssoft.bes.userpermission.pojo.dto.SubjectTypeDTO;
import com.bosssoft.bes.userpermission.pojo.entity.SubjectType;
import com.bosssoft.bes.userpermission.pojo.vo.SubjectTypeDataItemVO;
import com.bosssoft.bes.userpermission.pojo.vo.SubjectTypeQueryConditionVO;
import com.bosssoft.bes.userpermission.service.SubjectTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : huangyuhui
 * @version : 1.0
 * @date : 2019/9/1 0002
 */
@RestController
public class SubjectTypeController {
	@Autowired
	private SubjectTypeService subjectTypeService;

	private String filename="题型";

	@GlobalExceptionLog
	@CrossOrigin
	@PostMapping("api/deleteSubjectTypes")
	@ApiLog
	public CommonResponse<String> delete(@RequestBody CommonRequest<List<SubjectTypeDataItemVO>> commonRequest  ) {
		//将前端传的数据转为list
		List<SubjectTypeDataItemVO> voList = commonRequest.getBody();
		//前端传输的数据不为空则调用service层
		if (voList != null && voList.size()> 0){
			List<SubjectTypeDTO> dtoList = new ArrayList<SubjectTypeDTO>(voList.size());
			SubjectTypeDTO subjectTypeDTO = null;
			//将vo转为dto后，将dto存入dto列表
			for (SubjectTypeDataItemVO vo:voList){
				subjectTypeDTO = new SubjectTypeDTO();
				BeanUtils.copyProperties(vo,subjectTypeDTO);
				dtoList.add(subjectTypeDTO);
			}
			int result = 0;
			try {
				result = subjectTypeService.delete(dtoList);
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
	@PostMapping("api/addSubjectType")
	@ApiLog
	public CommonResponse<String> add(@RequestBody CommonRequest<SubjectTypeDataItemVO> commonRequest  ) {
		//传输数据不为空进入service层
		if (commonRequest.getBody() != null){
			SubjectTypeDataItemVO subjectTypeDataItemVO = commonRequest.getBody();
			System.out.println("状态为"+subjectTypeDataItemVO.getStatus());
			SubjectTypeDTO subjectTypeDTO = new SubjectTypeDTO();
			BeanUtils.copyProperties(subjectTypeDataItemVO, subjectTypeDTO);
			System.out.println("获得的数据为"+subjectTypeDTO);
			int result = 0;
			try {
				result = subjectTypeService.add(subjectTypeDTO);
			} catch (ServiceException serviceException) {
				throw new BusinessException(serviceException);
			}
			CommonResponse<String> response = new CommonResponse<>();
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
	@PostMapping("api/updateSubjectType")
	@ApiLog
	public CommonResponse<String> update(@RequestBody CommonRequest<SubjectTypeDataItemVO> commonRequest) {
		//前端传输的数据不为空则调用service层
		if (commonRequest.getBody() != null){
			SubjectTypeDataItemVO subjectTypeDataItemVO = commonRequest.getBody();
			SubjectTypeDTO subjectTypeDTO = new SubjectTypeDTO();
			BeanUtils.copyProperties(subjectTypeDataItemVO, subjectTypeDTO);
			int result = 0;
			try {
				result = subjectTypeService.update(subjectTypeDTO);
			} catch (ServiceException serviceException) {
				throw new BusinessException(serviceException);
			}
			CommonResponse<String> response = new CommonResponse<>();
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

//	public CommonResponse queryByPrimaryKey(CommonRequest commonRequest) {
//		return null;
//	}

	@CrossOrigin
	@GetMapping("api/loadSubjectTypes")
	@ApiLog
	public List<SubjectTypeDTO> list() throws Exception {
		SubjectTypeDTO dto = new SubjectTypeDTO();
		return  subjectTypeService.queryByCondition(dto);
	}

	@GlobalExceptionLog
	@CrossOrigin
	@GetMapping("api/excelSubjectType")
	public void export(HttpServletResponse response){
		try {
			List<SubjectTypeDTO> dto = subjectTypeService.queryAll();
			FileUtils.exportExcel(dto,"题型表","导出",SubjectType.class,
					filename+".xls",response);
		}catch (ServiceException serviceException){
			throw new BusinessException(serviceException);
		}
	}

	@GlobalExceptionLog
	@CrossOrigin
	@PostMapping("api/querySubjectType")
	@ApiLog
	public List<SubjectTypeDTO> query(@RequestBody CommonRequest<SubjectTypeQueryConditionVO> commonRequest) {
		//System.out.println(commonRequest.getBody());
		SubjectTypeQueryConditionVO vo=commonRequest.getBody();
		if(vo!=null){
			SubjectTypeDTO dto=new SubjectTypeDTO();
			BeanUtils.copyProperties(vo,dto);
			List<SubjectTypeDTO> list=subjectTypeService.queryByCondition(dto);
			return list;
		}
		return null;
	}

	@GlobalExceptionLog
	@CrossOrigin
	@PostMapping("api/setSubjectTypeFilename")
	public void setFilename(@RequestBody String filename) throws UnsupportedEncodingException {
		this.filename = URLDecoder.decode(filename.substring(0,filename.length()-1), "UTF-8");
	}
}
