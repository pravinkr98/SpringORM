package com.ps.service;

import java.util.List;

import com.ps.dto.ProjectDTO;
import com.ps.entity.Project;

public interface ProjectMgmtService {

	public String registerProject(ProjectDTO dto);
	public Object fetchProjectById(int id);
	public String modifyProjectById(int id,Integer teamSize,double cost);
	public String removeProjectById(int id);
	public List<ProjectDTO> fetchProjectByCostRange(double start,double end);
}
