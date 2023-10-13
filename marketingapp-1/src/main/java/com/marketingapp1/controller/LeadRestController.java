package com.marketingapp1.controller;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketingapp1.dto.LeadDto;
import com.marketingapp1.entity.Lead;
import com.marketingapp1.exception.ResourceNotFoundException;
import com.marketingapp1.repository.LeadRepository;

//Develop API'S //we implemented API into the Web(Browser).
@RestController
@RequestMapping("/api/leads")
public class LeadRestController {
	@Autowired
	private LeadRepository leadRepo;
	
	//http://localhost:8080/api/leads
	
	@GetMapping
	public List<Lead> getAllLeads(){
		List<Lead> leads = leadRepo.findAll();
		return leads;
	}
    
	@PostMapping
	public ResponseEntity<?> saveLead(
			@Valid @RequestBody Lead lead,//so here validation happen
			BindingResult result//this is find error 
            ) {
		if(result.hasErrors()) {
			return new ResponseEntity<>(result.getFieldError().getDefaultMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
		Lead saveLead = leadRepo.save(lead);
		return new ResponseEntity<>(saveLead, HttpStatus.CREATED);
	}
	
	//http://localhost:8080/api/lead/{id}
	@PutMapping ("{id}")//it is used for updating records
	public ResponseEntity<Lead> updateLead(
			@PathVariable long id,
			@RequestBody LeadDto dto
			){	
		Optional<Lead> findById = leadRepo.findById(id);
		Lead lead = findById.get();
		
		lead.setFirstName(dto.getFirstName());
		lead.setLastName(dto.getLastName());
		lead.setEmail(dto.getEmail());
		lead.setMobile(dto.getMobile());
		
		leadRepo.save(lead);
		
		return new ResponseEntity<>(lead,HttpStatus.OK);
	}
	
	//http://localhost:8080/api/lead/{id}
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteLeadById(@PathVariable long id){
		Lead lead = leadRepo.
				            findById(id).
				                        orElseThrow(				                        
				                        		()->new ResourceNotFoundException("Lead not found")
				                        		 );
                                      		
        leadRepo.deleteById(id);
		return new ResponseEntity<String>("Lead is deleted", HttpStatus.OK);
	}
}
