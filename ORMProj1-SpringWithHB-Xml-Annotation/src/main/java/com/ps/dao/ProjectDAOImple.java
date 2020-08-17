package com.ps.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ps.entity.Project;

@Repository("projDAO")
public class ProjectDAOImple implements ProjectDAO {
	
	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer insertProject(Project entity) {		
		return  (Integer) ht.save(entity);
	}

}
