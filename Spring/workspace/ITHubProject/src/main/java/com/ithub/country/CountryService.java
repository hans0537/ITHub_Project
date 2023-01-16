package com.ithub.country;

import java.util.List;

import com.ithub.city.CityDTO;

public class CountryService {
	
	public CountryDAO countryDAO;
	
	public void setCountryDAO(CountryDAO countryDAO) {
		this.countryDAO = countryDAO;
	}
	
	public List<CityDTO> getCity() {
		return countryDAO.getCity();
	}

	public List<CountryDTO> getCountry() {
		return countryDAO.getCountry();
	}
}
