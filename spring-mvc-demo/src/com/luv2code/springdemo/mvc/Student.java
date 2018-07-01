package com.luv2code.springdemo.mvc;
import java.util.*;
public class Student {
	String firstName;
	String lastName;
	String country;
	private LinkedHashMap<String, String> countryOption;
	private String favoriteLangauge;
	private String[] operatingSystem;
	public Student() {
		countryOption=new LinkedHashMap<String, String>();
		countryOption.put("Brazil", "BRA");
		countryOption.put("India", "IND");
		countryOption.put("United State of America", "USA");
		countryOption.put("Australia", "AUS");
		
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public LinkedHashMap<String, String> getCountryOption() {
		return countryOption;
	}
	public String getFavoriteLangauge() {
		return favoriteLangauge;
	}
	public void setFavoriteLangauge(String favoriteLangauge) {
		this.favoriteLangauge = favoriteLangauge;
	}
	public void setCountryOption(LinkedHashMap<String, String> countryOption) {
		this.countryOption = countryOption;
	}
	public String[] getOperatingSystem() {
		return operatingSystem;
	}
	public void setOperatingSystem(String[] operatingSystem) {
		this.operatingSystem = operatingSystem;
	}
	
}
