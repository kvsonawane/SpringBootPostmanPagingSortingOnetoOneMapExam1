package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Passport;

@Repository
public interface PassportRepository extends JpaRepository<Passport, Long>{

}
