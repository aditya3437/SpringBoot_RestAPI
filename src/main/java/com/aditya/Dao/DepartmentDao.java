package com.aditya.Dao;

import java.time.LocalTime;

public class DepartmentDao {

  private Long id;
  private String name;
  private String description;
  private LocalTime createdTime = LocalTime.now();
  private LocalTime updatedTime;

  public DepartmentDao() {

  }

  public DepartmentDao(Long id, String name, String description) {
    this.id = id;
    this.name = name;
    this.description = description;

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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public LocalTime getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(LocalTime createdTime) {
    this.createdTime = createdTime;
  }

  public LocalTime getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(LocalTime updatedTime) {
    this.updatedTime = LocalTime.now();
  }
}
