package com.omer.iyzico.service;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.omer.iyzico.model.Ticket;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TicketServiceTest {

	@Autowired
	private TicketService ticketService;

	@Test
	public void create_ticket_and_delete() throws ParseException {
		Ticket ticket = new Ticket();
		ticket.setPrice(new BigDecimal("250"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		ticket.setStartDate(sdf.parse("2017-06-01"));
		ticket.setEndDate(sdf.parse("2018-01-15"));
		ticket.setType("Blind Bird");
		ticket.setCurrency("TL");
		Ticket savedTicket = ticketService.save(ticket);
		assertEquals(savedTicket.getType(), ticket.getType());
		assertEquals(savedTicket.getEndDate(), ticket.getEndDate());
		assertEquals(savedTicket.getStartDate(),ticket.getStartDate());
		assertEquals(savedTicket.getPrice(), ticket.getPrice());
		assertEquals(savedTicket.getCurrency(), ticket.getCurrency());
		ticketService.deleteById(savedTicket.getId());
	}

	@Test
	public void find_ticket_by_id() throws ParseException {
		Ticket ticket = new Ticket();
		ticket.setPrice(new BigDecimal("250"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		ticket.setStartDate(sdf.parse("2017-06-01"));
		ticket.setEndDate(sdf.parse("2018-01-15"));
		ticket.setType("Blind Bird");
		ticket.setCurrency("TL");
		Ticket savedTicket = ticketService.save(ticket);
		Ticket foundTicket = ticketService.findById(savedTicket.getId());
		assertEquals(savedTicket.getType(), foundTicket.getType());
		ticketService.deleteById(savedTicket.getId());
	}

	@Test
	public void find_all_tickets() throws ParseException {
		Ticket ticket = new Ticket();
		ticket.setPrice(new BigDecimal("250"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		ticket.setStartDate(sdf.parse("2017-06-01"));
		ticket.setEndDate(sdf.parse("2018-01-15"));
		ticket.setType("Blind Bird");
		ticket.setCurrency("TL");
		Ticket savedTicket = ticketService.save(ticket);
		List<Ticket> foundSale = ticketService.findAll();
		assertEquals(Arrays.asList(savedTicket).get(0).getType(), foundSale.get(0).getType());
		ticketService.deleteById(savedTicket.getId());
	}

}