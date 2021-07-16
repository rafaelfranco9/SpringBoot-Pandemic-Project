package com.franco.PandemicMetrics.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.franco.PandemicMetrics.model.dto.LoginDTO;
import com.franco.PandemicMetrics.service.app.IWorldService;


@Controller
public class WorldController {

	@Autowired
	IWorldService worldService;
	
	
	@GetMapping("")
	public String topThreeCountries(Model model) {
		model.addAttribute("topThreeCountries", worldService.topThreeCountries());
		
		return "World";
	}
	
	@GetMapping("/countries")
	public String allCountries(Model model) {
		model.addAttribute("countries", worldService.getAllCountries());
		
		return "Countries";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		
		return "Login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler(); 
		logoutHandler.logout(request, null, null);
		return "redirect:/countries";
	}
	
//	@PostMapping("login")
//	public String Login(Model model,@ModelAttribute LoginDTO login) {
//		
//		if(login.getUsername().equals("admin") && login.getPassword().equals("123456")) {
//			return "redirect:/country/abm";
//		}
//		
//		model.addAttribute("userDTO", login);
//		model.addAttribute("error_message", "invalid user or password");
//		return "Login";
//	}
//	
	
}
