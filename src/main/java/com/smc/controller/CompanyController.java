package com.smc.controller;

import com.alibaba.fastjson.JSONObject;
import com.smc.entity.CompanyEntity;
import com.smc.entity.IPODetailEntity;
import com.smc.service.CompanyService;
import com.smc.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName CompanyController
 * @Description TODO
 * @Author WangRuiTing
 * @Date 12/9/2019 5:05 PM
 * @Version 1.0
 **/

@CrossOrigin
@RestController
@RequestMapping("/admin/manage/company")
public class CompanyController {


	@Autowired
	private CompanyService companyService;

	/**
	 * add company("/admin/manage/company")
	 * @param jsonObject
	 * @return
	 */
	@PostMapping
	public CommonResult newCompany(@RequestBody JSONObject jsonObject) {
		CompanyEntity companyDtl = jsonObject.getObject("company", CompanyEntity.class);
		IPODetailEntity ipoDetail = jsonObject.getObject("ipo", IPODetailEntity.class);
		return companyService.addCompany(companyDtl, ipoDetail);
	}

	/**
	 * put method("/admin/manage/company")
	 * @param companyDtl
	 * @return
	 */
	@PutMapping
	public CommonResult updateCompany(
			@RequestBody CompanyEntity companyDtl) {
		return companyService.updateCompany(companyDtl);
	}

	/**
	 * active
	 * @param companyName
	 * @return
	 */
	@PostMapping("/active")
	public CommonResult activeCompany(@RequestParam("companyName") String companyName) {
		return companyService.setActiveForCompany(companyName, "1");
	}

	/**
	 * inactive
	 * @param companyName
	 * @return
	 */
	@PostMapping("/inactive")
	public CommonResult inactiveCompany(@RequestParam("companyName") String companyName) {
		return companyService.setActiveForCompany(companyName, "0");
	}

}
