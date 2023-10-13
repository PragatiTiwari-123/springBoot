package com.marketingapp1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marketingapp1.entity.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long> {

}
