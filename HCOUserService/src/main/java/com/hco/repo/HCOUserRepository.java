package com.hco.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hco.entity.HCOUser;

public interface HCOUserRepository extends JpaRepository<HCOUser, Integer>{


}
