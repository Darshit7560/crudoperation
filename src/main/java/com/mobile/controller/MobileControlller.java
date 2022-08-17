package com.mobile.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.mobile.model.Mobile;
import com.mobile.service.MobileService;

@Controller
public class MobileControlller {
	
	@Autowired
	private MobileService mobileService;
	
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		return "index";	
	}
	
	
	@GetMapping("/showNewMobileForm")
	public String showNewEmployeeForm(Model model) {
		
		Mobile mobile = new Mobile();
		model.addAttribute("mobile", mobile);
		return "addmobile";
	}
	
	
	@PostMapping("/saveMobile")
	public String saveEmployee(@ModelAttribute("mobile") Mobile mobile,Model model) {
		mobileService.saveMobile(mobile);
		model.addAttribute("mobile",mobile);
		
		return "redirect:/";
	}
	
	@GetMapping("/showMobile")
	public String showContacts(Model model) {
		
		
       List<Mobile> allMobiles = mobileService.getAllMobiles();
       System.out.println(allMobiles);
       model.addAttribute("allMobiles", allMobiles);
      
       return "index";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") int id, Model model) {
		
		Mobile mobile = mobileService.getMobileById(id);
		model.addAttribute("mobile", mobile);
		return "updatephone";
	}
	
	@GetMapping("/deleteMobile/{id}")
	public String deleteMobiById(@PathVariable (value = "id") int id) {
		
		// call delete employee method 
		this.mobileService.deleteMobiById(id);
		return "redirect:/";
	}

	
	

}
