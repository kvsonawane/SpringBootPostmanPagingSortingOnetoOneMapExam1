package com.example.demo.controller;

import com.example.demo.entity.Passport;
import com.example.demo.service.PassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passports")
public class PassportController {
    @Autowired
    private PassportService passportService;

    @PostMapping
    public Passport createPassport(@RequestBody Passport passport) { return passportService.save(passport); }

    @PutMapping("/{id}")
    public ResponseEntity<Passport> updatePassport(@PathVariable Long id, @RequestBody Passport passportDetails) {
        Passport updatedPassport = passportService.update(id, passportDetails);
        return updatedPassport != null ? ResponseEntity.ok(updatedPassport) : ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Passport> getPassportById(@PathVariable Long id) {
        Passport passport = passportService.findById(id);
        return passport != null ? ResponseEntity.ok(passport) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public Page<Passport> getAllPassports(Pageable pageable) 
    { 
    	return passportService.findAll(pageable); 
    }

    @GetMapping("/sorted")
    public List<Passport> getAllPassportsSorted(@RequestParam String sortBy, @RequestParam String direction) 
    {
    	Sort sort = direction.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
		
		return passportService.findAllSorted(sort);
        		
    }
    
    @DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePassport(@PathVariable Long id)
	{
		passportService.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
	
}
