package com.aditya.Dao;

import com.aditya.Model.Employee;
import com.aditya.Model.Project;
import com.aditya.Model.ProjectTeamMemberId;

public class ProjectTeamDao {

  private ProjectTeamMemberId id;

  private Project project;

  private Employee employee;

  public ProjectTeamDao() {
  }

  public ProjectTeamDao(ProjectTeamMemberId id, Project project, Employee employee) {
    this.id = id;
    this.project = project;
    this.employee = employee;
  }

  public ProjectTeamMemberId getId() {
    return id;
  }

  public void setId(ProjectTeamMemberId id) {
    this.id = id;
  }

  public Project getProject() {
    return project;
  }

  public void setProject(Project project) {
    this.project = project;
  }

  public Employee getEmployee() {
    return employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

}