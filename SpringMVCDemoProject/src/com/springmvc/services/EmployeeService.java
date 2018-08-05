package com.springmvc.services;

import java.util.List;

import com.springmvc.beans.EmployeeBean;
import com.springmvc.pojo.Employee;

public interface EmployeeService {

	List<Employee> getListEmployee();

	int saveEmployee(EmployeeBean bean);

}
