package com.springmvc.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.springmvc.dao.EmployeeDao;
import com.springmvc.pojo.Department;
import com.springmvc.pojo.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	@PersistenceContext
    private EntityManager manager;
	
	@Override
	public List<Employee> getEmployeeList(){
		//TypedQuery<Employee> typeQuery=manager.createQuery("Select e From Employee e",Employee.class);
		//Query query=manager.createQuery("Select e From Employee e");
		testCriteriaQueryResult();
		//List<Employee> list=typeQuery.getResultList();
		//List list=query.getResultList();
		List list=null;
		return list;
	}
	
	@Override
	public int addEmployee(Employee employee){
		manager.persist(employee);
		return employee.getId();
	}
	
	@Override
	public void testCriteriaQueryResult(){
		
		org.hibernate.Session session =  (Session) manager.getDelegate();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("salary", 10000));
		
		
	}

}
