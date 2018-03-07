package com.omer.iyzico.service;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.omer.iyzico.model.Sale;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SaleServiceTest {

	@Autowired
	private SaleService saleService;

	@Test
	public void create_sale_and_delete() {
		Sale sale = new Sale();
		sale.setPrice(new BigDecimal("1.0"));
		sale.setProcessId("001");
		sale.setResult("SUCCESS");
		Sale savedSale = saleService.save(sale);
		assertEquals(savedSale.getProcessId(), sale.getProcessId());
		assertEquals(savedSale.getPrice(), sale.getPrice());
		assertEquals(savedSale.getResult(), sale.getResult());
		saleService.delete("001");
	}

	@Test
	public void find_sale_by_id() {
		Sale sale = new Sale();
		sale.setPrice(new BigDecimal("1.0"));
		sale.setProcessId("001");
		sale.setResult("SUCCESS");
		Sale savedSale = saleService.save(sale);
		Sale foundSale = saleService.findById(savedSale.getId());
		assertEquals(savedSale.getProcessId(), foundSale.getProcessId());
		saleService.delete("001");
	}

	@Test
	public void find_all_sales() {
		Sale sale = new Sale();
		sale.setPrice(new BigDecimal("1.0"));
		sale.setProcessId("001");
		sale.setResult("SUCCESS");
		Sale savedSale = saleService.save(sale);
		List<Sale> foundSale = saleService.findAll();
		assertEquals(Arrays.asList(savedSale).get(0).getProcessId(), foundSale.get(0).getProcessId());
		saleService.delete("001");
	}

}