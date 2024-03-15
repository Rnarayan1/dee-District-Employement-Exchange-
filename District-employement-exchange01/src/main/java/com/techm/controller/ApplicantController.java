package com.techm.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.techm.dto.DocumentDto;
import com.techm.dto.EducationalDetailsDTO;
import com.techm.dto.LoginRequestDTO;
import com.techm.entity.Applicant;
import com.techm.entity.Document;
import com.techm.entity.Job;
import com.techm.entity.PersonalDetails;
import com.techm.service.AdminService;
import com.techm.service.ApplicantService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/applicants")
public class ApplicantController {

	@Autowired
	private ApplicantService applicantService;
	
	@Autowired
	private AdminService adminService;

	@GetMapping
	public String homePage() {

		return "home";
	}

	@GetMapping("/register")
	public String registerApplicant(Model model) {
		model.addAttribute("applicant", new Applicant());
		return "registerPage";
	}

	@PostMapping("/register")
	public String registerApplicant(@ModelAttribute Applicant applicant, HttpServletRequest request) {
		applicantService.registerApplicant(applicant);
		request.getSession().setAttribute("applicant", applicant);
		return "redirect:/applicants";
	}

	@GetMapping("/login")
	public String showLoginForm(Model model) {
		model.addAttribute("loginRequest", new LoginRequestDTO());
		return "login";
	}

	@PostMapping("/login")
	public String loginApplicant(@ModelAttribute("loginRequest") LoginRequestDTO loginRequest, Model model,
			HttpServletRequest request) {
		Applicant applicant = applicantService.loginApplicant(loginRequest.getUsername(), loginRequest.getPassword());

		if (applicant != null) {
			request.getSession().setAttribute("applicant", applicant);
			return "redirect:/applicants/dashboard";
		} else {
			model.addAttribute("error", "Invalid username or password");
			return "login";
		}
	}

	@GetMapping("/dashboard")
	public String showApplicantdasboard(Model model, HttpServletRequest request) {
		Applicant applicant = (Applicant) request.getSession().getAttribute("applicant");
		System.out.println("hello" + applicant);
		model.addAttribute("applicant",applicant);
		List<Job> jobList = adminService.getAllJobs(); 
		System.out.println(jobList);
        model.addAttribute("jobList", jobList);
        request.getSession().setAttribute("applicant", applicant);
		return "applicantDashboard";
	}

	@GetMapping("/personalDetails")
	public String personalDetails(Model model, HttpServletRequest request) {

		Applicant applicant = (Applicant) request.getSession().getAttribute("applicant");

		model.addAttribute(applicant);
		return "personaldetails";
	}

	@PostMapping("/addPersonalDetails")
	public String savePersonalDetails(@ModelAttribute PersonalDetails personalDetails, HttpServletRequest request) {
		Applicant applicant = (Applicant) request.getSession().getAttribute("applicant");
		applicantService.personalDetails(applicant.getId(), personalDetails);
		return "redirect:/applicants/dashboard"; // Redirect to the applicant dashboard or another page
	}

	@GetMapping("/educationalDetails")
	public String educationalDetails(Model model, HttpServletRequest request) {

		Applicant applicant = (Applicant) request.getSession().getAttribute("applicant");
		System.out.println("educationalDetails" + applicant);
		return "educationaldetails";
	}

	@PostMapping("/addEducationDetails")
	public String saveEducationalDetails(@ModelAttribute EducationalDetailsDTO educationalDetailsDTO,
			HttpServletRequest request) {
		Applicant applicant = (Applicant) request.getSession().getAttribute("applicant");
		applicantService.addEducationDetails(applicant.getId(), educationalDetailsDTO);
		return "redirect:/applicants/dashboard";
	}

	@GetMapping("/document")
	public String documentDetails(Model model, HttpServletRequest request) {

		Applicant applicant = (Applicant) request.getSession().getAttribute("applicant");
		System.out.println("document" + applicant);
		return "document";
	}

	@PostMapping("/addDocument")
	public String documentDetails(@ModelAttribute DocumentDto documentDto,
			@RequestParam("documentContent") MultipartFile documentContent, HttpServletRequest request) throws IOException {
		System.out.println("noooo"+documentDto);
		Document doc = new Document();
		doc.setDocumentName(documentDto.getDocumentName());
		doc.setDocumentContent(convertMultipartFileToBytes(documentDto.getDocumentContent()));

		Applicant applicant = (Applicant) request.getSession().getAttribute("applicant");
		applicantService.addDegreeDocument(applicant.getId(), doc);
		return "redirect:/applicants/dashboard";
	}
	
	static byte[] convertMultipartFileToBytes(MultipartFile multipartFile) throws IOException {
        if (multipartFile != null && !multipartFile.isEmpty()) {
            return multipartFile.getBytes();
        }

        return null;
    }
	
	@PostMapping("/apply-for-job/{jobId}")
	public String applyForJob(@PathVariable Long jobId,HttpServletRequest request) {
	    System.out.println("hello");
	    Applicant applicant = (Applicant) request.getSession().getAttribute("applicant");
	    applicantService.applyForJob(applicant.getId(), jobId);
	    return "redirect:/applicants/dashboard";
	}

}
