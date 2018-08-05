package com.springmvc.restController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.beans.EmployeeBean;

@Controller
public class EmployeeRestController {
	

@RequestMapping(value="/getAllEmployee",produces="application/json",method=RequestMethod.GET)
public @ResponseBody List<EmployeeBean> getListOfEmployee(){
	List<EmployeeBean> empList=new ArrayList<EmployeeBean>();
	EmployeeBean e1=new EmployeeBean(1,"A",2000,25,"Address");
    empList.add(e1);
    return empList;
	
}

}
