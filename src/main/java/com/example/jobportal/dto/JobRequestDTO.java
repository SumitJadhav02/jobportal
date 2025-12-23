package com.example.jobportal.dto;

import com.example.jobportal.entity.enums.ExperienceLevel;
import com.example.jobportal.entity.enums.JobType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobRequestDTO {

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @NotBlank
    private String companyName;

    @NotBlank
    private String location;

    @NotNull
    private JobType jobType;

    @NotNull
    private ExperienceLevel experienceLevel;
}
