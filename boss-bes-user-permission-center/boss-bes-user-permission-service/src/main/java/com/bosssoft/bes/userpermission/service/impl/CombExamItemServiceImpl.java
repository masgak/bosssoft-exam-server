package com.bosssoft.bes.userpermission.service.impl;

import com.bosssoft.bes.userpermission.dao.CombExamItemDao;
import com.bosssoft.bes.userpermission.pojo.dto.CombExamDTO;
import com.bosssoft.bes.userpermission.pojo.dto.CombExamItemDTO;
import com.bosssoft.bes.userpermission.pojo.entity.CombExamItem;
import com.bosssoft.bes.userpermission.service.CombExamItemService;
import com.bosssoft.bes.userpermission.service.CombExamService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wukeqiang
 * @date 2019-09-01
 */
@Service
public class CombExamItemServiceImpl implements CombExamItemService {

    @Autowired
    private CombExamItemDao combExamItemDao;

    public int add(CombExamItemDTO combExamItemDTO) {
        if (combExamItemDTO != null) {
            try {
                combExamItemDao.insert(combExamItemDTO);
                return 1;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public int delete(List<CombExamItemDTO> combExamItemDTOS) {
        CombExamItemDTO combExamItemDTO = new CombExamItemDTO();
        if (combExamItemDTOS != null){
            for(CombExamItemDTO attribute : combExamItemDTOS) {
                combExamItemDTO = attribute;
                System.out.println("删除的子项为"+combExamItemDTO);
                combExamItemDao.delete(combExamItemDTO);
            }
        }
        return 0;
    }

    public int update(CombExamItemDTO combExamItemDTO) {
        CombExamItem combExamItem =new CombExamItem();
        BeanUtils.copyProperties(combExamItemDTO,combExamItem);
        if (combExamItemDTO!=null){
            try{
                return combExamItemDao.updateByPrimaryKeySelective(combExamItem);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return 0;
    }

    public CombExamItemDTO getByPrimaryKey(Long id) {
        return null;
    }

    public List<CombExamItemDTO> queryByCondition(CombExamItemDTO combExamItemDTO) {
        return null;
    }

    public List<CombExamItemDTO> queryAll() {
        return null;
    }

    public int delete(CombExamItemDTO combExamItemDTO) {
        try {
            System.out.println("删除的值"+combExamItemDTO);
            combExamItemDao.delete(combExamItemDTO);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public List<CombExamItemDTO> queryItemId(Long combExamId) {
        List<CombExamItemDTO> results = combExamItemDao.queryItemId(combExamId);
        System.out.println(results);
        return results;
    }
}
