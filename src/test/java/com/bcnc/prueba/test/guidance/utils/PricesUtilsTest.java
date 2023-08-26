package com.bcnc.prueba.test.guidance.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.bcnc.prueba.test.guidance.entity.PricesEntity;

public class PricesUtilsTest {

	public static PricesEntity getPrices() {
		
		PricesEntity entity = new PricesEntity();
		
		entity.setBrandId("1");
		entity.setCurr("EUR");
		entity.setEndDate(LocalDateTime.of(LocalDate.of(2020, 12, 31), LocalTime.of(23,59,59)));
		entity.setId(1L);
		entity.setPrice(35.50);
		entity.setPriceList(1L);
		entity.setPriority("0");
		entity.setProductId(35455L);
		entity.setStartDate(LocalDateTime.of(LocalDate.of(2020, 06, 14), LocalTime.of(00,00, 00)));
	
		entity.getBrandId();
		entity.getCurr();
		entity.getEndDate();
		entity.getId();
		entity.getPrice();
		entity.getPriceList();
		entity.getPriority();
		entity.getProductId();
		entity.getStartDate();
		
		entity.toString();
		
		return entity;
		
	}
	
	public static List<PricesEntity> getListPrices() {
		List<PricesEntity> listPricesAux = new ArrayList<>();
		List<PricesEntity> listPricesOux = new ArrayList<>();
		
		listPricesAux.add(getPrices());
		
		for(PricesEntity entity : listPricesAux) {
			listPricesOux.add(entity);
		}
		
		return listPricesOux;
	}
}
