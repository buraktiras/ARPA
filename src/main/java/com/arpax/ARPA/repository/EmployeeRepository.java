package com.arpax.ARPA.repository;

import com.arpax.ARPA.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	Employee findByName(String name);
}