package com.aditya.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aditya.Dao.EmployeeDao;
import com.aditya.Model.Employee;
import com.aditya.Service.EmployeeService;

@RestController
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  private EmployeeDao getEmployeesresponse(Employee employee) {
    return new EmployeeDao(employee.getId(), employee.getName(), employee.getEmail(), employee.getBirth_date(),
        employee.getDepartment_id());
  }

  @GetMapping("/api/employees")
  public ResponseEntity<List<EmployeeDao>> getEmployees() {
    List<Employee> employees = employeeService.getAllEmployees();
    List<EmployeeDao> employeeDaos = new ArrayList<>();
    for (Employee employee : employees) {
      EmployeeDao employeeDao = getEmployeesresponse(employee);
      employeeDaos.add(employeeDao);
    }
    return ResponseEntity.ok(employeeDaos);
  }

  @GetMapping("/api/employees/{id}")
  public ResponseEntity<EmployeeDao> getEmployeeById(@PathVariable Long id) {
    Employee employee = employeeService.getEmployeesDetails(id);
    if (employee != null) {
      EmployeeDao employeeDao = new EmployeeDao(employee.getId(), employee.getName(), employee.getEmail(),
          employee.getBirth_date(), employee.getDepartment_id());
      return ResponseEntity.ok(employeeDao);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping("/api/employees")
  public ResponseEntity<?> addEmployees(@RequestBody EmployeeDao employee) {
    String departmentData = employeeService
        .addNewEmployees(new Employee(employee.getId(), employee.getName(), employee.getEmail(),
            employee.getBirth_date(), null, null, employee.getDepartment_id(), null));
    return ResponseEntity.status(HttpStatus.CREATED).body(departmentData);

  }

  @PutMapping("/api/employees/{id}")
  public ResponseEntity<Employee> UpdatedEmployees(@RequestBody EmployeeDao employee, @PathVariable Long id) {
    Employee updatedEmployee = employeeService.updateEmployee(employee, id);
    if (updatedEmployee != null) {
      return ResponseEntity.ok(updatedEmployee);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/api/employees/{id}")
  public ResponseEntity<String> deleteEmployees(@PathVariable Long id) {
    boolean deleted = employeeService.deleteEmployee(id);
    if (deleted) {
      return ResponseEntity.ok("Employee with id deleted successfully");
    } else {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("Employee with id does not exist");
    }

  }

}
