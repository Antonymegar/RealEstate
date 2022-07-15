package com.example.realestate.Payload;

import com.example.realestate.model.ProjectStatus;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CategoryRequest {

    @NotBlank
    @Size(max = 100)
    private String name;

    @NotBlank
    @Size(max = 80)
    private String location;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60)
    private ProjectStatus projectStatus;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ProjectStatus getProjectStatus(ProjectStatus availablePlots, ProjectStatus soldOut) {
        return projectStatus;
    }

    public void setProjectStatus(ProjectStatus projectStatus) {
        this.projectStatus = projectStatus;
    }
}
