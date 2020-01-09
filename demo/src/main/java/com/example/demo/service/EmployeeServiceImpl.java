package com.example.demo.service;

import java.util.Iterator;
import java.util.List;

import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entities.Employee;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EmployeeRepository;


@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> listEmployees()
	{
		List<Employee> employeeList = employeeRepository.findAll();
		return employeeList;
	}
	
	public Employee addNewEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
		
	}
	
	public String deleteEmployee(@PathVariable Long id) {
	        return employeeRepository.findById(id).map(emp -> {
	        	employeeRepository.delete(emp);
	            return "deleted";
	        }).orElseThrow(() -> new ResourceNotFoundException("Employee Id " + id + " not found"));
	}
	public  Employee findByEmployeeId(Long id){
//		Employee updatedemployee=(Employee) employeeRepository.findById(id).map(a -> {
//            a.setName(employee.getName());
//            a.setEmail(employee.getEmail());
//            a.setDeptNo(employee.getDeptNo());
//            a.setDesig(employee.getDesig());
//            a.setSalary(employee.getSalary());
//            return employeeRepository.save(a);
//        }).orElseThrow(() -> new ResourceNotFoundException("Employee ID" + id + " not found"));
		
		System.out.println(employeeRepository.findById(id).get());
		return employeeRepository.findById(id).get();
		
	}
	
	public  List<Employee> findByEmployeeByName(String name){
		List<Employee> employeeList = employeeRepository.findAll();
		
		Iterator itr = employeeList.iterator(); 
        while (itr.hasNext()) 
        {  
        	Employee e = (Employee) itr.next();
        	if(!e.getName().equals(name))
        		itr.remove();
        } 
		
		return employeeList;
		
	}
	
	public  List<Employee> findByDesig(String desig){
		List<Employee> employeeList = employeeRepository.findByDesig(desig);
		
		/*Iterator itr = employeeList.iterator(); 
        while (itr.hasNext()) 
        {  
        	Employee e = (Employee) itr.next();
        	if(!e.getDesig().equals(designation))
        		itr.remove();
        } */
		
		return employeeList;
		
	}
	public  List<Employee> findByEmployeeByDeptno(int deptno){
		List<Employee> employeeList = employeeRepository.findAll();
		
		Iterator itr = employeeList.iterator(); 
        while (itr.hasNext()) 
        {  
        	Employee e = (Employee) itr.next();
        	if(e.getDeptNo()!=deptno)
        		itr.remove();
        } 
		
		return employeeList;
		
	}
}
