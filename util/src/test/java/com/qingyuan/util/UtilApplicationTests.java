package com.qingyuan.util;

import com.qingyuan.util.uuid.UUIDGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UtilApplicationTests {

	@Test
	void contextLoads() {
		UUIDGenerator uuidGenerator = new UUIDGenerator();
		System.out.println(uuidGenerator.generateUUID(0));;
	}

}
