package com.jobApplicaton.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jobApplicaton.model.Job;
import com.jobApplicaton.model.Job.JobStatus;

@Repository
public class JobDataBaseMocker {

	
	public List<Job>jobList() {
		List<Job>list = new ArrayList<>();
		String  description ="";
		try {	
			description ="<html><body>"
					+ "<h3 style=font-weight: bold; color: maroon;>Description</h3> <br />"
					+ "<p>Looking for a Back End Developer with at least 4 years of experience with Java technology or Node JS for a client in UK.</p>"
					+ "<p>Developer responsible for quality coding, testing support and production release support.\r\n" + 
					"\r\n" + 
					"Reporting to a lead developer in the pool with additional reporting lines to the project manager/IT Lead.</p>"
					 
					+ "We are looking for a backend developer, our preferred technology is JAVA, but we will take in consideration Node JS as well. <br/><br />"
					+ "<h3 style=font-weight: bold; color: maroon;>Requirements</h3>"
					+ "<p>.Experience with back-end technologies: Microservice architecture, Java 8+, Spring Boot and Hibernate</p>"
					+ "<p>.Experience in developing messaging and streaming service, including Kafka, Websphere MQ, ActiveMQ, Solace MQ</p>"
					+ "<p>.Worked on designing and delivering following aspects in Java based micro-service based systems</p>"
					+ "<p>.Transaction Management</p>"
					
					+ "</body></html>";
		Job job =new Job(1, "Software Developer", new Date(), new SimpleDateFormat("yyyy-MM-dd").parse("2021-10-01"), "3+ Experiences", JobStatus.Open);
		job.setDescription(description);
		list.add(job);
		
		description = "<h3 style=font-weight: bold; color: maroon;>Descriptions</h3> <br />"
				+ "<p>Currently we are looking for a Senior / Lead Java Developer for our Krakow office.</p> <br/>"
				+ "<h3 style=font-weight: bold; color: maroon;>Responsibilities</h3> <br/>"
				+ ".Develop scalable production-ready solution\r\n" + 
				".Communicate effectively with other departments (product managers, engineers) to discuss complex data-driven findings and technical specifications\r\n" + 
				".Lead only: Development of proposals for implementation and design of scalable architecture\r\n" + 
				".Lead only: Participation in customer’s workshops and presentation of the proposed solution <br/><br />"
				+ "<h3 style=font-weight: bold; color: maroon;>Requirements</h3>";
		Job job1 =new Job(2, "Full Stack Engineer", new SimpleDateFormat("yyyy-MM-dd").parse("2021-07-01"), new SimpleDateFormat("yyyy-MM-dd").parse("2021-10-01"), "5+ Experiences", JobStatus.Open);
		job1.setDescription(description);
		list.add(job1);
		description = "<h3 style=font-weight: bold; color: maroon;>Description</h3> <br /> "
				+ "<p>We are looking for a hands-on DBA, technologist and architect who has experience in PostgreSQL implementation to"
				+ " focus on building the PostgreSQL Databases and administer them. This may also include migration of DBs and post-migration support"
				+ " from other RDBMS like Oracle etc. You'll be working in the Regional Level 3/SME team with Project Managers, SMEs, "
				+ "Database Engineering and Operations support dedicated to this function.</p> <br/><br />"
				+ "<h3 style=font-weight: bold; color: maroon;>Responsibilities</h3> <br/>"
				+ "<p>Day to day administration PostgreSQL Databases\r\n" + 
				"\r\n" + 
				"• Experience in PostgreSQL Installation 11,12 Production support</p>" + 
				"<p>Experienced in Backup & Recovery using native Backup utilities and logical / physical backups</p> "+ 
				"<p>Implemented and Configured Postgresql Replication for more than one hot Standby and also handled concepts "
				+ "like transferring WAL to standby machines to make sure zero percent data loss.</p><br />"
				;
		Job job2 =new Job(4, "Database Administrator", new SimpleDateFormat("yyyy-MM-dd").parse("2021-08-01"), new SimpleDateFormat("yyyy-MM-dd").parse("2021-09-01"), "2+ Experiences", JobStatus.Open);
		job2.setDescription(description);
		list.add(job2);
		description = "<h3 style=font-weight: bold; color: maroon;>Description</h3> <br /><br /> "
				+ "<p>Currently we are looking for a Senior / Lead Java Developer for our Krakow office.</p> <br/><br />"
				+ "<h3 style=font-weight: bold; color: maroon;>Responsibilities</h3> <br/><br />"
				+ ".Develop scalable production-ready solution\r\n" + 
				".Communicate effectively with other departments (product managers, engineers) to discuss complex data-driven findings and technical specifications\r\n" + 
				".Lead only: Development of proposals for implementation and design of scalable architecture\r\n" + 
				".Lead only: Participation in customer’s workshops and presentation of the proposed solution <br/><br />"
				+ "<h3 style=font-weight: bold; color: maroon;>Requirements</h3>";
		Job job3 =new Job(3, "Business Analyst", new SimpleDateFormat("yyyy-MM-dd").parse("2021-10-01"), new SimpleDateFormat("yyyy-MM-dd").parse("2021-10-01"), "3+ Experiences", JobStatus.Open);
		job3.setDescription(description);
		list.add(job3);
		
		description ="<html><body>"
				+ "<h3 style=font-weight: bold; color: maroon;>Description</h3> <br />"
				+ "<p>Looking for a Back End Developer with at least 4 years of experience with Java technology or Node JS for a client in UK.</p>"
				+ "<p>Developer responsible for quality coding, testing support and production release support.\r\n" + 
				"\r\n" + 
				"Reporting to a lead developer in the pool with additional reporting lines to the project manager/IT Lead.</p>"
				 
				+ "We are looking for a backend developer, our preferred technology is JAVA, but we will take in consideration Node JS as well. <br/><br />"
				+ "<h3 style=font-weight: bold; color: maroon;>Requirements</h3>"
				+ "<p>.Experience with back-end technologies: Microservice architecture, Java 8+, Spring Boot and Hibernate</p>"
				+ "<p>.Experience in developing messaging and streaming service, including Kafka, Websphere MQ, ActiveMQ, Solace MQ</p>"
				+ "<p>.Worked on designing and delivering following aspects in Java based micro-service based systems</p>"
				+ "<p>.Transaction Management</p>"
				
				+ "</body></html>";
		Job job4 =new Job(5, "Junior Java Backend Developer", new SimpleDateFormat("yyyy-MM-dd").parse("2021-09-10"), new SimpleDateFormat("yyyy-MM-dd").parse("2021-10-01"), "1+ Experiences", JobStatus.Open);
		job4.setDescription(description);
		list.add(job4);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
