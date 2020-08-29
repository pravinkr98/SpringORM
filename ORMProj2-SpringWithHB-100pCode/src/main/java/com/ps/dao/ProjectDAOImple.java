package com.ps.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ps.entity.Project;

@Repository("projDAO")
public class ProjectDAOImple implements ProjectDAO {
	private static final String HQL_GET_PROJECTS_BY_COST_RANGE="FROM com.ps.entity.Project WHERE COST>=:min AND COST<=:max";
	
	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer insertProject(Project entity) {		
		return  (Integer) ht.save(entity);
	}

	@Override
	public Project getProjectById(int id) {
		return ht.get(Project.class, id);
	}

	@Override
	public boolean updateProjectById(int id, Integer teamSize, double cost) {
		Project proj=null;
		boolean updated=false;
		
		proj=ht.get(Project.class, id);
		if(proj!=null) {
			proj.setTeamSize(teamSize);
			proj.setCost(cost);
			ht.update(proj);
			updated=true;
		}
		return updated;
	}

	@Override
	public boolean deleteProjectById(int id) {
		boolean deleted=false;
		Project proj=null;
		//Load obj
		proj=ht.get(Project.class, id);
		if(proj!=null) {
			ht.delete(proj);
			deleted=true;
		}
		return deleted;
	}

	@Override
	public List<Project> getProjectByCostRange(double start, double end) {
		List<Project> list=null;
		list=(List<Project>) ht.findByNamedParam(HQL_GET_PROJECTS_BY_COST_RANGE,
																	new String[] {"min","max"},
																	new Object[] {start,end});		
		return list;
	}

}
