package com.ps.dao;

import java.util.List;

import com.ps.entity.Project;

public interface ProjectDAO {

	public Integer insertProject(Project entity);
	public Project getProjectById(int id);
	public boolean updateProjectById(int id,Integer teamSize,double cost);
	public boolean deleteProjectById(int id);
	public List<Project> getProjectByCostRange(double start,double end);
}
