package com.example.jpa.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;


/**
 * The persistent class for the employee database table.
 * 
 */
@Entity
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String name;

	private BigInteger salary;
	private String deptId;
	
	@ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH,CascadeType.REMOVE},optional=false)
	@JoinColumn(name="departmet_fk",referencedColumnName="id")
	private Department Department;
	
	

	public Department getDepartment() {
		return Department;
	}

	public void setDepartment(Department department) {
		Department = department;
	}

	public Employee() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigInteger getSalary() {
		return this.salary;
	}

	public void setSalary(BigInteger salary) {
		this.salary = salary;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	
}