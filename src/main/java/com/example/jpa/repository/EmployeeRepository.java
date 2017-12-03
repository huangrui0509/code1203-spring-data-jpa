package com.example.jpa.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Serializable>{

}
