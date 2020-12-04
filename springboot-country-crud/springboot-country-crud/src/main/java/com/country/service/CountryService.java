package com.country.service;

import java.util.ArrayList;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.country.model.Country;
import com.country.repository.CountryRepository;

//defining the business logic
@Service
public class CountryService {
	@Autowired
	CountryRepository countryRepository;

	//getting all countries
	public List<Country> getAllCountries() {
		List<Country> countries = new ArrayList<Country>();
		countryRepository.findAll().forEach(country -> countries.add(country));
		return countries;
	}

	//getting a specific country name
	public Country getCountryById(int id) {
		return countryRepository.findById(id).get();
	}

	// save or update a country name
	public void saveOrUpdate(Country country) {
		countryRepository.save(country);
	}

	//deleting a specific country name
	public void delete(int id) {
		countryRepository.deleteById(id);
	}
}