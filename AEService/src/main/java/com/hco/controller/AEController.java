package com.hco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hco.model.HCOUser;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v1/healthcare/ae")
public class AEController {

	@Autowired 
	private HCOUserClientService feignService;
	
//	@Autowired
//    private KafkaTemplate<String, HCOUser> kafkaTemplate;
//	
//	private static final String TOPIC = "kafka-topic";
//
//	 @GetMapping("/publish/{organizationName}")
//	    public String publishBook(@PathVariable String organizationName) {
//
//	        int id = (int)(Math.floor(Math.random()*100));
//	        kafkaTemplate.send(TOPIC, new HCOUser(id, 5, organizationName, "Near new road", "India","AP","Hindupur","463566",
//	        	"nan34@gmail.com","www.xyz.com","Brother", "8755573565", "Sister", "7974877875","Engineering","Requested" ));
//
//	        return "Published successfully";
//	    }
	 
	@GetMapping("/{userId}/allhcouserdetails")
	public List<HCOUser> getAllHcoUserDetails(@PathVariable int userId) {
		return feignService.getAllHcoUserDetails(userId);
	}
}
