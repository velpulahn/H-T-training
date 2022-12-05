package com.hco.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.hco.entity.HCOUser;
import com.hco.entity.Users;
import com.hco.exception.HCOUserException;
import com.hco.exception.UserException;
import com.hco.repo.HCOUserRepository;
import com.hco.repo.UsersRepository;

@Service
public class HCOUserService {

	 @Autowired 
	 private HCOUserRepository repo;
	 
	 @Autowired
	 private UsersRepository userRepo;
	 
//	 private static final String TOPIC = "kafka-topic";
//
//	    @KafkaListener(topics = TOPIC, groupId="group_id", containerFactory = "userKafkaListenerFactory")
//	    public void consumeJson(HCOUser hcouser) {
//	        System.out.println("Consumed JSON Message: " + hcouser);
//	    }
	    
	 public HCOUser saveUserDetails(int userId, HCOUser hcoUser) throws UserException{
			if(userRepo.existsById(userId)) {
				Users userRole = userRepo.getRoleByUserId(userId);
				String role = userRole.getRole();
				String user = "HCO User";
				if(role.equals(user)) {
	    		return repo.save(hcoUser);
				} else {
		    		throw new UserException("This User Id not having access to save HCO user details: "+ "User ID : " + userId);
				}
			}
			else {
	    		throw new UserException("This User Id not found: "+ "User ID : " + userId);
	    	}
	 }

	public HCOUser updateHCOUserDetails(int hcoId, int userId, HCOUser hcoUser) throws HCOUserException, UserException {
		// TODO Auto-generated method stub
		if(userRepo.existsById(userId)) {
		if(repo.existsById(hcoUser.getHcoId())) {
//			hcoUser.setHcoId(hcoUser.getHcoId());
			hcoUser.setUserId(userId);
			hcoUser.setOrganizationName(hcoUser.getOrganizationName());
			hcoUser.setAddress(hcoUser.getAddress());
			hcoUser.setCountry(hcoUser.getCountry());
			hcoUser.setState(hcoUser.getState());
			hcoUser.setCity(hcoUser.getCity());
			hcoUser.setZipcode(hcoUser.getZipcode());
			hcoUser.setEmail(hcoUser.getEmail());
			hcoUser.setWebsite(hcoUser.getWebsite());
			hcoUser.setPrimaryContact(hcoUser.getPrimaryContact());
			hcoUser.setPrimaryContactMobile(hcoUser.getPrimaryContactMobile());
			hcoUser.setSecondaryContact(hcoUser.getSecondaryContact());
			hcoUser.setSecondaryContactMobile(hcoUser.getSecondaryContactMobile());
			hcoUser.setPrograms(hcoUser.getPrograms());
			
    	System.out.println("Object of hcoUser :" + hcoUser);
		return repo.save(hcoUser);
    	} else {
    		throw new HCOUserException("HCO User details not updated with this id: "+ "HCO ID : " + hcoUser.getHcoId());
    	}
		} else {
    		throw new UserException("User details not found with this id: "+ "User ID : " + hcoUser.getUserId());
    	}
	}


	public List<HCOUser> getAllHcoUserDetails(int userId) throws UserException{
		if(userRepo.existsById(userId)) {

		return repo.findAll();
		}
		else {
    		throw new UserException("This User Id not found: "+ "User ID : " + userId);
    	}
	}
	
//	public HCOUser delete(int hcoId) throws HCOUserException{
//		Optional<HCOUser> optional= repo.findById(hcoId);
//    	if(optional.isEmpty()) {
//    		throw new HCOUserException("User not deleted with this id: "+hcoId);
//    	}
//    	else {
//    		repo.deleteById(hcoId);
//    		return optional.get();
//    	}
//	}

	public HCOUser getHcoUserById(int hcoId) throws HCOUserException {
	        Optional<HCOUser> optional = repo.findById(hcoId);
	        if(optional.isEmpty()){
	            throw new HCOUserException("HCO User not found with id: "+hcoId);
	        } else {
	            return optional.get();
	        }
	    }
	public List<HCOUser> getHcoUserDetailsByUserId(int userId) throws UserException {
		// TODO Auto-generated method stub
		List<HCOUser> optional= repo.findByUserId(userId);
		if(optional.isEmpty()) {
			throw new UserException("HCO User not found with this id :" + userId);
		}
		else {
			return optional;
		}
	}

	public void updateStatus(String status, int hcoId) {
		repo.updateStatus(status,hcoId);
	}
	

}
