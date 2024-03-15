package com.techm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techm.dto.JobDTO;
import com.techm.dto.LoginRequestDTO;
import com.techm.entity.Admin;
import com.techm.entity.Job;
import com.techm.entity.JobApplication;
import com.techm.service.AdminService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@GetMapping("/adminLogin")
	public String adminLogin(Model model) {
		model.addAttribute("loginRequest", new LoginRequestDTO());
		return "adminlogin";
	}

	@PostMapping("/adminLogin")
	public String adminLogin(@ModelAttribute("loginRequest") LoginRequestDTO loginRequest, Model model,
			HttpServletRequest request) {
		Admin admin = adminService.adminLongin(loginRequest.getUsername(), loginRequest.getPassword());

		if (admin != null) {
			request.getSession().setAttribute("admin", admin);
			return "redirect:/admin/dashboard";
		} else {
			model.addAttribute("error", "Invalid username or password");
			return "login";
		}
	}

	@GetMapping("/dashboard")
	public String adminDashboard(Model model) {
		// model.addAttribute("loginRequest", new LoginRequestDTO());
		List<Job> jobList = adminService.getAllJobs(); // Assuming you have a method to get all jobs
        model.addAttribute("jobList", jobList);
		return "admindashboard";
	}

	@GetMapping("/add-job")
	public String addJob(Model model) {
		model.addAttribute("job", new JobDTO());
		return "addjob";
	}

	@PostMapping("/add")
	public String addJob(@ModelAttribute("job") JobDTO jobDTO) {
		System.out.println("hello"+jobDTO);
		adminService.addJob(jobDTO);
		
		return "redirect:/admin/dashboard";
	}
	
	@PostMapping("/remove-job/{jobId}")
	public String removeJob(@PathVariable Long jobId) {
		System.out.println("hello remove"+jobId);
		adminService.removeJob(jobId);
		return "redirect:/admin/dashboard";
	}

	@GetMapping("/applicants-for-job/{jobId}")
	public ResponseEntity<List<JobApplication>> getApplicantsForJob(@PathVariable Long jobId) {
		List<JobApplication> applicants = adminService.getApplicantsForJob(jobId);
		return ResponseEntity.ok(applicants);
	}

	

	@GetMapping("/number-of-applicants/{jobId}")
	public ResponseEntity<Integer> getNumberOfApplicants(@PathVariable Long jobId) {
		int numberOfApplicants = adminService.getNumberOfApplicants(jobId);
		return ResponseEntity.ok(numberOfApplicants);
	}
}
