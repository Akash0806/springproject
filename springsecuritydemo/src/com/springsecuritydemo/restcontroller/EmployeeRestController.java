package com.springsecuritydemo.restcontroller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.HeadersBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springsecuritydemo.model.Employee;

@RestController
@RequestMapping("/employees")
public class EmployeeRestController {
	private final Logger LOG = LoggerFactory.getLogger(EmployeeRestController.class);
@RequestMapping(method=RequestMethod.GET,headers="Accept=application/json")	
public ResponseEntity<List<Employee>> getAll(){
	
	List<Employee> employees=new ArrayList<Employee>();
	Employee e1=new Employee();
	e1.setName("Akash");
	employees.add(e1);
	/*if(employees.isEmpty()){
		throw new RuntimeException();
	}*/
	return ResponseEntity.ok()
		    .cacheControl(CacheControl.maxAge(600, TimeUnit.SECONDS))
		    .body(employees);
}

@RequestMapping(value="{id}",method=RequestMethod.PUT,headers="Accept=application/json")
public ResponseEntity<Employee>update(@PathVariable int id,@RequestBody Employee employee){
	System.out.println("inside to ");
	LOG.info("LOG");
	//HeadersBuilder healder=new HeadersBuilder();
	
	return ResponseEntity.ok()
		    .cacheControl(CacheControl.maxAge(600, TimeUnit.SECONDS))
		    .body(employee);
}
	

}
