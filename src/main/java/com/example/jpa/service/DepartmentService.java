package com.example.jpa.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpa.domain.Department;
import com.example.jpa.domain.Employee;
import com.example.jpa.repository.DepartmentRepository;

@Service
public class DepartmentService {

	//spring data jpa做增删改查操作

	@Autowired
	DepartmentRepository departmentRepository;
	//可以进行级联查看
	public List<Department> findAll() {
		List<Department> findAll = departmentRepository.findAll();
		return findAll;
	}
	
	public Department findById() {
		Department dept = departmentRepository.findById(123);
		return dept;
	}
	
	public Department findByIdAndName() {
		Department dept = departmentRepository.findByIdAndName(123,"www");
		return dept;
	}
	
	
	public Department saveAndFlush() {
		Department dept = new Department();
		dept.setId(125);
		dept.setName("hhh");
		Department  department= departmentRepository.saveAndFlush(dept);

		return department;
		
	}
	public List<Department> save() {
		List<Department> deptList = new ArrayList();
		for(int i=200;i<250;i++) {
			Department dept = new Department();
			dept.setId(i);
			dept.setName("dept"+i);
			deptList.add(dept);
			
		}
		
		return departmentRepository.save(deptList);
		
	}
	
	
	//级联保存
	public Department saveDeptAndEmp() {
		Department dept = new Department();
		dept.setId(1000);
		dept.setName("后勤");
		
		Employee emp = new Employee();
		emp.setId("155");
		emp.setName("huang");
		emp.setSalary(new BigInteger("12222222"));
		emp.setDeptId("1000");
		emp.setDepartment(dept);
		
		dept.addEmployee(emp);
		
		return	departmentRepository.saveAndFlush(dept);
		
		
	}
	
	//级联删除，保证部门删除，员工信息保存
	 public void testDeleteDept(){
         
		 Department dept = saveDeptAndEmp();
 
     List<Employee> emps = dept.getEmployees();
     for(int i=0;i<emps.size();i++){
    	 Employee emp = emps.get(i);
            emp.setDeptId(null);
            emp.setDepartment(null);
     }
     departmentRepository.delete(dept);
	 
	 
	 }
	 
	
}
