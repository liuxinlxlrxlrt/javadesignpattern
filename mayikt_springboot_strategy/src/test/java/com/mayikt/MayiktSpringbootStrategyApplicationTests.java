package com.mayikt;

import com.mayikt.strategy.context.PayContextStrategy;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MayiktSpringbootStrategyApplicationTests {

	@Test
	void contextLoads() {
		PayContextStrategy payContextStrategy = new PayContextStrategy();
		String ali_pay = payContextStrategy.toPayHtml("ALI_PAY");
		System.out.println(ali_pay);
	}
}
