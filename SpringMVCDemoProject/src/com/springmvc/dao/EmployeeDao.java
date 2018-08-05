package com.springmvc.dao;

import java.util.List;

import com.springmvc.pojo.Employee;

public interface EmployeeDao {

	List<Employee> getEmployeeList();

	int addEmployee(Employee employee);

	void testCriteriaQueryResult();

}
