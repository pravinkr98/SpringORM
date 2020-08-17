package com.ps.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ps.dao.ProjectDAO;
import com.ps.dto.ProjectDTO;
import com.ps.entity.Project;

@Service("projService")
@Transactional
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

}
