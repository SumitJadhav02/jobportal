package com.example.jobportal.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.jobportal.entity.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

	Page<Job> findByTitleContainingIgnoreCaseOrCompanyNameContainingIgnoreCase(
			                                        String title,
			                                        String companyName,
			                                        Pageable pageable
			                                        );
}
