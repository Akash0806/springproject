package com.springmvc.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="department")
public class Department implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Department() {

	}

	public Department(String departmentName, Employee employee) {
		super();
		this.departmentName = departmentName;
		this.employee = employee;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "dept_id")
	private Integer departmentId;

	@Column(name = "department_name")
	private String departmentName;

	@ManyToOne
	@JoinColumn(name = "emp_id")
	private Employee employee;

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	

}
