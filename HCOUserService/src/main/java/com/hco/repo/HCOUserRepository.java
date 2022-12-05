package com.hco.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.hco.entity.HCOUser;

public interface HCOUserRepository extends JpaRepository<HCOUser, Integer>{

	@Query(value="select * from hcousers where hco_id= :hcoId", nativeQuery=true)
	List<HCOUser> findAllById(int hcoId);

	@Query(value="select * from hcousers where user_id= :userId", nativeQuery=true)
	List<HCOUser> findByUserId(int userId);

	@Transactional
	@Modifying(clearAutomatically=true)
	@Query(value="update HCOUsers user set user.status = :status where user.hco_id=:hcoId", nativeQuery=true)
	public int updateStatus(@Param("status") String status, @Param("hcoId") Integer hcoId);

}
