package com.springmvc.servicesimpl;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.beans.EmployeeBean;
import com.springmvc.dao.EmployeeDao;
import com.springmvc.pojo.Department;
import com.springmvc.pojo.Employee;
import com.springmvc.services.EmployeeService;

@Service

public class EmployeeServicesImpl implements EmployeeService {
	
	@Autowired
	//@Qualifier(value="employeeDao")
	EmployeeDao employeeDao;
	
	@Autowired
	DozerBeanMapper   dozerBeanMapper;
	
	@Override
	public List<Employee> getListEmployee(){
		return employeeDao.getEmployeeList();
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public int saveEmployee(EmployeeBean bean){
		//dozerBeanMapperFactoryBean.
		Employee employee=dozerBeanMapper.map(bean, Employee.class);
		List<Department> departmentList=new ArrayList<Department>();
		Department department=new Department("deptName",employee );
		departmentList.add(department);
		employee.setDepartmentList(departmentList);
		employeeDao.addEmployee(employee);
		return 1;
	}

}
