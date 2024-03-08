package com.example.demo.enity;

import java.util.Objects;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Employee")
public class Employee {
	@Id
	@Column(name = "Emp-Id")
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Integer id;
	@Column(name = "Emp-Name")
	private String name;
	@Column(name = "Emp-Phno")
	private Long empphno;
	@Column(name = "Emp-MailId")
	private String empMailId;
	 @Override
	    public int hashCode() {
	        return Objects.hash(name);
	    }

	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj) return true;
	        if (obj == null || getClass() != obj.getClass()) return false;
	        Employee employee = (Employee) obj;
	        return Objects.equals(name, employee.name);
	    }
}
