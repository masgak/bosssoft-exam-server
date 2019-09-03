package com.bosssoft.bes.userpermission.controller;

import com.bosssoft.bes.base.annotation.GlobalExceptionLog;
import com.bosssoft.bes.base.coredata.vo.CommonRequest;
import com.bosssoft.bes.base.coredata.vo.CommonResponse;
import com.bosssoft.bes.base.coredata.vo.ResponseHead;
import com.bosssoft.bes.base.exception.BusinessException;
import com.bosssoft.bes.base.exception.ServiceException;
import com.bosssoft.bes.base.logging.annotation.ApiLog;
import com.bosssoft.bes.base.utils.FileUtils;
import com.bosssoft.bes.userpermission.pojo.dto.CategoryDTO;
import com.bosssoft.bes.userpermission.pojo.entity.Category;
import com.bosssoft.bes.userpermission.pojo.vo.CategoryDataItemVO;
import com.bosssoft.bes.userpermission.pojo.vo.CategoryQueryConditionVO;
import com.bosssoft.bes.userpermission.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : huangyuhui
 * @version : 1.0
 * @date : 2019/9/3 0003
 */
@RestController
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	private String filename="题目类别";

	@GlobalExceptionLog
	@CrossOrigin
	@PostMapping("api/deleteCategories")
	@ApiLog
	public CommonResponse<String> delete(@RequestBody CommonRequest<List<CategoryDataItemVO>> commonRequest){
		List<CategoryDataItemVO> volist= commonRequest.getBody();
		if(volist!=null && volist.size()>0){
			//vo列表转dto列表
			List<CategoryDTO> dtos=new ArrayList<CategoryDTO>();
			CategoryDTO categoryDTO=null;
			for(CategoryDataItemVO vo: volist){
				categoryDTO=new CategoryDTO();
				BeanUtils.copyProperties(vo,categoryDTO);
				dtos.add(categoryDTO);
			}
			//调用service里面的对应方法进行删除
			int result=0;
			try {
				result = categoryService.delete(dtos);
			}catch (ServiceException serviceException){
				//抛出自定义异常
				throw new BusinessException(serviceException);
			}
			//返回CommonResponse给前端
			CommonResponse<String> response=new CommonResponse<>();
			ResponseHead head = new ResponseHead();
			head.setEncryption(0);
			head.setCode("0");
			//
			if(result>0){
				head.setMessage("删除类别成功");
			}else{
				head.setMessage("删除类别失败");
			}
			response.setResponseHead(head);
			return response;
		}
		return null;
	}

	@GlobalExceptionLog
	@CrossOrigin
	@PostMapping("api/addCategory")
	@ApiLog
	public CommonResponse<String> add(@RequestBody CommonRequest<CategoryDataItemVO> commonRequest ){
		CategoryDataItemVO vo=commonRequest.getBody();
		if(vo!=null) {
			CategoryDTO categoryDTO = new CategoryDTO();
			BeanUtils.copyProperties(vo, categoryDTO);
			int result = 0;
			try {
				result = categoryService.add(categoryDTO);
			} catch (ServiceException serviceException) {
				throw new BusinessException(serviceException);
			}
			//返回CommonResponse给前端
			CommonResponse<String> response = new CommonResponse<>();
			ResponseHead head = new ResponseHead();
			head.setEncryption(0);
			head.setCode("0");
			//
			if (result > 0) {
				head.setMessage("增加类别成功");
			} else {
				head.setMessage("增加类别失败");
			}
			response.setResponseHead(head);
			return response;
		}
		return  null;
	}

	@GlobalExceptionLog
	@CrossOrigin
	@PostMapping("api/updateCategory")
	@ApiLog
	public CommonResponse<String> update(@RequestBody CommonRequest<CategoryDataItemVO> commonRequest){
		CategoryDataItemVO vo=commonRequest.getBody();
		if(vo!=null) {
			CategoryDTO categoryDTO = new CategoryDTO();
			BeanUtils.copyProperties(vo, categoryDTO);
			int result = 0;
			try {
				result = categoryService.update(categoryDTO);
			} catch (ServiceException serviceException) {
				throw new BusinessException(serviceException);
			}
			//返回CommonResponse给前端
			CommonResponse<String> response = new CommonResponse<>();
			ResponseHead head = new ResponseHead();
			head.setEncryption(0);
			head.setCode("0");
			//
			if (result > 0) {
				head.setMessage("修改类别成功");
			} else {
				head.setMessage("修改类别失败");
			}
			response.setResponseHead(head);
			return response;
		}
		return  null;
	}


	@CrossOrigin
	@GetMapping("api/loadCategories")
	@ApiLog
	public List<CategoryDTO> list() throws Exception {
		CategoryDTO dto = new CategoryDTO();
		return  categoryService.queryByCondition(dto);
	}

	@GlobalExceptionLog
	@CrossOrigin
	@PostMapping("api/queryCategory")
	@ApiLog
	public CommonResponse<String> query(@RequestBody CommonRequest<CategoryQueryConditionVO> commonRequest) {
		System.out.println(commonRequest.getBody());
		return null;
	}

	@GlobalExceptionLog
	@CrossOrigin
	@GetMapping("api/excelCategory")
	public void export(HttpServletResponse response){
		try {
			List<CategoryDTO> dto = categoryService.queryAll();
			FileUtils.exportExcel(dto,"题目类型表","导出", Category.class,
					filename+".xls",response);
		}catch (ServiceException serviceException){
			throw new BusinessException(serviceException);
		}
	}



	@GlobalExceptionLog
	@CrossOrigin
	@PostMapping("api/setCategoryFilename")
	public void setFilename(@RequestBody String filename) throws UnsupportedEncodingException {
		this.filename = URLDecoder.decode(filename.substring(0,filename.length()-1), "UTF-8");
	}

}
