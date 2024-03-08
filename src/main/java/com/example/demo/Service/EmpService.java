package com.example.demo.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.demo.enity.Employee;

@Service
public interface EmpService {
	public Employee createEmployee(Employee e);

	public List<Employee> createAllEmployee(List<Employee> emp);

	public Set<Employee> createAllsetEmployee(Set<Employee> emp);

	public Map<Integer, Employee> createAllMapEmployee(Map<Integer, Employee> emp);

	public List<Employee> getAllEmployee();

	public Employee getById(Integer id);

	public Employee updateRecord(Employee e);

	public List<Employee> updateAllRecords(List<Employee> employees);

	public Employee deleteemp(Integer id);

	public void deletebyId(Integer id);

	public void deleteAllbyId(List<Integer> ids);
}
