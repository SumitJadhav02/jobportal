package com.example.jobportal.entity;

import java.time.LocalDateTime;

import com.example.jobportal.entity.enums.ExperienceLevel;
import com.example.jobportal.entity.enums.JobType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="jobs")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String title;
	
	@NotBlank
	private String description;
	
	@NotBlank
	private String companyName;
	
	@NotBlank
	private String location;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private JobType jobType;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private ExperienceLevel experienceLevel;
	
	private Boolean isActive;
	
	private LocalDateTime postedAt;
	
	private LocalDateTime updatedAt;
	
	
	
	/*
	 * 
	 * “Used JPA lifecycle callbacks (@PrePersist, @PreUpdate) to manage timestamps automatically.”
	 * 
	 * */
	
	
	@PrePersist
	protected void onCreate()
	{
		this.postedAt = LocalDateTime.now();
		this.updatedAt = LocalDateTime.now();
		this.isActive = true;
	}
	
	@PreUpdate
	protected void onUpdate()
	{
		this.updatedAt = LocalDateTime.now();
	}
	
	
}
