package com.jobApplicaton.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jobApplicaton.model.Job;
import com.jobApplicaton.model.JobApplication;
import com.jobApplicaton.model.User;
import com.jobApplicaton.response.ResponseMessage;
import com.jobApplicaton.service.ApplicationService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value="api/job/")
public class JobController extends com.jobApplicaton.response.Exception {

	@Autowired
	private ApplicationService applicationService;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@GetMapping(value="jobListed")
	public List<Job>jobList(){
		return applicationService.jobList();
	}
	
	@GetMapping(value="jobDetails/{jobId}")
	public Job findJobByDetails(@PathVariable("jobId")int jobId) {
		System.out.println("result id "+jobId);
		return applicationService.jobDetails(jobId);
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping(value ="applyWithoutLogin")
	public ResponseEntity applyWithoutLogin(@RequestParam("cv") MultipartFile cv, @RequestParam("us") String us, @RequestParam("jobId") int jobId) {
		try {
			User user = new ObjectMapper().readValue(us, User.class);
			boolean isExist = new File("src\\main\\resources\\static\\files\\").exists();

			if (!isExist) {
				new File("src\\main\\resources\\static\\files\\").mkdir();
			}
			String filename = cv.getOriginalFilename();
			String modifiedFileName = System.currentTimeMillis()+ "_" +filename;
			
			byte[] bytes = cv.getBytes();
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(
					new File("src\\main\\resources\\static\\files\\" + modifiedFileName)));
			stream.write(bytes);
			
			stream.close();
			
			
			String result = applicationService.applyForJob(user, jobId,modifiedFileName );
			
			if(result.equals("success")) {
				return ResponseEntity.ok(new ResponseMessage("Your Application is Well Successfull Sent!!"));
			}else {
				return ResponseEntity.badRequest().body(new ResponseMessage(result));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(new ResponseMessage(e.getMessage()));
		}
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping(value="createNewAccount")
	public ResponseEntity createNewAccount(@Valid @RequestBody User user) {
		try {
			user.setPassword(encoder.encode(user.getPassword()));
			applicationService.createAccount(user);
			return ResponseEntity.ok(new ResponseMessage("your account is well successfull created"));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(new ResponseMessage(e.getMessage()));
		}
	}
	
	@GetMapping(value="applicants")
	public List<JobApplication>jobApplicationsList(){
		return applicationService.jobApplicationList();
	}
	@GetMapping(value="applicantDetails/{id}")
	public JobApplication findApplicantDetails(@PathVariable("id")int id) {
		return applicationService.applicantDetails(id);
	}
	
	@SuppressWarnings("rawtypes")
	@PutMapping(value="dropApplication/{applicationId}")
	public ResponseEntity droppApplication(@RequestBody HashMap<String, Object>map, @PathVariable("applicationId")int applicationId) {
		try {
			String comment = (String)map.get("comment");
			applicationService.droppedMethod(applicationId, comment);
			return ResponseEntity.ok(new ResponseMessage("Well successfull dropped"));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(new ResponseMessage(e.getMessage()));
		}
	}
	@SuppressWarnings("rawtypes")
	@PutMapping(value="passApplication/{applicationId}")
	public ResponseEntity passApplication(@PathVariable("applicationId")int applicationId) {
		try {
			applicationService.passedMethod(applicationId);
			return ResponseEntity.ok(new ResponseMessage("Well successfull passed"));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(new ResponseMessage(e.getMessage()));
		}
	}

	 @GetMapping("download/{fileName}")
	 public Object getPdf(@PathVariable("fileName") String fileName)throws IOException {
		 File file =new File("src\\main\\resources\\static\\files\\"+fileName);
		 FileInputStream fileInputStream = new FileInputStream(file);
         return IOUtils.toByteArray(fileInputStream);
	 }
	
	
	
}
