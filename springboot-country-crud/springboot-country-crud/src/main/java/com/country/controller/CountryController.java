package com.country.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.country.model.Country;
import com.country.service.CountryService;

@RestController
@RequestMapping("/rest/v2")
public class CountryController {
	
	//auto wired the CountryService class	
	@Autowired
	CountryService countryService;

	//creating a get mapping that retrieves all the countries details 
	@GetMapping("/countries")
	private List<Country> getAllCountries() {
		return countryService.getAllCountries();
	}

	//creating a get mapping that retrieves the detail of a specific country by id
	@GetMapping("/country/{id}")
	private Country getCountry(@PathVariable("id") int id) {
		return countryService.getCountryById(id);
	}

	@DeleteMapping("/country/{id}")
	private void deleteCountry(@PathVariable("id") int id) {
		countryService.delete(id);
	}

	//creating post mapping that post the country details 
	@PostMapping("/country")
	private int saveCountry(@RequestBody Country country) {
		countryService.saveOrUpdate(country);
		return country.getId();
	}
}