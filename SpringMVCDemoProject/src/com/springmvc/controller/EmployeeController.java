package com.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.beans.EmployeeBean;
import com.springmvc.pojo.Department;
import com.springmvc.pojo.Employee;
import com.springmvc.services.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	
	
	@RequestMapping(value = { "/addEmployee" }, method = RequestMethod.GET)
	private ModelAndView addEmployee(Model model) {
		System.out.println("inside controller");
		List<Employee> listEmployee = employeeService.getListEmployee();
		System.out.println(listEmployee.size());
		EmployeeBean bean=new EmployeeBean();
		model.addAttribute("employeeModel", bean);
      return  new ModelAndView("addEmployee");
	}
	
	@RequestMapping(value={"/save"},method=RequestMethod.POST)
	public void saveEmployee(@ModelAttribute("employeeModel") EmployeeBean employeeBean,BindingResult result){
		System.out.println("save employee controller");
		employeeService.saveEmployee(employeeBean);
		
		
	}
	
	@RequestMapping(value={"/saveWithAjax"},method=RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void saveEmployeeWithAjax(@RequestBody EmployeeBean employeeBean){
		System.out.println("save employee controller");
		employeeService.saveEmployee(employeeBean);
		
		
	}
	
	

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView welcome() {
		return new ModelAndView("index");
	}

}
