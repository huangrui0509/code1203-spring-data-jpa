package com.example.jpa.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.jpa.domain.Department;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentServiceTest {

	@Autowired
	DepartmentService departmentService;
	
	@Test
	public void findAll() {
		List<Department> findAll = departmentService.findAll();
		System.out.println(findAll);
	}
	
	@Test
	public void findById() {
		Department findById = departmentService.findById();
		System.out.println(findById);
	}
	
	@Test
	public void findByIdAndName() {
		Department dept = departmentService.findByIdAndName();
		System.out.println(dept);
	}
	@Test
	public void  saveAndFlush() {
		Department dept = departmentService.saveAndFlush();
		System.out.println(dept);
	}
	
	@Test
	public void  saveDeptList() {
		List<Department> saveDeptList = departmentService.save();
		System.out.println(saveDeptList);
	}
	
	@Test
	public void delete() {
		departmentService.testDeleteDept();
		System.out.println("删除成功！！");
		
	}
	
	@Test
	public void saveDeptAndEmp() {
		Department dept = departmentService.saveDeptAndEmp();
		System.out.println(dept);
	}
}
