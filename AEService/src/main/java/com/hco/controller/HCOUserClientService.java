package com.hco.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hco.model.HCOUser;

@FeignClient(name = "hco-user-service")
public interface HCOUserClientService {

	@GetMapping("/api/v1/healthcare/accountexecutive/{userId}/allhcouserdetails")
	public List<HCOUser> getAllHcoUserDetails(@PathVariable int userId);

}
