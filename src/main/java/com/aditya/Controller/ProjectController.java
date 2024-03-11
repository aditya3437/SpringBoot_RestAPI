package com.aditya.Controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aditya.Dao.ProjectDao;

import com.aditya.Model.Project;
import com.aditya.Service.ProjectService;

@RestController
public class ProjectController {

  @Autowired
  private ProjectService projectService;

  private ProjectDao getProjectresponse(Project project) {
    return new ProjectDao(project.getId(), project.getName(), project.getDescription(), project.isIs_active());
  }

  @GetMapping("/api/projects")
  public ResponseEntity<List<ProjectDao>> getProjects() {
    List<Project> projects = projectService.getAllProjects();
    List<ProjectDao> projectDaos = new ArrayList<>();
    for (Project project : projects) {
      ProjectDao projectDao = getProjectresponse(project);
      projectDaos.add(projectDao);
    }
    return ResponseEntity.ok(projectDaos);

  }

  @GetMapping("/api/projects/{id}")
  public ResponseEntity<ProjectDao> getProjectbyId(@PathVariable Long id) {
    Project project = projectService.getprojectDetails(id);
    if (project != null) {
      ProjectDao projectDao = new ProjectDao(project.getId(), project.getName(), project.getDescription(),
          project.isIs_active());
      return ResponseEntity.ok(projectDao);
    } else {
      return ResponseEntity.notFound().build();
    }

  }

  @PostMapping("/api/projects")
  public ResponseEntity<?> addProject(@RequestBody ProjectDao project) {
    String ProjectData = projectService.addNewProject(
        new Project(project.getId(), project.getName(), project.getDescription(), project.getIs_active(), null));
    return ResponseEntity.status(HttpStatus.CREATED).body(ProjectData);

  }

  @PutMapping("/api/projects/{id}")
  public ResponseEntity<?> UpdateProject(@RequestBody ProjectDao project, @PathVariable Long id) {
    Project updatedProject = projectService.updateProjects(project, id);
    if (updatedProject != null) {
      return ResponseEntity.ok(updatedProject);
    } else {
      return ResponseEntity.notFound().build();
    }

  }

  @DeleteMapping("/api/projects/{id}")
  public ResponseEntity<String> DeleteProject(@PathVariable Long id) {
    boolean deleted = projectService.deleteProject(id);
    if (deleted) {
      return ResponseEntity.ok("Project with id deleted successfully");
    } else {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("Project with id does not exist");
    }

  }

}
