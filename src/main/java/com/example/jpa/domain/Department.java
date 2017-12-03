package com.example.jpa.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;



import lombok.Data;

@Entity
@Table
@Data
public class Department {

	@Id
	private long id;
	private String name;
	
	 @OneToMany(mappedBy="dept_id",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	 private List<Employee> employees = new ArrayList<Employee>();
	 public void addEmployee(Employee emp){
         if(emp != null){
        	 employees.add(emp);
         }
 }
}
