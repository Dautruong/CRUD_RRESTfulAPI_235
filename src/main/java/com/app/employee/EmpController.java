package com.app.employee;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class EmpController {
	private static final Map<String, Employee> empMap = new HashMap<>();
	 static {
		 Employee emp1 = new Employee("1", "Dau", 22);
		 Employee emp2 = new Employee("2", "Quang", 33);
		 Employee emp3 = new Employee("3", "Truong", 44);

		 empMap.put(emp1.getId(), emp1);
		 empMap.put(emp2.getId(), emp2);
		 empMap.put(emp3.getId(), emp3);
	}
	 @RequestMapping(value = "/employees", method = RequestMethod.GET)
	 public ResponseEntity<Object> getEmployee() {
	      return new ResponseEntity<>(empMap.values(), HttpStatus.OK);
	 }
	 @RequestMapping(value = "/employees", method = RequestMethod.POST)
	 public ResponseEntity<Object> createEmployee(@RequestBody Employee employee) {
			empMap.put(employee.getId(), employee);
			return new ResponseEntity<>("empMap is created successfully", HttpStatus.CREATED);
	 }
	 @GetMapping("/employee/{id}")
	 public ResponseEntity<Object> get(@PathVariable("id") String id) {
	    
	         return new ResponseEntity<>(empMap.get(id), HttpStatus.OK);
	      
	 }
	 @RequestMapping(value = "/employee/{id}", method = RequestMethod.PUT)
	 public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Employee employee) { 
		 empMap.remove(id);
		 employee.setId(id);
	     empMap.put(id, employee);
	     return new ResponseEntity<>("employee is updated successsfully", HttpStatus.OK);
	   }
	 
	 @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
	 public ResponseEntity<Object> delete(@PathVariable("id") String id) { 
		 	empMap.remove(id);
		 	return new ResponseEntity<>("Employee is deleted successsfully", HttpStatus.OK);
	   }
}


