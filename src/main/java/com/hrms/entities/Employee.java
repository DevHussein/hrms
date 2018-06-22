package com.hrms.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the employee database table.
 * 
 */
@Entity
@Table(name="employee")
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="employee_id")
	private int employeeId;

	@Column(name="arabic_first_name_lang2")
	private String arabicFirstNameLang2;

	@Column(name="arabic_last_name_lang2")
	private String arabicLastNameLang2;

	@Column(name="arabic_mid_name_lang2")
	private String arabicMidNameLang2;

	@Temporal(TemporalType.DATE)
	private Date dob;

	@Column(name="first_name")
	private String firstName;

	private String gender;

	@Temporal(TemporalType.DATE)
	@Column(name="hire_date")
	private Date hireDate;

	@Column(name="last_name")
	private String lastName;

	@Column(name="martial_status")
	private String martialStatus;

	@Column(name="mid_name")
	private String midName;

	@Column(name="preferd_name")
	private String preferdName;

	@Column(name="preferd_name_lang2")
	private String preferdNameLang2;

	private String religon;

	//bi-directional many-to-one association to Address
	@OneToMany(mappedBy="employee")
	private List<Address> addresses;

	//bi-directional many-to-one association to Contact
	@OneToMany(mappedBy="employee")
	private List<Contact> contacts;

	//bi-directional many-to-one association to Position
	@ManyToOne
	@JoinColumn(name="postion_id")
	private Position position;

	//bi-directional many-to-one association to EmployeePosition
	@OneToMany(mappedBy="employee")
	private List<EmployeePosition> employeePositions;

	//bi-directional many-to-one association to Identification
	@OneToMany(mappedBy="employee")
	private List<Identification> identifications;

	//bi-directional many-to-one association to PassportDetail
	@OneToMany(mappedBy="employee")
	private List<PassportDetail> passportDetails;

	//bi-directional many-to-one association to Position
	@OneToMany(mappedBy="employee")
	private List<Position> positions;

	public Employee() {
	}

	public int getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getArabicFirstNameLang2() {
		return this.arabicFirstNameLang2;
	}

	public void setArabicFirstNameLang2(String arabicFirstNameLang2) {
		this.arabicFirstNameLang2 = arabicFirstNameLang2;
	}

	public String getArabicLastNameLang2() {
		return this.arabicLastNameLang2;
	}

	public void setArabicLastNameLang2(String arabicLastNameLang2) {
		this.arabicLastNameLang2 = arabicLastNameLang2;
	}

	public String getArabicMidNameLang2() {
		return this.arabicMidNameLang2;
	}

	public void setArabicMidNameLang2(String arabicMidNameLang2) {
		this.arabicMidNameLang2 = arabicMidNameLang2;
	}

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getHireDate() {
		return this.hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMartialStatus() {
		return this.martialStatus;
	}

	public void setMartialStatus(String martialStatus) {
		this.martialStatus = martialStatus;
	}

	public String getMidName() {
		return this.midName;
	}

	public void setMidName(String midName) {
		this.midName = midName;
	}

	public String getPreferdName() {
		return this.preferdName;
	}

	public void setPreferdName(String preferdName) {
		this.preferdName = preferdName;
	}

	public String getPreferdNameLang2() {
		return this.preferdNameLang2;
	}

	public void setPreferdNameLang2(String preferdNameLang2) {
		this.preferdNameLang2 = preferdNameLang2;
	}

	public String getReligon() {
		return this.religon;
	}

	public void setReligon(String religon) {
		this.religon = religon;
	}

	public List<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Address addAddress(Address address) {
		getAddresses().add(address);
		address.setEmployee(this);

		return address;
	}

	public Address removeAddress(Address address) {
		getAddresses().remove(address);
		address.setEmployee(null);

		return address;
	}

	public List<Contact> getContacts() {
		return this.contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public Contact addContact(Contact contact) {
		getContacts().add(contact);
		contact.setEmployee(this);

		return contact;
	}

	public Contact removeContact(Contact contact) {
		getContacts().remove(contact);
		contact.setEmployee(null);

		return contact;
	}

	public Position getPosition() {
		return this.position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public List<EmployeePosition> getEmployeePositions() {
		return this.employeePositions;
	}

	public void setEmployeePositions(List<EmployeePosition> employeePositions) {
		this.employeePositions = employeePositions;
	}

	public EmployeePosition addEmployeePosition(EmployeePosition employeePosition) {
		getEmployeePositions().add(employeePosition);
		employeePosition.setEmployee(this);

		return employeePosition;
	}

	public EmployeePosition removeEmployeePosition(EmployeePosition employeePosition) {
		getEmployeePositions().remove(employeePosition);
		employeePosition.setEmployee(null);

		return employeePosition;
	}

	public List<Identification> getIdentifications() {
		return this.identifications;
	}

	public void setIdentifications(List<Identification> identifications) {
		this.identifications = identifications;
	}

	public Identification addIdentification(Identification identification) {
		getIdentifications().add(identification);
		identification.setEmployee(this);

		return identification;
	}

	public Identification removeIdentification(Identification identification) {
		getIdentifications().remove(identification);
		identification.setEmployee(null);

		return identification;
	}

	public List<PassportDetail> getPassportDetails() {
		return this.passportDetails;
	}

	public void setPassportDetails(List<PassportDetail> passportDetails) {
		this.passportDetails = passportDetails;
	}

	public PassportDetail addPassportDetail(PassportDetail passportDetail) {
		getPassportDetails().add(passportDetail);
		passportDetail.setEmployee(this);

		return passportDetail;
	}

	public PassportDetail removePassportDetail(PassportDetail passportDetail) {
		getPassportDetails().remove(passportDetail);
		passportDetail.setEmployee(null);

		return passportDetail;
	}

	public List<Position> getPositions() {
		return this.positions;
	}

	public void setPositions(List<Position> positions) {
		this.positions = positions;
	}

	public Position addPosition(Position position) {
		getPositions().add(position);
		position.setEmployee(this);

		return position;
	}

	public Position removePosition(Position position) {
		getPositions().remove(position);
		position.setEmployee(null);

		return position;
	}

}