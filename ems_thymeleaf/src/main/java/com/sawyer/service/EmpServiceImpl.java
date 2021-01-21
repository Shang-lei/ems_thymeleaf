package com.sawyer.service;

import com.sawyer.dao.EmpDAO;
import com.sawyer.entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpDAO empDAO;

    //查询所有的员工信息
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Emp> findAll() {
        return empDAO.findAll();
    }

    //添加保存
    @Override
    public void save(Emp emp) {
        emp.setId(UUID.randomUUID().toString());
        empDAO.save(emp);
    }

    //删除
    @Override
    public void delete(String id) {
        empDAO.delete(id);
    }

    //根据员工id查询员工
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Emp find(String id) {
        return empDAO.find(id);
    }

    //修改更新
    @Override
    public void update(Emp emp) {
        empDAO.update(emp);
    }
}
