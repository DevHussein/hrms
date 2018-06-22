package com.hrms.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the position_details database table.
 * 
 */
@Entity
@Table(name="position_details")
@NamedQuery(name="PositionDetail.findAll", query="SELECT p FROM PositionDetail p")
public class PositionDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="pd_id")
	private int pdId;

	private String departmen;

	private String description;

	@Column(name="max_salary")
	private BigDecimal maxSalary;

	@Column(name="min_salary")
	private BigDecimal minSalary;

	private String title;

	//bi-directional many-to-one association to Position
	@OneToMany(mappedBy="positionDetail")
	private List<Position> positions;

	public PositionDetail() {
	}

	public int getPdId() {
		return this.pdId;
	}

	public void setPdId(int pdId) {
		this.pdId = pdId;
	}

	public String getDepartmen() {
		return this.departmen;
	}

	public void setDepartmen(String departmen) {
		this.departmen = departmen;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getMaxSalary() {
		return this.maxSalary;
	}

	public void setMaxSalary(BigDecimal maxSalary) {
		this.maxSalary = maxSalary;
	}

	public BigDecimal getMinSalary() {
		return this.minSalary;
	}

	public void setMinSalary(BigDecimal minSalary) {
		this.minSalary = minSalary;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Position> getPositions() {
		return this.positions;
	}

	public void setPositions(List<Position> positions) {
		this.positions = positions;
	}

	public Position addPosition(Position position) {
		getPositions().add(position);
		position.setPositionDetail(this);

		return position;
	}

	public Position removePosition(Position position) {
		getPositions().remove(position);
		position.setPositionDetail(null);

		return position;
	}

}