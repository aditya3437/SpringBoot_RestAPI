package com.aditya.Model;

import java.time.LocalDate;
import java.time.LocalTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "department")
public class Department {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)

  private Long id;

  private String name;

  private String description;
  LocalTime createdTime = LocalTime.now();

  private LocalDate updatedTime;

  @OneToOne(mappedBy = "department_id")
  private Employee employee;

  public Department() {
  }

  public Department(Long id, String name, String description) {
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

  public LocalDate getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(LocalTime localTime) {
    this.updatedTime = LocalDate.now();
  }

}
