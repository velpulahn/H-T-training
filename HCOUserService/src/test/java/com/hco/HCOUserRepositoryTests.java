package com.hco;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.hco.entity.HCOUser;
import com.hco.repo.HCOUserRepository;

@DataJpaTest
public class HCOUserRepositoryTests {

	@Autowired
	private HCOUserRepository repo;
	
//	@Test
//	public void saveHCOUser() {
//		HCOUser hcoUser=new HCOUser()
//				.hcoId(1)
//	}
}
