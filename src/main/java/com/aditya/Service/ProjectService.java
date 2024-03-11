package com.aditya.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aditya.Dao.ProjectDao;

import com.aditya.Model.Project;
import com.aditya.Repository.ProjectRepo;

@Service
public class ProjectService {

  @Autowired
  private ProjectRepo projectRepo;

  public List<Project> getAllProjects() {
    List<Project> projects = new ArrayList<>();
    projectRepo.findAll().forEach(project -> projects.add(project));
    return projects;
  }

  public Project getprojectDetails(Long id) {
    Optional<Project> project = projectRepo.findById(id);
    if (project.isPresent()) {
      return project.get();
    }
    return null;

  }

  public Project addNewProjects(Project project) {
    return projectRepo.save(project);

  }

  public Project updateProjects(ProjectDao project, Long id) {
    Optional<Project> updatePro = projectRepo.findById(id);
    if (updatePro.isPresent()) {
      Project uProject = updatePro.get();
      uProject.setName(project.getName());
      uProject.setDescription(project.getDescription());
      uProject.setIs_active(project.getIs_active());

      return projectRepo.save(uProject);
    }
    return null;
  }

  public boolean deleteProject(Long id) {
    if (projectRepo.existsById(id)) {
      projectRepo.deleteById(id);
      return true;
    }
    return false;
  }

  public Project projectDao(ProjectDao projectDao) {
    Project project = new Project();
    project.setId(projectDao.getId());
    project.setName(projectDao.getName());
    project.setDescription(projectDao.getDescription());
    project.setIs_active(projectDao.getIs_active());
    return project;
  }

  public ProjectDao Project(Project p) {
    ProjectDao projectDao = new ProjectDao();
    projectDao.setId(p.getId());
    projectDao.setName(p.getName());
    projectDao.setDescription(p.getDescription());
    projectDao.setIs_active(p.isIs_active());
    return projectDao;

  }

  public String addNewProject(Project project2) {
    Project project = new Project();
    project.setId(project2.getId());
    project.setName(project2.getName());
    project.setDescription(project2.getDescription());
    project.setIs_active(project2.isIs_active());
    Project savedEmployee2 = projectRepo.save(project);
    return "Employee created successfully with ID: " + savedEmployee2.getId();
  }

}
