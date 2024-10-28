package com.example.demo.service;


import com.example.demo.entity.Applicant;
import com.example.demo.repository.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicantService {
    @Autowired
    private ApplicantRepository applicantRepository;

    public Applicant save(Applicant applicant) { return applicantRepository.save(applicant); }

    public Applicant update(Long id, Applicant applicantDetails) {
        Applicant applicant = applicantRepository.findById(id).orElse(null);
        if (applicant != null) {
            applicant.setName(applicantDetails.getName());
            applicant.setAge(applicantDetails.getAge());
            applicant.setCity(applicantDetails.getCity());
            applicant.setPassport(applicantDetails.getPassport());
            return applicantRepository.save(applicant);
        }
        return null;
    }

    public Applicant findById(Long id) { return applicantRepository.findById(id).orElse(null); }

    public void deleteById(Long id) { applicantRepository.deleteById(id); }

    public Page<Applicant> findAll(Pageable pageable) { return applicantRepository.findAll(pageable); }

    public List<Applicant> findAllSorted(Sort sort) { return applicantRepository.findAll(sort); }
}
