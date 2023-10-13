package com.marketingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketingapp.entity.Lead;
import com.marketingapp.repository.LeadRepository;
@Service 
public class LeadServiceImpl implements LeadService {
	@Autowired
    private LeadRepository leadRepo;
	
	@Override
	public void saveLead(Lead lead) {// now this call this method from controller so go to controller create object of service layer.
         leadRepo.save(lead);
	}

}
