package com.hrms.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the identification database table.
 * 
 */
@Entity
@Table(name="identification")
@NamedQuery(name="Identification.findAll", query="SELECT i FROM Identification i")
public class Identification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="identification_id")
	private int identificationId;

	@Temporal(TemporalType.DATE)
	@Column(name="experation_date")
	private Date experationDate;

	@Column(name="identification_number")
	private String identificationNumber;

	@Temporal(TemporalType.DATE)
	@Column(name="issue_date")
	private Date issueDate;

	private String profession;

	@Column(name="serial_number")
	private String serialNumber;

	private String type;

	//bi-directional many-to-one association to City
	@ManyToOne
	@JoinColumn(name="`place_of _issue`")
	private City city;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employee_id")
	private Employee employee;

	public Identification() {
	}

	public int getIdentificationId() {
		return this.identificationId;
	}

	public void setIdentificationId(int identificationId) {
		this.identificationId = identificationId;
	}

	public Date getExperationDate() {
		return this.experationDate;
	}

	public void setExperationDate(Date experationDate) {
		this.experationDate = experationDate;
	}

	public String getIdentificationNumber() {
		return this.identificationNumber;
	}

	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

	public Date getIssueDate() {
		return this.issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public String getProfession() {
		return this.profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getSerialNumber() {
		return this.serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}