package com.mybatis;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface EmployeeMapper {
    @Select("select * from employees")
    List<Employee> findAll();

    @Select("SELECT * FROM employees WHERE id = #{id}")
    Employee findById(long id);

    @Delete("DELETE FROM employees WHERE id = #{id}")
    void delete(long id);

    @Insert("INSERT INTO employees(first_name, last_name, email) VALUES (#{firstName}, #{lastName}, #{email})")
    void insert(Employee employee);

    @Update("Update employees set first_name=#{firstName}, last_name=#{lastName}, email=#{email} where id=#{id}")
    void update(Employee employee);
}
