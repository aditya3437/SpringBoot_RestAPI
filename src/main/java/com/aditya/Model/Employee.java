package com.aditya.Model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String email;
  private LocalDate birth_date;
  private LocalTime created_time = LocalTime.now();
  private LocalTime updated_time;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "department_id")
  private Department department_id;

  @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
  private List<ProjectTeam> projectTeam;

  public Employee() {

  }

  public Employee(Long id, String name, String email, LocalDate birth_date, LocalTime created_time,
      LocalTime updated_time, Department department_id, List<ProjectTeam> projectTeam) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.birth_date = birth_date;
    this.created_time = created_time;
    this.updated_time = updated_time;
    this.department_id = department_id;
    this.projectTeam = projectTeam;
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
    this.created_time = created_time;
  }

  public LocalTime getUpdated_time() {
    return updated_time;
  }

  public void setUpdated_time(LocalTime updated_time) {
    this.updated_time = updated_time;
  }

  public Department getDepartment_id() {
    return department_id;
  }

  public void setDepartment_id(Department department_id) {
    this.department_id = department_id;
  }

  public List<ProjectTeam> getProjectTeam() {
    return projectTeam;
  }

  public void setProjectTeam(List<ProjectTeam> projectTeam) {
    this.projectTeam = projectTeam;
  }

}
