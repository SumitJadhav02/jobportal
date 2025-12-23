package com.example.jobportal.mapper;

import org.mapstruct.Mapper;

import com.example.jobportal.dto.JobRequestDTO;
import com.example.jobportal.dto.JobResponseDTO;
import com.example.jobportal.entity.Job;

@Mapper(componentModel = "spring")
public interface JobMapper {
	
	Job toEntity(JobRequestDTO dto);
	
	JobResponseDTO toDto(Job job);
	

}
