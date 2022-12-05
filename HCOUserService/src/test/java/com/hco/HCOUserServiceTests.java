package com.hco;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hco.entity.HCOUser;
import com.hco.exception.HCOUserException;
import com.hco.exception.UserException;
import com.hco.repo.HCOUserRepository;
import com.hco.repo.UsersRepository;
import com.hco.service.HCOUserService;

@SpringBootTest
public class HCOUserServiceTests {

	@Autowired
	private HCOUserService service;
	
	@Autowired
	private HCOUserRepository repo;
	
	 @Autowired
	 private UsersRepository userRepo;
	
	@Test
	public void shouldSaveHCOUser() throws UserException{
		HCOUser hcouser = service.saveUserDetails(2,new HCOUser(1899988889,2,"HealthyHearts","Near old road","India","AP","ATP","767537",
				"nan45@gmail.com","www.abc.com","Brother","8976974858","Sister","8976974858","Engineering","Requested"));
		
		Assertions.assertEquals(hcouser.getHcoId(), 1899988889);
		Assertions.assertEquals(hcouser.getUserId(), 2);
		Assertions.assertEquals(hcouser.getOrganizationName(), "HealthyHearts");
		Assertions.assertEquals(hcouser.getAddress(), "Near old road");
		Assertions.assertEquals(hcouser.getCountry(), "India");
		Assertions.assertEquals(hcouser.getState(), "AP");
		Assertions.assertEquals(hcouser.getCity(), "ATP");
		Assertions.assertEquals(hcouser.getZipcode(), "767537");
		Assertions.assertEquals(hcouser.getEmail(), "nan45@gmail.com");
		Assertions.assertEquals(hcouser.getWebsite(), "www.abc.com");
		Assertions.assertEquals(hcouser.getPrimaryContact(), "Brother");
		Assertions.assertEquals(hcouser.getPrimaryContactMobile(), "8976974858");
		Assertions.assertEquals(hcouser.getSecondaryContact(), "Sister");
		Assertions.assertEquals(hcouser.getSecondaryContactMobile(), "8976974858");
		Assertions.assertEquals(hcouser.getPrograms(), "Engineering");
		Assertions.assertEquals(hcouser.getStatus(), "Requested");
	}
	
//	@Test
//	public void shouldNotSaveHCOUser() throws HCOUserException{
//		if(!repo.existsById(1)) {
//			Assertions.assertThrows(HCOUserException.class, ()->{
//				service.saveUserDetails(1, null);
//			});
//		}
//	}
	@Test
	public void getAllHcoUserDetailsTest() {
		if(userRepo.existsById(2)) {
		List<HCOUser> hcouser = (List<HCOUser>) repo.findAll();
		for (HCOUser user : hcouser) {
			System.out.println(user);
		}
		assertThat(hcouser).size().isGreaterThan(0);
		}
	}
	@Test
	public void notGetAllHcoUserDetailsTest() {
		if(!userRepo.existsById(1)) {
			List<HCOUser> hcouser = (List<HCOUser>) repo.findAll();
			if(hcouser == null) {
			assertThat(hcouser);
			}
		}
	}
	@Test
	public void getHcoUserById(){
		Optional<HCOUser> hcouser = (Optional<HCOUser>) repo.findById(2);
		assertThat(hcouser);
	}
	@Test
	public void shouldNotGetHcoUserById(){
		if(!repo.existsById(1)) {
			List<HCOUser> hcouser = (List<HCOUser>) repo.findAll();
			if(hcouser == null) {
			assertThat(hcouser);
			}
		}
	}
	
//	@Test
//	public void updateHCOUserDetailsTest() throws UserException {
//		if(userRepo.existsById(2)) {
//			if(repo.existsById(2)) {
//				HCOUser hcouser = new HCOUser();
//				hcouser.setHcoId(2);
//				Mockito.when(repo.save(hcouser)).thenReturn(hcouser);
//				//assertThat(repo.)
//
////				Mockito.when(repo.existsById(2)).thenReturn(hcouser);
////				hcouser.
////			HCOUser hcouser = service.saveUserDetails(2,new HCOUser(1899988889,2,"HealthyHearts","Near old road","India","AP","ATP","767537",
////			"nan45@gmail.com","www.abc.com","Brother","8976974858","Sister","8976974858","Engineering","Requested"));
//				
////				HCOUser hcouser = new HCOUser(1899988889,2,"HealthyHearts","Near old road","India","AP","ATP","767537",
////					"nan45@gmail.com","www.abc.com","Brother","8976974858","Sister","8976974858","Engineering","Requested");
////				hcouser.setHcoId(2);
////				repo.save(hcouser);
////				HCOUser newUser = repo.getById(2);
//				//assertThat(newUser.getHcoId().
//		}
//	}
//	}
	
//	@Test
//	public void shouldNotUpdateHCOUserDetailsTest() throws UserException {
//		Integer hcoId = 2;
//		HCOUser hcouser = new HCOUser();
//		//if(!userRepo.existsById(hcoId)) {
//			Mockito.when(repo.findById(hcoId)).thenReturn(null);
//			HCOUser result = service.saveUserDetails(hcoId,hcouser);
//			assertThat(result);
////			if(!repo.existsById(2)) {
////			HCOUser hcouser = service.saveUserDetails(2,null);
////		}
//	}
	

	
	@Test
	public void getHcoUserDetailsByUserIdTest() {
		if(userRepo.existsById(2)) {
		List<HCOUser> hcouser = (List<HCOUser>) repo.findAll();
		for (HCOUser user : hcouser) {
			System.out.println(user);
		}
		assertThat(hcouser).size().isGreaterThan(0);
		}
	}
	@Test
	public void shouldNotGetHcoUserDetailsByUserIdTest() {
		if(!userRepo.existsById(1)) {
			List<HCOUser> hcouser = (List<HCOUser>) repo.findAll();
			if(hcouser == null) {
			assertThat(hcouser);
			}
		}
	}
	
	@Test
	public void updateStatusTest() {
			if(repo.existsById(2)) {
			 service.updateStatus("Approved", 2);
	}
	}
	
//	if(repo.existsById(2)) {
//		String status = "Approved";
//	HCOUser hcouser= new HCOUser(status, 2);
//	hcouser.setHcoId(2);
//	repo.save(hcouser);
//	Optional<HCOUser> optional= repo.findById(2);
	//asserThat(optional.getStatus().isEqualTo(status));
	
	@Test
	public void shouldNotUpdateStatusTest() throws UserException {
		if(!repo.existsById(2)) {
			 service.updateStatus(null, 2);
	}
}
	
}
