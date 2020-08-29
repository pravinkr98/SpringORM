package com.ps.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.ps.config.AppConfig;
import com.ps.dto.ProjectDTO;
import com.ps.service.ProjectMgmtService;

public class ORMHibernateTest {

	public static void main(String[] args) {

		ApplicationContext ctx=null;
		ProjectMgmtService service=null;
		ProjectDTO proj=null;
		
		//create IOC container
		ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		//get bean obj
		service=ctx.getBean("projService", ProjectMgmtService.class);
		//add project details
		proj=new ProjectDTO();
		proj.setProjId(2121);
		proj.setProjName("OpenFx3");
		proj.setCompany("HCL");
		proj.setTeamSize(14);
		proj.setLocation("Hyd");
		proj.setCost(160000.0);
		//invoke method for project registration
		try {
			System.out.println(service.registerProject(proj));
			//System.out.println("----------------------------------------------------------------------");
			//System.out.println(service.fetchProjectById(3));
			//System.out.println("------------------------------------------------------------------------");
			//System.out.println(service.modifyProjectById(1, 10, 200000));
			//System.out.println("---------------------------------------------------------------------------");
			//System.out.println(service.removeProjectById(3));
			List<ProjectDTO> listDTO=service.fetchProjectByCostRange(100000.0, 200000.0);
			System.out.println("---------------------------------------------------------------------------");
			listDTO.forEach(System.out::println);
			System.out.println("---------------------------------------------------------------------------");
			listDTO.forEach(data->{
				System.out.println(data);
			});
			System.out.println("---------------------------------------------------------------------------");
			System.out.println(listDTO);
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			((AbstractApplicationContext) ctx).close();
		}
				
	}

}
