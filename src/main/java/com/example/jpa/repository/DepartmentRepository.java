package com.example.jpa.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa.domain.Department;

public interface DepartmentRepository extends JpaRepository<Department, Serializable>{

 	
 	Department findById(long id);
 	Department findByIdAndName(long id,String name);
 	
 	
 	
}
