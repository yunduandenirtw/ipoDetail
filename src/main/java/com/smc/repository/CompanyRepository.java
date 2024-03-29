package com.smc.repository;



import com.smc.entity.CompanyEntity;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;

import org.springframework.data.jpa.repository.Query;



/**

 * @ClassName CompanyRepository

 * @Description TODO

 * @Author WangRuiTing

 * @Date 12/9/2019 10:50 AM

 * @Version 1.0

 **/

public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer> {



	@Transactional

	@Modifying()

	@Query(name = "setActiveForCompany", nativeQuery = true, value = "update company set companystatus = :active where companyname = :companyName")

	void setActiveForCompany(String companyName, String active);

}

