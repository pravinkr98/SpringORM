package com.ps.dto;

import java.io.Serializable;

public class ProjectDTO implements Serializable {

	private Integer projId;
	private String projName;
	private String company;
	private Integer teamSize;
	private String location;
	private Double cost;
	
	public Integer getProjId() {
		return projId;
	}
	public void setProjId(Integer projId) {
		this.projId = projId;
	}
	public String getProjName() {
		return projName;
	}
	public void setProjName(String projName) {
		this.projName = projName;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Integer getTeamSize() {
		return teamSize;
	}
	public void setTeamSize(Integer teamSize) {
		this.teamSize = teamSize;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	
	@Override
	public String toString() {
		return "Project [projId=" + projId + ", projName=" + projName + ", company=" + company + ", teamSize="
				+ teamSize + ", location=" + location + ", cost=" + cost + "]";
	}	
	
}
