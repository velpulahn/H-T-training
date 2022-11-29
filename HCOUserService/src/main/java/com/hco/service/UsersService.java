package com.hco.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hco.entity.Response;
import com.hco.entity.Users;
import com.hco.exception.UserException;
import com.hco.repo.UsersRepository;

@Service
public class UsersService implements UserDetailsService {
	
	 @Autowired 
	 private UsersRepository repo;

	 public Users saveUser(Users user) {
		return repo.save(user);
		}

	public Users getUserById(int userId) throws UserException {
		Optional<Users> optional = repo.findById(userId);
        if(optional.isEmpty()){
            throw new UserException("User not found with id: "+userId);
        } else {
            return optional.get();
        }		}

	public List<Users> getAllUsers() {
		return repo.findAll();
		}
	
	public  Response getRoleByUserName(String userName) {
		Response response = new Response();
		String optional = repo.findRoleByUserName(userName);
		if(optional == null) {
			 response.setStatusMessage("User not found with this userName : "+userName);
			 return response;
		} else {
			 response.setStatusMessage(optional);
			 return response;
		}	
	}
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user =  repo.findByUserName(username);
		String pwd=user.getPassword();
		System.out.println(pwd +" password");
		if(user.getUserName().equals(username)) {
			System.out.println(username);
			System.out.println(user.getUserName());
			System.out.println(user.getUserName().equals(username));
			
			return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), new ArrayList());
		} else {
			System.out.println("not logged in");
			System.out.println(username);
			System.out.println(user);
			System.out.println(user.getUserName());
			throw new UsernameNotFoundException("User not present"); 
		}
		}

	public Users getUserIdByUserName(String userName) {
		// TODO Auto-generated method stub
		return repo.findByUserName(userName);
	}
	
		
}
