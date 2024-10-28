package com.example.demo.service;

import com.example.demo.entity.Passport;
import com.example.demo.repository.PassportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassportService {
    @Autowired
    private PassportRepository passportRepository;

    public Passport save(Passport passport) { return passportRepository.save(passport); }

    public Passport update(Long id, Passport passportDetails) {
        Passport passport = passportRepository.findById(id).orElse(null);
        if (passport != null) {
            passport.setPassportNumber(passportDetails.getPassportNumber());
            passport.setIssuedDate(passportDetails.getIssuedDate());
            passport.setExpiryDate(passportDetails.getExpiryDate());
            return passportRepository.save(passport);
        }
        return null;
    }

    public Passport findById(Long id) { return passportRepository.findById(id).orElse(null); }

    public void deleteById(Long id) { passportRepository.deleteById(id); }

    public Page<Passport> findAll(Pageable pageable) { return passportRepository.findAll(pageable); }

    public List<Passport> findAllSorted(Sort sort) { return passportRepository.findAll(sort); }
}
