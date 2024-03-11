package com.aditya.Model;

import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "project")
public class Project {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String description;
  private boolean is_active;
  private LocalTime created_time = LocalTime.now();
  private LocalTime updated_time;

  @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
  private List<ProjectTeam> project_id;

  public Project() {
  }

  public Project(Long id, String name, String description, boolean is_active, List<ProjectTeam> project_id) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.is_active = is_active;
    this.project_id = project_id;

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

  public boolean isIs_active() {
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
    this.updated_time = updated_time;
  }

  public List<ProjectTeam> getProject_Id() {
    return project_id;
  }

  public void setProject_Id(List<ProjectTeam> project_id) {
    this.project_id = project_id;
  }

}
