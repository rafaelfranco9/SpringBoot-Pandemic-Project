package com.franco.PandemicMetrics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.franco.PandemicMetrics.helpers.GeneralFunctions;
import com.franco.PandemicMetrics.model.Country;
import com.franco.PandemicMetrics.model.dto.DeleteCountryDTO;
import com.franco.PandemicMetrics.model.dto.NewCountryDTO;
import com.franco.PandemicMetrics.model.dto.UpdateCountryDTO;
import com.franco.PandemicMetrics.service.db.IContinentServiceJpa;
import com.franco.PandemicMetrics.service.db.ICountryServiceJpa;

@Controller
@RequestMapping("country")
public class CountryController {
	
	@Autowired
	IContinentServiceJpa continentServiceJpa;
	
	@Autowired
	ICountryServiceJpa countryServiceJpa;
	
	@Autowired
	Environment env;

	@GetMapping("/abm")
	public String AbmCountry(Model model) {
		
		model.addAttribute("addCountryDTO",new NewCountryDTO());
		model.addAttribute("updateCountryDTO",new UpdateCountryDTO());
		model.addAttribute("deleteCountryDTO", new DeleteCountryDTO());
		model.addAttribute("continents",continentServiceJpa.getAll());
		model.addAttribute("countries",countryServiceJpa.listCountriesData());
		
		
		return "AbmCountries";
	}
	
	@PostMapping("/new")
	public String addCountry(@ModelAttribute NewCountryDTO country,@RequestParam("imageFile") MultipartFile imageFile,RedirectAttributes redirectAttr,BindingResult result) {
		
		if(!result.hasErrors()) {

			if(!imageFile.isEmpty()) {
				String imageFileName = GeneralFunctions.saveImage(imageFile,env.getProperty("pandemicMetrics.routes.images"));
				country.setImage(imageFileName);
			}

			countryServiceJpa.insert(country);
			redirectAttr.addFlashAttribute("create_message", "Country saved successfully");
					
		}else {
			redirectAttr.addFlashAttribute("create_message", "Error while saving country");
		}
		
		return "redirect:/country/abm";
	}
	
	
	@PostMapping("/update")
	public String addCountry(@ModelAttribute UpdateCountryDTO country,@RequestParam("imageFile") MultipartFile imageFile,RedirectAttributes redirectAttr,BindingResult result) {
		
		if(!result.hasErrors()) {
				
			if(!imageFile.isEmpty()) {
				String imageFileName = GeneralFunctions.saveImage(imageFile,env.getProperty("pandemicMetrics.routes.images"));
				country.setImage(imageFileName);
			}
			
			countryServiceJpa.update(country);
			redirectAttr.addFlashAttribute("update_message", "Country updated successfully");
					
		}else {
			redirectAttr.addFlashAttribute("update_message", "Error while updating country");
		}
		
		return "redirect:/country/abm";
	}
	
	
	@PostMapping("/delete")
	public String deleteCountry(@ModelAttribute DeleteCountryDTO country,RedirectAttributes redirectAttr,BindingResult result) {
		
		if(!result.hasErrors()) {
			
			countryServiceJpa.delete(country);
			redirectAttr.addFlashAttribute("delete_message", "Country deleted successfully");
					
		}else {
			redirectAttr.addFlashAttribute("delete_message", "Error while deleting country");
		}
		
		
		return "redirect:/country/abm";
	}
	
	
	
	@GetMapping("/countryData")
	public String country(@RequestParam("id") Integer countryId, Model model) {
		
		Country country = countryServiceJpa.getById(countryId);
		model.addAttribute("country", country);
		
		return "CountryData";
	}
	
	

}
