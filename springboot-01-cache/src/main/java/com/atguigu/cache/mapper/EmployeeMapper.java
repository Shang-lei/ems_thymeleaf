package com.atguigu.cache.mapper;

import com.atguigu.cache.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmployeeMapper {
    //编写方法的声名

    /**
     * 根据员工id查询员工
     * */
    @Select("select * from employee where id=#{id}")
    public Employee getEmpById(Integer id);

    /**
     * 修改员工信息操作
     * */
    @Select("update employee set lastName=#{lastName},email=#{email},gender=#{gender},d_id=#{dId} where id=#{id}")
    public void updateEmp(Employee employee);

    /**
     * 删除员工信息操作
     * */
    @Select("delete from employee where id=#{id}")
    public void deleteEmpById(Integer id);

    /**
     * 添加新员工信息操作
     * */
    @Select("insert into employee(lastName,email,gender,d_id) values(#{lastName},#{email},#{gender},#{dId}) ")
    public void insertEmployee(Employee employee);

    /**
     * 根据员工姓名查询员工,测试复杂的缓存组合规则
     * */
    @Select("select * from employee where lastname=#{lastname}")
    public Employee getEmpByLastName(String lastName);
}
