package com.example.jobportal.dto;


import java.time.LocalDateTime;

import com.example.jobportal.entity.enums.ExperienceLevel;
import com.example.jobportal.entity.enums.JobType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobResponseDTO {

    private Long id;
    private String title;
    private String description;
    private String companyName;
    private String location;
    private JobType jobType;
    private ExperienceLevel experienceLevel;
    private Boolean isActive;
    private LocalDateTime postedAt;
    private LocalDateTime updatedAt;
}

