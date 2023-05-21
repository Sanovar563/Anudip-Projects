package com.hibernateone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateOneToOneDemo {

	public static void main(String[] args) {
		System.out.println( "Project has Started");
        //creating the configuration
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        //building the session factory on the configuration
        SessionFactory factory=cfg.buildSessionFactory();
        
        
        //creating department object
        Department d1=new Department();
        d1.setDid(201);
        d1.setDname("HR");
        
        Department d2=new Department();
        d2.setDid(202);
        d2.setDname("Sales");
        
        Department d3=new Department();
        d3.setDid(203);
        d3.setDname("manufacturing");
        
        //creating employee object
        Employee e1=new Employee();
        e1.setEid(101);
        e1.setEname("Sana");
        e1.setDept(d1);
        
        Employee e2=new Employee();
        e2.setEid(102);
        e2.setEname("Hoor");
        e2.setDept(d2);
        
        Employee e3=new Employee();
        e3.setEid(103);
        e3.setEname("ali");
        e3.setDept(d3);
        
        
        Project p1=new Project();
        p1.setPid(301);
        p1.setPname("java project");
        p1.setPdescription("Computer project");
        p1.setEmp(e1);
        
        
        
        Project p2=new Project();
        p2.setPid(302);
        p2.setPname("python project");
        p2.setPdescription("B.Tech branch");
        p2.setEmp(e2);
        
        Project p3=new Project();
        p3.setPid(303);
        p3.setPname(".Net project");
        p3.setPdescription("M.Tech");
        p3.setEmp(e3);
        
        //bidirectional mapping and calling it in main class
        d1.setEmp(e1);
        d2.setEmp(e2);
        d3.setEmp(e3);
        
        Session session=factory.openSession();
        Transaction tx=session.beginTransaction();
        		session.save(d1);
        		session.save(d2);
        		session.save(d3);
        		
        		session.save(e1);
        		session.save(e2);
        		session.save(e3);
        		
        		session.save(p1);
        		session.save(p2);
        		session.save(p3);
        		tx.commit();
        		session.close();
        		factory.close();
	}

}
