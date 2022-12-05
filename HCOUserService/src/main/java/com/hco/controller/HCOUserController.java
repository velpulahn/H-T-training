package com.hco.controller;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hco.entity.HCOUser;
import com.hco.entity.Users;
import com.hco.exception.HCOUserException;
import com.hco.exception.UserException;
import com.hco.service.HCOUserService;
import com.hco.service.UsersService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/v1/healthcare")
public class HCOUserController {

	@Autowired
	private HCOUserService service;
	
	@Autowired
	private UsersService userService;
	
	
	@GetMapping()
	public String welcome() {
		return "Welcome to Health Care Organization";
	}
	
	@PostMapping("/hcouser/{userId}/register")
	public HCOUser saveUserDetails(@PathVariable int userId, @RequestBody HCOUser hcoUser) throws UserException{
		Random r = new Random();
        int i = Math.abs(r.nextInt());
		hcoUser.setHcoId(i*104628648);
	    return service.saveUserDetails(userId, hcoUser);
	 }
	 
	@PutMapping("/hcouser/{userId}/updateDetails/{hcoId}")
	public HCOUser updateHCOUserDetails(@PathVariable int hcoId, @PathVariable int userId, @RequestBody HCOUser hcoUser) throws HCOUserException,UserException {
  	   return service.updateHCOUserDetails(hcoId, userId, hcoUser);
  }
	 @GetMapping("/hcouser/user/{userId}")
		public List<HCOUser> getHcoUserDetailsByUserId(@PathVariable int userId) throws UserException{
		 return service.getHcoUserDetailsByUserId(userId);
	 }
	 
	 
	 @GetMapping("/hcouser/{hcoId}")
	 public HCOUser getHcoUserById(@PathVariable int hcoId) throws HCOUserException {
		 return service.getHcoUserById(hcoId);
		 }
	 
	 @GetMapping("/accountexecutive/{userId}/allhcouserdetails")
		public List<HCOUser> getAllHcoUserDetails(@PathVariable int userId) throws UserException{
		 return service.getAllHcoUserDetails(userId);
	 }
	 
//	 @DeleteMapping("/hcouser/deleteById/{hcoId}")
//	    public HCOUser delete(@PathVariable int hcoId) throws HCOUserException{
//	      return service.delete(hcoId);
//	 }
	 
	 @GetMapping("/{userName}")
	 public Users getUserIdByUserName(@PathVariable String userName) {
	 return userService.getUserIdByUserName(userName);
	 }
	 
	 @GetMapping("/hcouser/updateStatus/{status}/{hcoId}")
		public void updateStatus(@PathVariable String status,@PathVariable int hcoId) {
			System.out.println(status+" "+hcoId);
			service.updateStatus(status, hcoId);
		}
}
