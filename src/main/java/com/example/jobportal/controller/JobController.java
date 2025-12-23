package com.example.jobportal.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.jobportal.dto.JobRequestDTO;
import com.example.jobportal.dto.JobResponseDTO;
import com.example.jobportal.service.JobService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/jobs")
@RequiredArgsConstructor
public class JobController {

    private final JobService jobService;

    @PostMapping
    public ResponseEntity<JobResponseDTO> createNewJob(@Valid @RequestBody JobRequestDTO  jobRequestDTO) {
    	JobResponseDTO newJob = jobService.createJob(jobRequestDTO);
        return ResponseEntity.ok(newJob);
    }

    @GetMapping
    public ResponseEntity<Page<JobResponseDTO>> getAllJobs(
            @RequestParam(defaultValue = "1", name="page") int page,
            @RequestParam(defaultValue = "5", name="size") int size,
            @RequestParam(defaultValue = "postedAt", name="sortBy") String sortBy) {

        Page<JobResponseDTO> jobs = jobService.getAllJobs(page-1, size, sortBy);
        return ResponseEntity.ok(jobs);
    }
    
    @GetMapping("/search")
    public ResponseEntity<Page<JobResponseDTO>> searchJobs(
    		@RequestParam(name="keyword") String keyword,
    		@RequestParam(defaultValue = "1", name="page") int page,
            @RequestParam(defaultValue = "5", name="size") int size,
            @RequestParam(defaultValue = "postedAt", name="sortBy") String sortBy)
    {
    	Page<JobResponseDTO> searchjobs = jobService.searchJobs(keyword, page-1, size, sortBy);
    	
    	return ResponseEntity.ok(searchjobs);
    }
}
