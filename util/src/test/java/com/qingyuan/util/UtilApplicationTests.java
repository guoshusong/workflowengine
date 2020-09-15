package com.qingyuan.util;

import com.qingyuan.util.mapper.UUIDMapper;
import com.qingyuan.util.uuid.UUIDGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class UtilApplicationTests {

    @Resource
    private UUIDGenerator uuidGenerator;

	@Test
	void contextLoads() {
			System.out.println(uuidGenerator.generateUUID(0));

	}

}
