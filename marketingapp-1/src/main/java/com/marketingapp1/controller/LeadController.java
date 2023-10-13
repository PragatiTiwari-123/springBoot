package com.marketingapp1.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketingapp1.dto.LeadDto;
import com.marketingapp1.entity.Lead;
import com.marketingapp1.service.LeadService;
import com.marketingapp1.util.EmailService;

@Controller
public class LeadController {
	@Autowired
	private LeadService leadService;
	//http://localhost:8080/viewLeadForm
	@Autowired
	private EmailService emailService;
	
	@RequestMapping("/viewLeadForm")
        public String viewLeadForm() {
        	return "create_lead";//here  return keyword means load that page on browser
        }
	//1st method copy the form data into entity object.
	//@ModelAttribute:Whenever your reading the data form to Entity class actually suppose to write 1 annotation @ModelAttribute
	@RequestMapping("/saveLead") 
	public String saveLeadInfo(@ModelAttribute Lead lead,Model model){  
		    leadService.saveLead(lead);
		    emailService.sendEmail(lead.getEmail(), "Test", "Welcome");
		    model.addAttribute("msg", "Record is saved");
		    return "create_lead";
	}
// 2nd method field by field copy the data using @RequestParam.	
//	@RequestMapping("/saveLead") 
//	public String saveLeadInfo(
//			@RequestParam("first") String firstName,//in order to read data we use @Request
//			@RequestParam("lastName") String lastName,
//			@RequestParam("email") String email,
//			@RequestParam("mobile") long mobile
//			)
//	{  
//		    Lead l = new Lead();
//		    l.setFirstName(firstName);
//		    l.setLastName(lastName);
//		    l.setEmail(email);
//		    l.setMobile(mobile);
//		    leadService.saveLead(l); 
//		    return "create_lead";
//	}
//	@RequestMapping("/saveLead") 
//	public String saveLeadInfo(LeadDto dto){ //3rd this is ordinary java class.
//		
//		    Lead lead = new Lead();
//		    lead.setFirstName(dto.getFirstName());
//		    lead.setLastName(dto.getLastName());
//		    lead.setEmail(dto.getEmail());
//		    lead.setMobile(dto.getMobile());
//		    leadService.saveLead(lead); 
//		    return "create_lead";
//	}
// http://localhost:8080/listall
   @RequestMapping("/listall")
   public String getAllLeads(Model model) {
	   List<Lead> leads = leadService.findAllLeads();
	   model.addAttribute("leads", leads);//attributeName, attributeValue are given
	   return "list_leads";
   }
   @RequestMapping("/delete")
   public String deleteLeadById(@RequestParam("id") long id, Model model) {
	   leadService.deleteLeadById(id);
	   List<Lead> leads = leadService.findAllLeads();
	   model.addAttribute("leads", leads);//attributeName, attributeValue are given
	   return "list_leads";
   }
   @RequestMapping("/update")
   public String updateLeadById(@RequestParam("id") long id, Model model) {
	   Lead lead = leadService.findLeadById(id);
	   model.addAttribute("lead", lead);
	   return "update_lead";
   }
   @RequestMapping("/updateLead")
   public String updateLead(LeadDto dto,Model model) {
	   leadService.updateLead(dto);
	   List<Lead> leads = leadService.findAllLeads();
	   model.addAttribute("leads", leads);//attributeName, attributeValue are given
	   return"list_leads"; 
   }
}   
