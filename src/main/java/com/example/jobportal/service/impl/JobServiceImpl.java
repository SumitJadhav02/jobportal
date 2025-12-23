package com.example.jobportal.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import com.example.jobportal.dto.JobRequestDTO;
import com.example.jobportal.dto.JobResponseDTO;
import com.example.jobportal.entity.Job;
import com.example.jobportal.mapper.JobMapper;
import com.example.jobportal.repository.JobRepository;
import com.example.jobportal.service.JobService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

	private final JobRepository jobRepository;
	private final JobMapper jobmapper;

	@Override
	public JobResponseDTO createJob( JobRequestDTO jobRequestDTO) {
		 Job job = jobmapper.toEntity(jobRequestDTO);
		 Job savedJob  = jobRepository.save(job);
		 return jobmapper.toDto(savedJob );
		
	}

	@Override
	public Page<JobResponseDTO> getAllJobs(int page, int size, String sortBy) {

		Sort sort = Sort.by(sortBy).ascending();
		PageRequest pageRequest = PageRequest.of(page, size, sort);

		Page<Job> job = jobRepository.findAll(pageRequest);

		return job.map(jobmapper::toDto);
	}

	@Override
	public Page<JobResponseDTO> searchJobs(String keyword, int page, int size, String sortBy) {

	    Sort sort = Sort.by(sortBy).ascending();
	    PageRequest pageRequest = PageRequest.of(page, size, sort);

	    return jobRepository
	            .findByTitleContainingIgnoreCaseOrCompanyNameContainingIgnoreCase(
	                    keyword,
	                    keyword,
	                    pageRequest
	            ).map(jobmapper::toDto);
	}


}
