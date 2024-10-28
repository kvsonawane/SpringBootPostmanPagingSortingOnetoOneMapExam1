package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Applicant;
import com.example.demo.service.ApplicantService;

@RestController
@RequestMapping("/applicants")
public class ApplicantController {
	
	@Autowired
	private ApplicantService applicantService;
	
	@PostMapping
	public Applicant createApplicant(@RequestBody Applicant applicant)
	{
		return applicantService.save(applicant);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Applicant> updateApplicant(@PathVariable Long id, @RequestBody Applicant applicantDetails)
	{
		Applicant updateApplicant = applicantService.update(id, applicantDetails);
		
		return updateApplicant != null ? ResponseEntity.ok(updateApplicant) : ResponseEntity.notFound().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Applicant> getApplicantById(@PathVariable Long id)
	{
		Applicant applicant = applicantService.findById(id);
		
		return applicant != null ? ResponseEntity.ok(applicant) : ResponseEntity.notFound().build();
	}
	
	@GetMapping
	public Page<Applicant> getAllApplicants(Pageable pageable)
	{
		return applicantService.findAll(pageable);
	}
	
	@GetMapping("/sorted")
	public List<Applicant> getAllApplicantsSorted(@RequestParam String sortBy,  @RequestParam String direction)
	{
		Sort sort = direction.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
		
		return applicantService.findAllSorted(sort);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteApplicant(@PathVariable Long id)
	{
		applicantService.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
	
	

}
