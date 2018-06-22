package com.hrms.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the employee_position database table.
 * 
 */
@Entity
@Table(name="employee_position")
@NamedQuery(name="EmployeePosition.findAll", query="SELECT e FROM EmployeePosition e")
public class EmployeePosition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ep_id")
	private int epId;

	@Column(name="commission_pct")
	private BigDecimal commissionPct;

	@Temporal(TemporalType.DATE)
	@Column(name="end_date")
	private Date endDate;

	private BigDecimal salary;

	@Temporal(TemporalType.DATE)
	@Column(name="start_date")
	private Date startDate;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employee_id")
	private Employee employee;

	//bi-directional many-to-one association to Position
	@ManyToOne
	@JoinColumn(name="position_id")
	private Position position;

	public EmployeePosition() {
	}

	public int getEpId() {
		return this.epId;
	}

	public void setEpId(int epId) {
		this.epId = epId;
	}

	public BigDecimal getCommissionPct() {
		return this.commissionPct;
	}

	public void setCommissionPct(BigDecimal commissionPct) {
		this.commissionPct = commissionPct;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public BigDecimal getSalary() {
		return this.salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Position getPosition() {
		return this.position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

}