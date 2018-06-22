package com.hrms.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the position database table.
 * 
 */
@Entity
@Table(name="position")
@NamedQuery(name="Position.findAll", query="SELECT p FROM Position p")
public class Position implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="position_id")
	private int positionId;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="position")
	private List<Employee> employees;

	//bi-directional many-to-one association to EmployeePosition
	@OneToMany(mappedBy="position")
	private List<EmployeePosition> employeePositions;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="manager_id")
	private Employee employee;

	//bi-directional many-to-one association to PositionDetail
	@ManyToOne
	@JoinColumn(name="pd_id")
	private PositionDetail positionDetail;

	public Position() {
	}

	public int getPositionId() {
		return this.positionId;
	}

	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee addEmployee(Employee employee) {
		getEmployees().add(employee);
		employee.setPosition(this);

		return employee;
	}

	public Employee removeEmployee(Employee employee) {
		getEmployees().remove(employee);
		employee.setPosition(null);

		return employee;
	}

	public List<EmployeePosition> getEmployeePositions() {
		return this.employeePositions;
	}

	public void setEmployeePositions(List<EmployeePosition> employeePositions) {
		this.employeePositions = employeePositions;
	}

	public EmployeePosition addEmployeePosition(EmployeePosition employeePosition) {
		getEmployeePositions().add(employeePosition);
		employeePosition.setPosition(this);

		return employeePosition;
	}

	public EmployeePosition removeEmployeePosition(EmployeePosition employeePosition) {
		getEmployeePositions().remove(employeePosition);
		employeePosition.setPosition(null);

		return employeePosition;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public PositionDetail getPositionDetail() {
		return this.positionDetail;
	}

	public void setPositionDetail(PositionDetail positionDetail) {
		this.positionDetail = positionDetail;
	}

}