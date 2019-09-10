package com.bosssoft.bes.userpermission.service.impl;

import com.bosssoft.bes.base.utils.DateUtils;
import com.bosssoft.bes.base.utils.SnowFlake;
import com.bosssoft.bes.userpermission.dao.DictionaryDao;
import com.bosssoft.bes.userpermission.pojo.dto.DictionaryDTO;
import com.bosssoft.bes.userpermission.pojo.entity.Dictionary;
import com.bosssoft.bes.userpermission.service.DictionaryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author wukeqiang
 * @date 2019-09-01
 */
@Service
public class DictionaryServiceImpl implements DictionaryService {

    @Autowired
    DictionaryDao dictionaryDao;

    @Autowired
    private DataSourceTransactionManager transactionManager;

    /**
     * 新增参数
     * @param dictionaryDTO
     * @return
     * @throws Exception
     */
    public int add(DictionaryDTO dictionaryDTO)  {
        if (dictionaryDTO != null){
            //由雪花算法生成相关id
            SnowFlake snowFlake = new SnowFlake(2,3);
            dictionaryDTO.setId(snowFlake.nextId());
            //插入生成时间以及更新时间，第一次创建时两者相同
            Date createTime = DateUtils.getDate();
            Date updateTime = createTime;
            dictionaryDTO.setCreatedTime(createTime);
            dictionaryDTO.setUpdatedTime(updateTime);
            //插入创建者以及更新者，后续从redis中获取登录信息
            dictionaryDTO.setCreatedBy((long)9527);
            dictionaryDTO.setUpdatedBy((long)9527);
            //插入当前版本
            dictionaryDTO.setVersion((long)1.0);
            try {
                dictionaryDao.insert(dictionaryDTO);
                return 1;
            }catch (Exception e){
                e.printStackTrace();
                return 0;
            }
        }else {
            return 0;
        }
    }

    public int delete(List<DictionaryDTO> dictionaryDTOS)  {
        DictionaryDTO dictionaryDTO = new DictionaryDTO();
        if (dictionaryDTOS != null){
            for(DictionaryDTO attribute : dictionaryDTOS) {
                dictionaryDTO = attribute;
                System.out.println("删除的参数为"+dictionaryDTO);
                dictionaryDao.delete(dictionaryDTO);
            }
        }
        return 0;
    }

    public int update(DictionaryDTO dictionaryDTO)  {
        Long dbVersion = dictionaryDao.selectByPrimaryKey(dictionaryDTO.getId()).getVersion();
        //对比版本号，不同则抛出异常
//        if (!dictionaryDTO.getVersion().equals(dbVersion)){
//            throw new Exception();
//        }
        Dictionary dictionary = new Dictionary();
        dictionary.setUpdatedTime(DateUtils.getDate());
        BeanUtils.copyProperties(dictionaryDTO,dictionary);
        return dictionaryDao.updateByPrimaryKeySelective(dictionary);
    }

    /**
     * 通过id查询
     * @param id
     * @return
     * @throws Exception
     */
    public DictionaryDTO getByPrimaryKey(Long id)  {
        Dictionary dictionary = dictionaryDao.selectByPrimaryKey(id);
        DictionaryDTO dto = new DictionaryDTO();
        BeanUtils.copyProperties(dictionary,dto);
        return dto;
    }

    public List<DictionaryDTO> queryByCondition(DictionaryDTO dictionaryDTO)  {
        Condition condition = new Condition(Dictionary.class);
        Example.Criteria criteria = condition.createCriteria();
        if (!StringUtils.isEmpty(dictionaryDTO.getName())){
            criteria.andLike("name","%"+dictionaryDTO.getName()+"%");
        }
        List<Dictionary> results = dictionaryDao.selectByExample(condition);
        List<DictionaryDTO> dtos = null;
        DictionaryDTO dto = null;
        if (results != null) {
            dtos = new ArrayList<DictionaryDTO>(results.size());
            for (Dictionary result : results){
                //此处new的做法有待商讨……
                dto = new DictionaryDTO();
                BeanUtils.copyProperties(result, dto);
                dtos.add(dto);
            }
        } else {
            dtos = new ArrayList<DictionaryDTO>();
        }
        return dtos;
    }

    public List<DictionaryDTO> queryAll()  {
        List<DictionaryDTO> dtos = null;
        List<Dictionary> dictionaries = dictionaryDao.selectAll();
        DictionaryDTO dto = null;
        if (dictionaries != null){
            dtos = new ArrayList<DictionaryDTO>(dictionaries.size());
            for (Dictionary dictionary:dictionaries){
                dto = new DictionaryDTO();
                BeanUtils.copyProperties(dictionary,dto);
                dtos.add(dto);
            }
        }
        System.out.println("返回的dto是"+dictionaries.toString());
        return dtos;
    }

    public int delete(DictionaryDTO dictionaryDTO) {
        return 0;
    }
}
