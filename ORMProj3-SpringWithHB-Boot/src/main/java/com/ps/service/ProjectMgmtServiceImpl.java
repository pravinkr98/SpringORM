package com.ps.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ps.dao.ProjectDAO;
import com.ps.dto.ProjectDTO;
import com.ps.entity.Project;

@Service("projService")
@Transactional(transactionManager = "hbTxMgmr")
public class ProjectMgmtServiceImpl implements ProjectMgmtService {
	
	@Autowired
	private ProjectDAO dao;

	@Override
	public String registerProject(ProjectDTO dto) {		
		Project entity=null;
		Integer idVal=0;
		
		entity=new Project();
		//copy dto obj to entity obj
		BeanUtils.copyProperties(dto, entity);
		//use dao
		idVal=dao.insertProject(entity);		
		return "Project is registered with the id value :: "+idVal;
	}

	@Override
	public Object fetchProjectById(int id) {
		Project proj=null;
		ProjectDTO dto=null;
		//use DAO
		proj=dao.getProjectById(id);
		if(proj!=null) {
			dto=new ProjectDTO();
			BeanUtils.copyProperties(proj, dto);
		}
		return proj!=null?dto:"Record not found";
	}

	@Override
	public String modifyProjectById(int id, Integer teamSize, double cost) {
		boolean updated=false;
		//use DAO
		updated=dao.updateProjectById(id, teamSize, cost);
		return updated==false?"record not updated":"record updated";
	}

	@Override
	public String removeProjectById(int id) {
		boolean deleted=false;
		deleted=dao.deleteProjectById(id);
		return deleted!=false?"Record found and deleted":"Record not found for deletion";
	}

	@Override
	public List<ProjectDTO> fetchProjectByCostRange(double start, double end) {
		List<Project> listEntities=null;
		List<ProjectDTO> listDTO=new ArrayList<>();
		//use DAO
		listEntities=dao.getProjectByCostRange(start, end);
		//copy entity to dto
		listEntities.forEach(entity->{
			ProjectDTO dto=new ProjectDTO();
			BeanUtils.copyProperties(entity, dto);
			listDTO.add(dto);
		});
		return listDTO;
	}

}
