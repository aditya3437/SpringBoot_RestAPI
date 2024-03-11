package com.aditya.Repository;

import org.springframework.data.repository.CrudRepository;

import com.aditya.Dao.EmployeeDao;
import com.aditya.Model.Employee;

public interface EmployeeRepo extends CrudRepository<Employee, Long> {

  Employee save(EmployeeDao employee);

}
