package com.ps.test;

import org.hibernate.HibernateException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ps.dto.ProjectDTO;
import com.ps.service.ProjectMgmtService;

public class ORMHibernateTest {

	public static void main(String[] args) {

		ApplicationContext ctx=null;
		ProjectMgmtService service=null;
		ProjectDTO proj=null;
		
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/ps/cfgs/applicationContext.xml");
		//get bean obj
		service=ctx.getBean("projService", ProjectMgmtService.class);
		//add project details
		proj=new ProjectDTO();
		proj.setProjId(2121);
		proj.setProjName("OpenFx1");
		proj.setCompany("HCL");
		proj.setTeamSize(14);
		proj.setLocation("Hyd");
		proj.setCost(1000000000.0);
		//invoke method for project registration
		try {
			System.out.println(service.registerProject(proj));
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			((AbstractApplicationContext) ctx).close();
		}
				
	}

}
