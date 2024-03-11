package com.aditya.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aditya.Model.ProjectTeam;
import com.aditya.Model.ProjectTeamMemberId;

public interface ProjectTeamRepo extends JpaRepository<ProjectTeam, ProjectTeamMemberId> {

}
