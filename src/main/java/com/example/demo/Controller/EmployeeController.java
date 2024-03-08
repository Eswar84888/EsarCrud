package com.example.demo.Controller;

import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Service.EmpServiceImpl;
import com.example.demo.enity.Employee;

@RestController
public class EmployeeController {
	@Autowired
	public EmpServiceImpl empser;

	@PostMapping("/emp")
	public ResponseEntity<Employee> create(@RequestBody Employee e) {
		return ResponseEntity.ok().body(empser.createEmployee(e));
	}

	@PostMapping("/postAllemp")
	public ResponseEntity<List<Employee>> createAllEmployee(@RequestBody List<Employee> emp) {
		List<Employee> listEmp = empser.createAllEmployee(emp);
		return ResponseEntity.ok().body(listEmp);
	}

	@PostMapping("/postsetAllemp")
	public ResponseEntity<Set<Employee>> createAllEmployee(@RequestBody Set<Employee> emp) {
		Set<Employee> setEmp = empser.createAllsetEmployee(emp);
		return ResponseEntity.ok().body(setEmp);
	}

	@PostMapping("/postMapAllemp")
	public ResponseEntity<Map<Integer, Employee>> createAllMapEmployee(@RequestBody Map<Integer, Employee> emp) {
		Map<Integer, Employee> mapEmp = empser.createAllMapEmployee(emp);
		return ResponseEntity.ok().body(mapEmp);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> listEmp = empser.getAllEmployee();
		return ResponseEntity.ok().body(listEmp);
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<Employee> getAllEmployeeById(@PathVariable Integer id) {
		Employee e1 = empser.getById(id);

		return ResponseEntity.ok().body(e1);

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateRecord(@PathVariable Integer id, @RequestBody Employee up) {
		up.setId(id);
		return ResponseEntity.ok().body(empser.updateRecord(up));

	}

	@PutMapping("/updateAll")
	public ResponseEntity<List<Employee>> updateAllRecord(@RequestBody List<Employee> emp) {
		List<Employee> empup = empser.updateAllRecords(emp);
		return ResponseEntity.ok().body(empup);

	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteemp(@PathVariable Integer id) {
		empser.deletebyId(id);
		return ResponseEntity.ok().body("Record delete with" + id + "is Suceessfully");

	}

	@DeleteMapping("deleteAll/{id}")
	public ResponseEntity<String> deleteemp1(@RequestParam List<Integer> ids) {
		empser.deleteAllbyId(ids);
		return ResponseEntity.ok().body("Record delete with" + ids + "is Suceessfully");

	}
}
