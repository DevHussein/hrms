package com.hrms.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the passport_details database table.
 * 
 */
@Entity
@Table(name="passport_details")
@NamedQuery(name="PassportDetail.findAll", query="SELECT p FROM PassportDetail p")
public class PassportDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="pd_id")
	private int pdId;

	@Column(name="arabic_full_name")
	private String arabicFullName;

	@Temporal(TemporalType.DATE)
	@Column(name="date_of_expiration")
	private Date dateOfExpiration;

	@Temporal(TemporalType.DATE)
	@Column(name="date_of_issue")
	private Date dateOfIssue;

	@Column(name="full_name")
	private String fullName;

	private String nationality;

	@Column(name="passport_number")
	private String passportNumber;

	@Column(name="place_of_issue")
	private int placeOfIssue;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employee_id")
	private Employee employee;

	public PassportDetail() {
	}

	public int getPdId() {
		return this.pdId;
	}

	public void setPdId(int pdId) {
		this.pdId = pdId;
	}

	public String getArabicFullName() {
		return this.arabicFullName;
	}

	public void setArabicFullName(String arabicFullName) {
		this.arabicFullName = arabicFullName;
	}

	public Date getDateOfExpiration() {
		return this.dateOfExpiration;
	}

	public void setDateOfExpiration(Date dateOfExpiration) {
		this.dateOfExpiration = dateOfExpiration;
	}

	public Date getDateOfIssue() {
		return this.dateOfIssue;
	}

	public void setDateOfIssue(Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getNationality() {
		return this.nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getPassportNumber() {
		return this.passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public int getPlaceOfIssue() {
		return this.placeOfIssue;
	}

	public void setPlaceOfIssue(int placeOfIssue) {
		this.placeOfIssue = placeOfIssue;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}