package com.aditya.Model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "project_team_members")
public class ProjectTeam {
  @EmbeddedId
  private ProjectTeamMemberId id;

  @ManyToOne
  @MapsId("projectId")
  @JoinColumn(name = "project_id")
  private Project project;

  @ManyToOne
  @MapsId("employeeId")
  @JoinColumn(name = "employee_id")
  private Employee employee;

  public ProjectTeam() {
  }

  public ProjectTeam(ProjectTeamMemberId id, Project project, Employee employee) {
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
