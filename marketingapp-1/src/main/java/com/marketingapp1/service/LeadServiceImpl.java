package com.marketingapp1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketingapp1.dto.LeadDto;
import com.marketingapp1.entity.Lead;
import com.marketingapp1.repository.LeadRepository;

@Service
public class LeadServiceImpl implements LeadService {
	@Autowired
	private LeadRepository leadRepo;

	@Override
	public void saveLead(Lead lead) {
		leadRepo.save(lead);
	}
 
	@Override
	public List<Lead> findAllLeads() {
        List<Lead> leads = leadRepo.findAll();
        return leads;
	}

	@Override
	public void deleteLeadById(long id) {
		 leadRepo.deleteById(id);
	}

	@Override
	public Lead findLeadById(long id) {
		return leadRepo.findById(id).get();
	}

	@Override
	public void updateLead(LeadDto dto) {
		 Lead lead = new Lead();
		 lead.setId(dto.getId());
		 lead.setFirstName(dto.getFirstName());
		 lead.setLastName(dto.getLastName());
		 lead.setEmail(dto.getEmail());
		 lead.setMobile(dto.getMobile());
		 leadRepo.save(lead);
	}
}
