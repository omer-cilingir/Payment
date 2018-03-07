package com.omer.iyzico.service;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.omer.iyzico.model.Log;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class LogServiceTest {

	@Autowired
	private LogService logService;

	@Test
	public void create_log_and_delete() {
		Log log = new Log();
		log.setCardNumber("111");
		log.setProcessId("001");
		log.setId(1);
		log.setCreateDate(Calendar.getInstance().getTime());
		Log savedLog = logService.save(log);

		assertEquals(savedLog.getCardNumber(),log.getCardNumber());

		logService.delete("001");
	}

	@Test
	public void find_log_by_id() {
		Log log = new Log();
		log.setCardNumber("111");
		log.setProcessId("001");
		log.setId(1);
		log.setCreateDate(Calendar.getInstance().getTime());
		Log savedLog = logService.save(log);
		Log foundLog = logService.findById(savedLog.getId());
		assertEquals(savedLog.getCardNumber(), foundLog.getCardNumber());
		logService.delete("001");
	}
	
	@Test
	public void find_all_logs() {
		Log log = new Log();
		log.setCardNumber("111");
		log.setProcessId("001");
		log.setId(1);
		log.setCreateDate(Calendar.getInstance().getTime());
		logService.save(log);
		List<Log> foundLogs = logService.findAll();
		assertEquals(Arrays.asList(log).get(0).getCardNumber(), foundLogs.get(0).getCardNumber());
		logService.delete("001");
	}

}