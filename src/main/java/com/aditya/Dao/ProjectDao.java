package com.aditya.Dao;

import java.time.LocalTime;

public class ProjectDao {

  private Long id;
  private String name;
  private String description;
  private boolean is_active;
  private LocalTime created_time = LocalTime.now();
  private LocalTime updated_time;

  public ProjectDao() {
  }

  public ProjectDao(Long id, String name, String description, boolean is_active) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.is_active = is_active;

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

  public boolean getIs_active() {
    return is_active;
  }

  public void setIs_active(boolean is_active) {
    this.is_active = is_active;
  }

  public LocalTime getCreated_time() {
    return created_time;
  }

  public void setCreated_time(LocalTime created_time) {
    this.created_time = created_time;
  }

  public LocalTime getUpdated_time() {
    return updated_time;
  }

  public void setUpdated_time(LocalTime updated_time) {
    this.updated_time = LocalTime.now();
  }

}
