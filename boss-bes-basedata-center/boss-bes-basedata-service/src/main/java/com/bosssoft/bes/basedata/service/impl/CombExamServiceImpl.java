package com.bosssoft.bes.basedata.service.impl;

import com.bosssoft.bes.base.utils.DateUtils;
import com.bosssoft.bes.basedata.dao.CombExamDao;
import com.bosssoft.bes.basedata.dao.CombExamItemDao;
import com.bosssoft.bes.basedata.pojo.dto.CombExamDTO;
import com.bosssoft.bes.basedata.pojo.dto.CombExamItemDTO;
import com.bosssoft.bes.basedata.pojo.entity.CombExam;
import com.bosssoft.bes.basedata.pojo.entity.CombExamItem;
import com.bosssoft.bes.basedata.service.CombExamService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wukeqiang
 * @date 2019-09-01
 */
@Service
public class CombExamServiceImpl implements CombExamService {

    @Autowired
    private CombExamDao combExamDao;

    @Autowired
    private CombExamItemDao combExamItemDao;

    public int add(CombExamDTO combExamDTO) {
        return 0;
    }

    public int delete(List<CombExamDTO> combExamDTOS) {
        CombExamDTO combExamDTO = new CombExamDTO();
        if (combExamDTOS != null){
            for(CombExamDTO attribute : combExamDTOS) {
                combExamDTO = attribute;
                System.out.println("删除的配置项参数为"+combExamDTO);
                combExamDao.delete(combExamDTO);
            }
        }
        return 0;
    }

    public int update(CombExamDTO combExamDTO) {
        Long dbVersion = combExamDao.selectByPrimaryKey(combExamDTO.getId()).getVersion();
        //对比版本号，不同则抛出异常
//        if (!dictionaryDTO.getVersion().equals(dbVersion)){
//            throw new Exception();
//        }
        CombExam combExam = new CombExam();
        combExam.setUpdatedTime(DateUtils.getDate());
        BeanUtils.copyProperties(combExamDTO,combExam);
        return combExamDao.updateByPrimaryKeySelective(combExam);
    }

    public CombExamDTO getByPrimaryKey(Long id) {
        return null;
    }

    public List<CombExamDTO> queryByCondition(CombExamDTO combExamDTO) {
        return null;
    }

    public List<CombExamDTO> queryAll() {
        List<CombExamDTO> dtos = null;
        List<CombExam> combExams = combExamDao.selectAll();
        CombExamDTO dto = null;
        if (combExams != null){
            dtos = new ArrayList<CombExamDTO>(combExams.size());
            for (CombExam combExam:combExams){
                dto = new CombExamDTO();
                BeanUtils.copyProperties(combExam,dto);
                List<CombExamItemDTO> combExamItems = combExamItemDao.queryCombExamItem(dto.getId());
                dto.setCombExamItemDTOS(combExamItems);
                dtos.add(dto);
            }
        }
        return dtos;
    }

    public int delete(CombExamDTO combExamDTO) {
        return 0;
    }
}
