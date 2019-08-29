package com.bosssoft.bes.userpermission.service.impl;

import com.bosssoft.bes.userpermission.dao.OrganizationDao;
import com.bosssoft.bes.userpermission.pojo.dto.OrganizationDTO;
import com.bosssoft.bes.userpermission.pojo.entity.Organization;
import com.bosssoft.bes.userpermission.service.OrganizationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 章邴瀚
 * @date 2019-08-16 14:21
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationDao organizationDao;

    @Autowired
    private DataSourceTransactionManager transactionManager;

    public int add(OrganizationDTO organizationDTO) throws Exception {
        Organization organizationToDb = new Organization();
        BeanUtils.copyProperties(organizationDTO,organizationToDb);
        return organizationDao.insert(organizationToDb);
    }

    @Transactional
    public int delete(List<OrganizationDTO> dtos) throws Exception {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setName("deleteOrganizations");
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = transactionManager.getTransaction(def);
        int res = Integer.MIN_VALUE;
        try {
            if (dtos != null && dtos.size() > 0){
                for (OrganizationDTO dto : dtos){
                    res = organizationDao.deleteByPrimaryKey(dto.getId());
                    System.out.println(res);
                    if (res != 1) {
                        throw new Exception();
                    }
                }
            }
        } catch (Exception ex) {
            transactionManager.rollback(status);
            res = Integer.MIN_VALUE;
        }
        return res;
    }

    public int update(OrganizationDTO organizationDTO) throws Exception {
        Organization organizationToDb = new Organization();
        BeanUtils.copyProperties(organizationDTO,organizationToDb);
        return organizationDao.updateByPrimaryKeySelective(organizationToDb);
    }

    public OrganizationDTO queryByPrimaryKey(Long id) throws Exception {
        Organization organization = organizationDao.selectByPrimaryKey(id);
        OrganizationDTO dto = new OrganizationDTO();
        BeanUtils.copyProperties(organization,dto);
        return dto;
    }

    public List<OrganizationDTO> queryByCondition(OrganizationDTO organizationDTO) throws Exception {
        Condition condition = new Condition(Organization.class);
        Example.Criteria criteria = condition.createCriteria();
        if (!StringUtils.isEmpty(organizationDTO.getName())){
            criteria.andLike("name","%"+organizationDTO.getName()+"%");
        }
        List<Organization> results = organizationDao.selectByExample(condition);
        List<OrganizationDTO> dtos = null;
        OrganizationDTO dto = null;
        if (results != null) {
            dtos = new ArrayList<OrganizationDTO>(results.size());
            for (Organization result : results){
                //此处new的做法有待商讨……
                dto = new OrganizationDTO();
                BeanUtils.copyProperties(result, dto);
                dtos.add(dto);
            }
        } else {
            dtos = new ArrayList<OrganizationDTO>();
        }
        return dtos;
    }

}
