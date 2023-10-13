package com.marketingapp1.service;

import java.util.List;

import com.marketingapp1.dto.LeadDto;
import com.marketingapp1.entity.Lead;

public interface LeadService {
      public void saveLead(Lead lead);

	public List<Lead> findAllLeads();

	public void deleteLeadById(long id);

	public Lead findLeadById(long id);

	public void updateLead(LeadDto dto);
}
