package com.aditya.Model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class ProjectTeamMemberId implements Serializable {

    private Long projectId;
    private Long employeeId;

    public ProjectTeamMemberId() {
    }

    public ProjectTeamMemberId(Long projectId, Long employeeId) {
        this.projectId = projectId;
        this.employeeId = employeeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof ProjectTeamMemberId))
            return false;
        ProjectTeamMemberId that = (ProjectTeamMemberId) o;
        return Objects.equals(getProjectId(), that.getProjectId()) &&
                Objects.equals(getEmployeeId(), that.getEmployeeId());
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProjectId(), getEmployeeId());
    }
}
