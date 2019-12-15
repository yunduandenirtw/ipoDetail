package com.smc;



import com.smc.entity.IPODetailEntity;
import com.smc.service.IpoService;
import java.util.Date;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IPOApplicationTests {

	@Autowired
	IpoService service;

	@Test
	public void updateStockExchangeTest() {
		IPODetailEntity oldIPO = new IPODetailEntity();
		oldIPO.setIpoid(1);
		oldIPO.setCompanyName("test");
		oldIPO.setIpoRemarks("test");
		oldIPO.setOpenDateTime(new Date().toString());
		oldIPO.setPricePerShare("22");
		oldIPO.setStockExchange("test");
		oldIPO.setTotalNumber(2);
		service.updateStockExchange(oldIPO);
	}

}
