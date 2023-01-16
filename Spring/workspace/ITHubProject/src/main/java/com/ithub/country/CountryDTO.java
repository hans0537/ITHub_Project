package com.ithub.country;

import java.util.ArrayList;

import com.ithub.city.CityDTO;

public class CountryDTO {
	
	private int cSeq;
	private String cName;
	
	private ArrayList<CityDTO> city = new ArrayList<CityDTO>();
	
	public CountryDTO() {}

	public CountryDTO(int cSeq, String cName) {
		this.cSeq = cSeq;
		this.cName = cName;
	}

	public CountryDTO(int cSeq, String cName, ArrayList<CityDTO> city) {
		this.cSeq = cSeq;
		this.cName = cName;
		this.city = city;
	}

	public int getcSeq() {
		return cSeq;
	}

	public void setcSeq(int cSeq) {
		this.cSeq = cSeq;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public ArrayList<CityDTO> getCity() {
		return city;
	}

	public void setCity(ArrayList<CityDTO> city) {
		this.city = city;
	}

}
