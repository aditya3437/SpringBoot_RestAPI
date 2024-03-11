package com.aditya.Dao;

import java.time.LocalDate;
import java.time.LocalTime;

import com.aditya.Model.Department;

public class EmployeeDao {

  private Long id;
  private String name;
  private String email;
  private LocalDate birth_date;
  private LocalTime created_time = LocalTime.now();
  private LocalTime updated_time;

  private Department department_id;

  public Department getDepartment_id() {
    return department_id;
  }

  public void setDepartment_id(Department department_id) {
    this.department_id = department_id;
  }

  public EmployeeDao() {
  }

  public EmployeeDao(Long id, String name, String email, LocalDate birth_date, Department department_id) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.birth_date = birth_date;
    this.department_id = department_id;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public LocalDate getBirth_date() {
    return birth_date;
  }

  public void setBirth_date(LocalDate birth_date) {
    this.birth_date = birth_date;
  }

  public LocalTime getCreated_time() {
    return created_time;
  }

  public void setCreated_time(LocalTime created_time) {
    this.created_time = LocalTime.now();
  }

  public LocalTime getUpdated_time() {
    return updated_time;
  }

  public void setUpdated_time(LocalTime updated_time) {
    this.updated_time = updated_time;
  }

}
