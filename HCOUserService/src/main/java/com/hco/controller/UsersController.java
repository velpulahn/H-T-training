package com.hco.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hco.entity.Response;
import com.hco.entity.Users;
import com.hco.exception.UserException;
import com.hco.models.JwtRequest;
import com.hco.models.JwtResponse;
import com.hco.repo.UsersRepository;
import com.hco.service.UsersService;
import com.hco.utils.JwtTokenUtil;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/v1/healthcare/users")
public class UsersController {

	@Autowired
	private UsersService service;
	
	@Autowired
	private UsersRepository repo;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping()
	public Users saveUser(@RequestBody Users user) {
		Random r = new Random();
        int i = Math.abs(r.nextInt());
		user.setUserId(i*104628648);
		return service.saveUser(user);
	}

	@GetMapping("/userrole/{userName}")
	public Response getRoleByUserName(@PathVariable String userName){
		return service.getRoleByUserName(userName);
	}
	
	
	@GetMapping("/user/{userId}")
	public Users getUserById(@PathVariable int userId) throws UserException {
		return service.getUserById(userId);
	}

	@GetMapping("/findAll")
	public List<Users> findAll() {
		return service.getAllUsers();
	}
	
	@PostMapping("/signIn/token")
	public ResponseEntity<?> authenticate(@RequestBody JwtRequest req) throws UserException {
		System.out.println("authenticated in");
		authenticate(req.getUsername(), req.getPassword());//call if login is success
		UserDetails userDetails = service.loadUserByUsername(req.getUsername());
		System.out.println(userDetails.isEnabled());
		System.out.println("authenticated successfully");
		System.out.println("user details :------" + userDetails);
		final String token = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));
	}

	private void authenticate(String username, String password) throws UserException {
		System.out.println("userName" + username +"password :" + password);
		try {
			System.out.println("authenticated in");
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			System.out.println("userName" + username +"password :" + password);
		} catch (DisabledException e) {
			throw new UserException("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new UserException("INVALID_CREDENTIALS", e);
		}
	}

}
