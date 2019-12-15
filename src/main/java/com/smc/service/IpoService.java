package com.smc.service;

import com.smc.entity.IPODetailEntity;
import com.smc.repository.IpoRepository;
import com.smc.utils.CommonResult;
import com.smc.utils.ResponseCode;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName IpoService
 * @Description TODO
 * @Author WangRuiTing
 * @Date 12/4/2019 10:40 AM
 * @Version 1.0
 **/
@Service
public class IpoService {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IpoRepository repository;

	/**
	 * Description: query all exchange.
	 *
	 * @param:
	 * @return: com.smc.utils.CommonResult
	 * @auther: WangRuiTing
	 * @date: 2019/12/04 11:19 AM
	 */
	public CommonResult save(IPODetailEntity ipo) {
		try {
			repository.save(ipo);
			return CommonResult.build(ResponseCode.SUCCESS, "SUCCESS!");
		} catch (Exception e) {
			logger.error("Fail to create ipo data:", e);
			return CommonResult.build(ResponseCode.ERROR_ACCESS_DB, "DB ERROR!");
		}
	}

	/**
	 * Description: update StockExchange detail
	 *
	 * @param:
	 * @return: com.smc.utils.CommonResult
	 * @auther: WangRuiTing
	 * @date: 2019/12/04 11:56 AM
	 */
	public CommonResult updateStockExchange(IPODetailEntity ipo) {
		try {
			IPODetailEntity oldIPO = repository.findById(ipo.getIpoid())
					.get();
			oldIPO.setCompanyName(ipo.getCompanyName());
			oldIPO.setIpoRemarks(ipo.getIpoRemarks());
			oldIPO.setOpenDateTime(ipo.getOpenDateTime());
			oldIPO.setPricePerShare(ipo.getPricePerShare());
			oldIPO.setStockExchange(ipo.getStockExchange());
			oldIPO.setTotalNumber(ipo.getTotalNumber());
			repository.save(oldIPO);
			return CommonResult.build(ResponseCode.SUCCESS, "SUCCESS!");
		} catch (Exception e) {
			logger.error("Fail to update ipo data:", e);
			return CommonResult.build(ResponseCode.ERROR_ACCESS_DB, "DB ERROR!");
		}
	}
}
