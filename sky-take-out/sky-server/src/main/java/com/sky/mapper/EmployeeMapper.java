package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmployeeMapper {

    /**
     * 根据用户名查询员工
     * @param username
     * @return
     */
    @Select("select * from employee where username = #{username}")
    Employee getByUsername(String username);
    /*
    * 插入数据*/
    @Insert("insert into employee(name, username, password, phone, sex, id_number, create_time, update_time, create_user, update_user,status) VALUES" +
            "(#{name},#{username},#{password},#{phone},#{sex},#{idNumber},#{createTime},#{updateTime},#{createUser},#{updateUser},#{status})")
    @AutoFill(value = OperationType.INSERT)
    void insert(Employee employee);
/**
 * @description:员工分页
 * @author: X_X
 * @param: [employeePageQueryDTO]
 * @return: com.github.pagehelper.Page<com.sky.entity.Employee>
 **/
    Page<Employee> pageQuery(EmployeePageQueryDTO employeePageQueryDTO);
   
    /**
     * @description:根据id修改账户状态
     * @author: X_X
     * @param: [employee]
     * @return: void
     **/
    @AutoFill(value = OperationType.UPDATE)
    void update(Employee employee);
  /**
   * @description: 根据id查询用户信息
   * @author: X_X
   * @param: [id]
   * @return: com.sky.entity.Employee
   **/
    @Select("select * from employee where id = #{id}")
    Employee getById(Long id);
}
