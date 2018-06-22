package com.hrms.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the city database table.
 * 
 */
@Entity
@Table(name="city")
@NamedQuery(name="City.findAll", query="SELECT c FROM City c")
public class City implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="city_id")
	private int cityId;

	private String name;

	@Column(name="name_lang2")
	private String nameLang2;

	//bi-directional many-to-one association to Address
	@OneToMany(mappedBy="city")
	private List<Address> addresses;

	//bi-directional many-to-one association to Country
	@ManyToOne
	@JoinColumn(name="country_id")
	private Country country;

	//bi-directional many-to-one association to Identification
	@OneToMany(mappedBy="city")
	private List<Identification> identifications;

	//bi-directional many-to-one association to Location
	@OneToMany(mappedBy="city")
	private List<Location> locations;

	public City() {
	}

	public int getCityId() {
		return this.cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameLang2() {
		return this.nameLang2;
	}

	public void setNameLang2(String nameLang2) {
		this.nameLang2 = nameLang2;
	}

	public List<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Address addAddress(Address address) {
		getAddresses().add(address);
		address.setCity(this);

		return address;
	}

	public Address removeAddress(Address address) {
		getAddresses().remove(address);
		address.setCity(null);

		return address;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<Identification> getIdentifications() {
		return this.identifications;
	}

	public void setIdentifications(List<Identification> identifications) {
		this.identifications = identifications;
	}

	public Identification addIdentification(Identification identification) {
		getIdentifications().add(identification);
		identification.setCity(this);

		return identification;
	}

	public Identification removeIdentification(Identification identification) {
		getIdentifications().remove(identification);
		identification.setCity(null);

		return identification;
	}

	public List<Location> getLocations() {
		return this.locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	public Location addLocation(Location location) {
		getLocations().add(location);
		location.setCity(this);

		return location;
	}

	public Location removeLocation(Location location) {
		getLocations().remove(location);
		location.setCity(null);

		return location;
	}

}