package com.example.jobportal.service;

import org.springframework.data.domain.Page;

import com.example.jobportal.dto.JobRequestDTO;
import com.example.jobportal.dto.JobResponseDTO;
import com.example.jobportal.entity.Job;


public interface JobService {

	JobResponseDTO  createJob(JobRequestDTO sortBy);
	
	Page<JobResponseDTO> getAllJobs(int page, int size, String sortBy);
	
	Page<JobResponseDTO> searchJobs(String keyword,int page, int size, String sortBy);
	
}
