package com.sawyer.dao;

import com.sawyer.entity.Emp;
import java.util.List;

public interface EmpDAO {
    //查询所有的员工信息并显示
    List<Emp> findAll();

    //保存添加的员工信息
    void save(Emp emp);

    //删除
    void delete(String id);

    //根据员工id查询员工信息并回显
    Emp find(String id);

    //修改更新
    void update(Emp emp);
}
