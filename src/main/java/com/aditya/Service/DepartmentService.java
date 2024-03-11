package com.aditya.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aditya.Dao.DepartmentDao;
import com.aditya.Model.Department;
import com.aditya.Repository.DepartmentRepo;

@Service
public class DepartmentService {

  @Autowired
  private DepartmentRepo departmentrepo;

  public List<Department> getAllDepartments() {
    List<Department> departments = new ArrayList<>();
    departmentrepo.findAll().forEach(departments::add);
    return departments;
  }

  public Department getAllDepartmentsById(Long id) {
    Optional<Department> departments = departmentrepo.findById(id);
    if (departments.isPresent()) {
      return departments.get();
    }
    return null;

  }

  public Department createdDepartment(Department d) {
    return departmentrepo.save(d);
  }

  public Department updatedDepartment(DepartmentDao department, Long id) {
    Optional<Department> updateDep = departmentrepo.findById(id);
    if (updateDep.isPresent()) {
      Department uDepartment = updateDep.get();
      uDepartment.setName(department.getName());
      uDepartment.setDescription(department.getDescription());
      uDepartment.setCreatedTime(department.getCreatedTime());
      uDepartment.setUpdatedTime(department.getUpdatedTime());
      return departmentrepo.save(uDepartment);
    }
    return null;
  }

  public boolean deleteDepartment(Long id) {
    if (departmentrepo.existsById(id)) {
      departmentrepo.deleteById(id);
      return true;
    }
    return false;

  }

  public Department DepartmentDao(DepartmentDao department) {
    Department departments = new Department();
    department.setId(department.getId());
    department.setName(department.getName());
    department.setDescription(department.getDescription());
    return departments;
  }

  public DepartmentDao departmententity(Department d) {
    DepartmentDao department = new DepartmentDao();
    department.setId(d.getId());
    department.setName(d.getName());
    department.setDescription(d.getDescription());
    return department;

  }

  public String createDepartment(Department department2) {
    Department department = new Department();
    department.setId(department2.getId());
    department.setName(department2.getName());
    department.setDescription(department2.getDescription());
    Department savedDepartment = departmentrepo.save(department);
    return "Department created successfully with ID: " + savedDepartment.getId();

  }

}
