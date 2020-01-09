package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.entities.Employee;
import com.example.demo.service.EmployeeService;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@Controller
public class DemoController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	public String welcome()

	{
		return "index";
	}
	
	@RequestMapping("/login")
	public ModelAndView requestLogin(@RequestParam String user, @RequestParam String password)
	{
		ModelAndView modelAndView;
		if ((user.equals("user")) && (password.equals("password"))) {
			modelAndView = new ModelAndView("home");
		} else {
			modelAndView = new ModelAndView("index");
		}
		return modelAndView;
	}
	
	@GetMapping("/home")
	public String homePage()
	{
		return "home";
	}
	
	@GetMapping("/addEmp")
	public ModelAndView addEmpGet()throws Exception
	{
		ModelAndView mv=new ModelAndView("addEmp");
		Employee e=new Employee();
		mv.addObject("emp", e);
		return mv;
	}

	@PostMapping("/addEmp")
	public ModelAndView addEmpPost(@ModelAttribute("emp")Employee e)throws Exception
	{
		ModelAndView mv=new ModelAndView("printEmployee");
		mv.addObject("emp",employeeService.addNewEmployee(e));
		return mv;
	}
	
//	############################## UPDATE ############################
	@PostMapping("/updateEmp")
	public ModelAndView updateEmpPost(@ModelAttribute("emp")Employee e)throws Exception
	{
		ModelAndView mv=new ModelAndView("printEmployee");
		mv.addObject("emp",employeeService.addNewEmployee(e));
		return mv;
	}
	
	@GetMapping("/updateEmp")
	public ModelAndView updateEmpGet(@RequestParam("id")Long id)throws Exception
	{
		ModelAndView mv=new ModelAndView("updateEmp");
		Employee e=new Employee();
		e= employeeService.findByEmployeeId(id);
		mv.addObject("emp", e);
		return mv;
	}
	
	@GetMapping("/findEmpIdUpdate")
	public ModelAndView findEmpIdUpdateGet()throws Exception
	{
		ModelAndView mv=new ModelAndView("findEmpIdUpdate");
		return mv;
	}
//	############################################################
	@GetMapping("/deleteEmp")
	public ModelAndView deleteForm()
	{
		Employee employee=new Employee();
		ModelAndView mv=new ModelAndView("deleteEmp","employee",employee);
		return mv;
	}
	
	
	@PostMapping("/deleteEmployee")
	public RedirectView deleteEmployee(@Valid @RequestParam("id")Long id)
	{
		String message=employeeService.deleteEmployee(id);
		if(message.equals("deleted"))
			message="Employee with : "+id+" Deleted Successfully";
		else
			message="Employee with : "+id+" has not been deleted";
//		ModelAndView mv=new ModelAndView("allEmp");
//		mv.addObject(message);
//		return mv;
		return new RedirectView("allEmp");
	}
	
//	#######################################################################
	@GetMapping("/allEmp")
	public ModelAndView allEmp()throws Exception
	{
		ModelAndView mv=new ModelAndView("allEmp");
		List<Employee> emps=employeeService.listEmployees();
		mv.addObject("emps",emps);
		return mv;
	}
	
	@GetMapping("/printEmployee")
	public ModelAndView print(@RequestParam("id")Long id)throws Exception
	{
		ModelAndView mv=new ModelAndView("printEmployee");
		Employee e=new Employee();
		e= employeeService.findByEmployeeId(id);
		mv.addObject("emp",e);
		return mv;
	}
	
	@GetMapping("/findEmpId")
	public ModelAndView findEmpIdGet()throws Exception
	{
		ModelAndView mv=new ModelAndView("findEmpId");
		return mv;
	}
	
	@GetMapping("/printEmployeeByName")
	public ModelAndView printEmployeeByName(@RequestParam("name")String name)throws Exception
	{
		ModelAndView mv=new ModelAndView("allEmp");
		List<Employee> emps=employeeService.findByEmployeeByName(name);
		mv.addObject("emps",emps);
		return mv;
	}
	
	@GetMapping("/findEmpByName")
	public ModelAndView findEmpByNameGet()throws Exception
	{
		ModelAndView mv=new ModelAndView("findEmpByName");
		return mv;
	}
	
	@GetMapping("/printEmployeeByDesignation")
	public ModelAndView printEmployeeByDesignation(@RequestParam("designation")String designation)throws Exception
	{
		ModelAndView mv=new ModelAndView("allEmp");
		List<Employee> emps=employeeService.findByDesig(designation);
		mv.addObject("emps",emps);
		return mv;
	}
	
	@GetMapping("/findEmpByDesig")
	public ModelAndView findEmpByDesignationGet()throws Exception
	{
		ModelAndView mv=new ModelAndView("findEmpByDesig");
		return mv;
	}
	@GetMapping("/printEmployeeByDeptno")
	public ModelAndView printEmployeeByDeptno(@RequestParam("deptno")int deptno)throws Exception
	{
		ModelAndView mv=new ModelAndView("allEmp");
		List<Employee> emps=employeeService.findByEmployeeByDeptno(deptno);
		mv.addObject("emps",emps);
		return mv;
	}
	
	@GetMapping("/findEmpByDeptNo")
	public ModelAndView findEmpByDeptnoGet()throws Exception
	{
		ModelAndView mv=new ModelAndView("findEmpByDeptNo");
		return mv;
	}
	
}
