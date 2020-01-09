package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Employee;

@Service("employeeService")
public interface EmployeeService {
	
	public List<Employee> listEmployees();
	
	public Employee addNewEmployee( Employee employee);
	
	public String deleteEmployee(Long id);
	
	public  Employee findByEmployeeId(Long id);
	
	public List<Employee> findByEmployeeByName(String name);
	public  List<Employee> findByDesig(String desig);

	public List<Employee> findByEmployeeByDeptno(int deptno);

}
