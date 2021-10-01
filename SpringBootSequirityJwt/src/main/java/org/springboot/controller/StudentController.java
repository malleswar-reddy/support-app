package org.springboot.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springboot.entity.JwtRequest;
import org.springboot.entity.Student;
import org.springboot.response.JwtResponse;
import org.springboot.service.StudentService;
import org.springboot.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Column;

@RestController
@CrossOrigin
public class StudentController {

	@Autowired
	private JwtTokenUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private StudentService userDetailsService;

	@GetMapping("/getAll")
	public Iterable<Student> getallStudent() {
		return userDetailsService.getAllStudents();

	}

	@GetMapping("/add")
	public  Student saveStudent(/*@RequestBody Student student*/) {
		Student student1 = new Student("101","Ram","password","firstname","lastname",
				"malli@gmali.com",new ArrayList<>());

	/*	@Column(name = "student_firstname")
		private String firstname;
		@Column(name = "studentlastname")
		private String lastname;
		@Column(name = "student_email")
		private String email;
		*/

		return userDetailsService.save(student1);
	}

	@GetMapping("/{studentId}")
	public Optional<Student> userById(@PathVariable("studentId") String studentId) {
		return userDetailsService.findById(studentId);
	}

}
