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

import com.aditya.Dao.DepartmentDao;
import com.aditya.Model.Department;
import com.aditya.Service.DepartmentService;

@RestController
public class DepartmentController {

  @Autowired
  private DepartmentService departmentService;

  private DepartmentDao getDepartmentsresponse(Department department) {
    return new DepartmentDao(department.getId(), department.getName(), department.getDescription());
  }

  @GetMapping("/api/departments")
  public ResponseEntity<List<DepartmentDao>> getAllDepartment() {
    List<Department> list = departmentService.getAllDepartments();
    List<DepartmentDao> departments = new ArrayList<>();
    for (Department department : list) {
      DepartmentDao departmentdao = getDepartmentsresponse(department);
      departments.add(departmentdao);

    }
    return ResponseEntity.ok(departments);
  }

  @GetMapping("/api/departments/{id}")
  public ResponseEntity<DepartmentDao> getDepartmentById(@PathVariable Long id) {
    Department department = departmentService.getAllDepartmentsById(id);
    if (department != null) {
      DepartmentDao departmentDao = new DepartmentDao(department.getId(), department.getName(),
          department.getDescription());
      return ResponseEntity.ok(departmentDao);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping("/api/departments")
  public ResponseEntity<String> createdDepartment(@RequestBody DepartmentDao department) {
    String departmentData = departmentService
        .createDepartment(new Department(department.getId(), department.getName(), department.getDescription()));
    return ResponseEntity.status(HttpStatus.CREATED).body(departmentData);
  }

  @PutMapping("api/departments/{id}")
  public ResponseEntity<?> updateDepartment(@RequestBody DepartmentDao department, @PathVariable Long id) {
    Department updatedDepartment = departmentService.updatedDepartment(department, id);
    if (updatedDepartment != null) {
      return ResponseEntity.ok(updatedDepartment);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("api/departments/{id}")
  public ResponseEntity<String> deleteDepartment(@PathVariable Long id) {
    boolean deleted = departmentService.deleteDepartment(id);
    if (deleted) {
      return ResponseEntity.ok("Department with id deleted successfully");
    } else {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("Department with id does not exist");
    }
  }

}
