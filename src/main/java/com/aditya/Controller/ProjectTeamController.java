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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aditya.Dao.ProjectTeamDao;

import com.aditya.Model.ProjectTeam;
import com.aditya.Model.ProjectTeamMemberId;
import com.aditya.Service.ProjectTeamService;

@RestController
public class ProjectTeamController {

  @Autowired
  private ProjectTeamService projectTeamService;

  private ProjectTeamDao getProjectTeamResponse(ProjectTeam projectTeam) {
    return new ProjectTeamDao(projectTeam.getId(), projectTeam.getProject(), projectTeam.getEmployee());
  }

  @GetMapping("api/project_teams")
  public ResponseEntity<List<ProjectTeamDao>> getProjectTeamList() {
    List<ProjectTeam> projectTeams = projectTeamService.getAllProjectTeam();
    List<ProjectTeamDao> projectTeamsDaos = new ArrayList<>();
    for (ProjectTeam projectTeam : projectTeams) {
      ProjectTeamDao projectTeamDao = getProjectTeamResponse(projectTeam);
      projectTeamsDaos.add(projectTeamDao);
    }
    return ResponseEntity.ok(projectTeamsDaos);
  }

  @PostMapping("api/project_teams")
  public ResponseEntity<?> addNewEntry(@RequestBody ProjectTeamDao project_team) {
    String ProjectData = projectTeamService.addNewProject(new ProjectTeam(project_team.getId(),
        project_team.getProject(), project_team.getEmployee()));
    return ResponseEntity.status(HttpStatus.CREATED).body(ProjectData);

  }

  @DeleteMapping("/api/project_teams/{id}")
  public ResponseEntity<String> DeleteProject(@PathVariable ProjectTeamMemberId id) {
    boolean deleted = projectTeamService.deleteProject(id);
    if (deleted) {
      return ResponseEntity.ok("Project with id deleted successfully");
    } else {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("Project with id does not exist");
    }

  }

}
