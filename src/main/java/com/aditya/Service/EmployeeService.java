package com.aditya.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aditya.Dao.EmployeeDao;
import com.aditya.Model.Employee;
import com.aditya.Repository.EmployeeRepo;

@Service
public class EmployeeService {

  @Autowired
  private EmployeeRepo employeeRepo;

  public List<Employee> getAllEmployees() {
    List<Employee> employees = new ArrayList<>();
    employeeRepo.findAll().forEach(employee -> employees.add(employee));
    return employees;
  }

  public Employee getEmployeesDetails(Long id) {
    Optional<Employee> employess = employeeRepo.findById(id);
    if (employess.isPresent()) {
      return employess.get();
    }
    return null;
  }

  public Employee addNewEmployee(Employee employee) {
    return employeeRepo.save(employee);
  }

  public Employee updateEmployee(EmployeeDao employee, Long id) {

    Optional<Employee> updateEmp = employeeRepo.findById(id);
    if (updateEmp.isPresent()) {
      Employee uEmployee = updateEmp.get();
      uEmployee.setName(employee.getName());
      uEmployee.setBirth_date(employee.getBirth_date());
      uEmployee.setEmail(employee.getEmail());
      uEmployee.setDepartment_id(employee.getDepartment_id());
      return employeeRepo.save(uEmployee);
    }
    return null;
  }

  public boolean deleteEmployee(Long id) {
    if (employeeRepo.existsById(id)) {
      employeeRepo.deleteById(id);
      return true;
    }
    return false;
  }

  public Employee DepartmentDao(EmployeeDao employeeDao) {
    Employee employees = new Employee();
    employees.setId(employeeDao.getId());
    employees.setName(employeeDao.getName());
    employees.setEmail(employeeDao.getEmail());
    employees.setBirth_date(employeeDao.getBirth_date());
    employees.setDepartment_id(employeeDao.getDepartment_id());
    return employees;
  }

  public EmployeeDao employeeentity(Employee e) {
    EmployeeDao employee = new EmployeeDao();
    employee.setId(e.getId());
    employee.setName(e.getName());
    employee.setEmail(e.getEmail());
    employee.setBirth_date(e.getBirth_date());
    employee.setDepartment_id(e.getDepartment_id());

    return employee;

  }

  public String addNewEmployees(Employee employee2) {
    if (employee2.getDepartment_id() == null) {
      return "Department ID cannot be null.";
    }
    Employee employee = new Employee();
    employee.setId(employee2.getId());
    employee.setName(employee2.getName());
    employee.setEmail(employee2.getEmail());
    employee.setBirth_date(employee2.getBirth_date());
    employee.setDepartment_id(employee2.getDepartment_id());
    Employee savedEmployee2 = employeeRepo.save(employee);
    return "Employee created successfully with ID: " + savedEmployee2.getId();
  }

}
