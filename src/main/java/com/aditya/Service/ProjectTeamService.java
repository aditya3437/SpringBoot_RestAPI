package com.aditya.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aditya.Dao.ProjectTeamDao;
import com.aditya.Model.ProjectTeam;
import com.aditya.Model.ProjectTeamMemberId;
import com.aditya.Repository.ProjectTeamRepo;

@Service
public class ProjectTeamService {

  @Autowired
  private ProjectTeamRepo projectTeamRepo;

  public List<ProjectTeam> getAllProjectTeam() {
    List<ProjectTeam> projectTeams = new ArrayList<>();
    projectTeamRepo.findAll().forEach(projectTeam -> projectTeams.add(projectTeam));
    return projectTeams;
  }

  public ProjectTeam addNewEntryTeam(ProjectTeam projectTeam) {
    return projectTeamRepo.save(projectTeam);
  }

  public boolean deleteProject(ProjectTeamMemberId id) {
    if (projectTeamRepo.existsById(id)) {
      projectTeamRepo.deleteById(id);
      return true;
    }
    return false;
  }

  public ProjectTeam projectTeamDao(ProjectTeamDao projectTeamDao) {
    ProjectTeam team = new ProjectTeam();
    team.setEmployee(projectTeamDao.getEmployee());
    team.setId(projectTeamDao.getId());
    team.setProject(projectTeamDao.getProject());
    return team;
  }

  public ProjectTeamDao projectTeam(ProjectTeam team) {
    ProjectTeamDao projectTeamDao = new ProjectTeamDao();
    projectTeamDao.setId(team.getId());
    projectTeamDao.setEmployee(team.getEmployee());
    projectTeamDao.setProject(team.getProject());
    return projectTeamDao;
  }

  public String addNewProject(ProjectTeam project2) {
    ProjectTeam project = new ProjectTeam();
    project.setId(project2.getId());
    project.setEmployee(project2.getEmployee());
    project.setProject(project2.getProject());
    ProjectTeam savedProjectTeam = projectTeamRepo.save(project);
    return "ProjectTeamMemeber created successfully with ID: " + savedProjectTeam.getId();
  }

}
