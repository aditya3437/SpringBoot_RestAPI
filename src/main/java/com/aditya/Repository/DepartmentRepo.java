package com.aditya.Repository;

import org.springframework.data.repository.CrudRepository;

import com.aditya.Model.Department;

public interface DepartmentRepo extends CrudRepository<Department, Long> {

}
