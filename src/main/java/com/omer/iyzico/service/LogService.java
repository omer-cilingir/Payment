package com.omer.iyzico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omer.iyzico.model.Log;
import com.omer.iyzico.repository.LogRepository;

@Service
public class LogService {

	@Autowired
	private LogRepository paymentRepository;

	public Log findById(Integer Id) {
		return paymentRepository.findById(Id);
	}

	public List<Log> findAll() {
		return paymentRepository.findAll();
	}

	public Log save(Log log) {
		return paymentRepository.save(log);
	}
}
