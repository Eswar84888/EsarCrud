package com.example.demo.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.EmployeeRepo;
import com.example.demo.enity.Employee;
import com.example.demo.exception.NoSuchCustomerExistsException;
import com.example.demo.exception.ResourceNotFoundException;

@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	public EmployeeRepo repo;

	@Override
	public Employee createEmployee(Employee emp) {
		return repo.save(emp);
	}

	@Override
	public List<Employee> createAllEmployee(List<Employee> emp) {
		List<Employee> list = new ArrayList<>();
		for (Employee emp1 : emp)
			if (emp1.getName() != null) {
				list.add(repo.save(emp1));
			} else {
				throw new ResourceNotFoundException("add the records " + emp1);
			}
		return list;
	}

	@Override
	public Set<Employee> createAllsetEmployee(Set<Employee> emp) {
		//here different way to implemted the code 
		// Set<Employee> empset= new HashSet<>(repo.saveAll(emp));
		// return repo.saveAll(emp);
		return new HashSet<>(repo.saveAll(emp));
	}

	@Override
	public Map<Integer, Employee> createAllMapEmployee(Map<Integer, Employee> emp) {
		List<Employee> employees = new ArrayList<>(repo.saveAll(emp.values()));
		// Assuming your Employee class has a method getId() to get the unique
		// identifier
		Map<Integer, Employee> empmap = employees.stream()
				.collect(Collectors.toMap(Employee::getId, Function.identity()));

		return empmap;
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		List<Employee> list = repo.findAll();
		return list;
	}

	@Override
	public Employee getById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Employee> optionalEmployee = repo.findById(id);
		if (optionalEmployee.isPresent()) {
			return optionalEmployee.get();
		} else {
			throw new ResourceNotFoundException("Record not found with " + id);
		}
	}

	@Override
	public Employee updateRecord(Employee emp) {
		// TODO Auto-generated method stub
		Optional<Employee> emp1 = this.repo.findById(emp.getId());
		if (emp1.isPresent()) {
			Employee emp2 = emp1.get();
			emp2.setId(emp.getId());
			emp2.setName(emp.getName());
			emp2.setEmpphno(emp.getEmpphno());
			emp2.setEmpMailId(emp.getEmpMailId());
			repo.save(emp2);
			return emp2;
		} else {
			throw new NoSuchCustomerExistsException("Record not found excwption" + emp.getId());
		}
	}

	@Override
	public List<Employee> updateAllRecords(List<Employee> employees) {
		List<Employee> updatedEmployees = new ArrayList<>();

		for (Employee employee : employees) {
			if (employee.getId() == null || employee.getId() == 0) {
				Employee newEmployee = repo.save(employee);
				updatedEmployees.add(newEmployee);
			} else {
				Optional<Employee> optionalExistingEmployee = repo.findById(employee.getId());

				if (optionalExistingEmployee.isPresent()) {
					Employee existingEmployee = optionalExistingEmployee.get();
					existingEmployee.setName(employee.getName());
					existingEmployee.setEmpphno(employee.getEmpphno());
					existingEmployee.setEmpMailId(employee.getEmpMailId());
					updatedEmployees.add(repo.save(existingEmployee));
				} else {
					throw new ResourceNotFoundException("Employee not found with id: " + employee.getId());
				}
			}
		}

		return updatedEmployees;
	}

	@Override
	public Employee deleteemp(Integer id) {
		// TODO Auto-generated method stub
		Optional<Employee> deleteEmployee = this.repo.findById(id);
		if (deleteEmployee.isPresent()) {
			Employee emp = deleteEmployee.get();
			repo.deleteById(id);
			return emp;
		} else {
			throw new NoSuchCustomerExistsException("Record not found excwption" + id);
		}
	}

	@Override
	public void deletebyId(Integer id) {
		// TODO Auto-generated method stub
		Optional<Employee> deleteById = this.repo.findById(id);
		if (deleteById.isPresent()) {
			repo.delete(deleteById.get());

		} else {
			throw new NoSuchCustomerExistsException("Record not found excwption" + id);
		}
	}

	@Override
	public void deleteAllbyId(List<Integer> ids) {
		// TODO Auto-generated method stub
		for (Integer deleteIds : ids) {
			Optional<Employee> deleteAllIds = repo.findById(deleteIds);
			if (deleteAllIds.isPresent()) {
				repo.deleteById(deleteIds);
			} else {
				throw new NoSuchCustomerExistsException("Record not found excwption" + ids);
			}
		}

	}

}
