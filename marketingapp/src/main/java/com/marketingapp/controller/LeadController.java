package com.marketingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.marketingapp.dto.LeadDto;
import com.marketingapp.entity.Lead;
import com.marketingapp.service.LeadService;
//so this is mediater layer which can interact to the view & Interact with backend just like servlet.
@Controller
public class LeadController {
	@Autowired
	private LeadService leadService; 
	//now how call this method so call this method build a url.example
	//http://localhost:8080/viewLeadForm
    //here we get'n post method here we develop own methods returns type string.
	@RequestMapping("viewLeadForm")
	public String viewLeadForm() {
		//when you write return then write only file name without extension.
		return"create_lead"; // here return meaning is load that page on browser it act like request dispatcher.
	}
	//1st approach it is handler methods which handle incoming & outgoing request.
//	@RequestMapping("/saveLead")
//	public String saveLeadInfo(Lead lead) {
//		leadService.saveLead(lead);//this line show data into database
//		return"create_lead";
//	}
	//2nd approach here we will not use Entity class.
	//i want read the data with use of @RequestParam
//	@RequestMapping("/saveLead")
//	public String saveLeadInfo(
//			@RequestParam("first")String firstName,//so these are method argument
//			@RequestParam("lastName")String lastName,
//			@RequestParam("email")String email,
//			@RequestParam("mobile")long mobile
//			) 
//	{   
//		Lead l = new Lead();//object
//		l.setFirstName(firstName);//so here initialize all method
//		l.setLastName(lastName);
//		l.setEmail(email);
//		l.setMobile(mobile);
//		leadService.saveLead(l);//this line show data into database
//		return"create_lead";
//	}
	@RequestMapping("/saveLead")
	public String saveLeadInfo(LeadDto dto) {
		Lead lead = new Lead();
		lead.setFirstName(dto.getFirstName());
		lead.setLastName(dto.getLastName());
		lead.setEmail(dto.getEmail());
		lead.setMobile(dto.getMobile());
		leadService.saveLead(lead);//this line show data into database
		return"create_lead";
	}


}
