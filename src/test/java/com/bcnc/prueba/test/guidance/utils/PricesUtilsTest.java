package com.bcnc.prueba.test.guidance.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.bcnc.prueba.test.guidance.entity.PricesEntity;

public class PricesUtilsTest {

	public static PricesEntity getPrices() { //Me creo método estatico para coverage y funcionalidad

		PricesEntity entity = new PricesEntity();

		entity.setBrandId("1");
		entity.setCurr("EUR");
		entity.setEndDate(LocalDateTime.of(LocalDate.of(2020, 12, 31), LocalTime.of(23, 59, 59)));
		entity.setId(1L);
		entity.setPrice(35.50);
		entity.setPriceList(1L);
		entity.setPriority("0");
		entity.setProductId(35455L);
		entity.setStartDate(LocalDateTime.of(LocalDate.of(2020, 06, 14), LocalTime.of(00, 00, 00)));

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

	public static List<PricesEntity> getListPricesAll() {//Me creo método estatico para coverage y funcionalidad

		List<PricesEntity> listPricesOux = new ArrayList<>();

		PricesEntity entity1 = new PricesEntity();

		entity1.setBrandId("1");
		entity1.setCurr("EUR");
		entity1.setEndDate(LocalDateTime.of(LocalDate.of(2020, 06, 14), LocalTime.of(18, 30, 00)));
		entity1.setId(1L);
		entity1.setPrice(35.50);
		entity1.setPriceList(1L);
		entity1.setPriority("0");
		entity1.setProductId(35455L);
		entity1.setStartDate(LocalDateTime.of(LocalDate.of(2020, 06, 14), LocalTime.of(15, 00, 00)));
		listPricesOux.add(entity1);

		PricesEntity entity2 = new PricesEntity();

		entity2.setBrandId("1");
		entity2.setCurr("EUR");
		entity2.setEndDate(LocalDateTime.of(LocalDate.of(2020, 06, 14), LocalTime.of(18, 30, 00)));
		entity2.setId(2L);
		entity2.setPrice(25.45);
		entity2.setPriceList(2L);
		entity2.setPriority("1");
		entity2.setProductId(35455L);
		entity2.setStartDate(LocalDateTime.of(LocalDate.of(2020, 06, 14), LocalTime.of(15, 00, 00)));
		listPricesOux.add(entity2);

		PricesEntity entity3 = new PricesEntity();

		entity3.setBrandId("1");
		entity3.setCurr("EUR");
		entity3.setEndDate(LocalDateTime.of(LocalDate.of(2020, 06, 15), LocalTime.of(11, 00, 00)));
		entity3.setId(3L);
		entity3.setPrice(35.50);
		entity3.setPriceList(3L);
		entity3.setPriority("0");
		entity3.setProductId(35455L);
		entity3.setStartDate(LocalDateTime.of(LocalDate.of(2020, 06, 15), LocalTime.of(00, 00, 00)));
		listPricesOux.add(entity3);

		PricesEntity entity4 = new PricesEntity();

		entity4.setBrandId("1");
		entity4.setCurr("EUR");
		entity4.setEndDate(LocalDateTime.of(LocalDate.of(2020, 12, 31), LocalTime.of(23, 59, 59)));
		entity4.setId(1L);
		entity4.setPrice(38.95);
		entity4.setPriceList(4L);
		entity4.setPriority("0");
		entity4.setProductId(35455L);
		entity4.setStartDate(LocalDateTime.of(LocalDate.of(2020, 06, 15), LocalTime.of(16, 00, 00)));
		listPricesOux.add(entity4);

		return listPricesOux;
	}

	public static List<PricesEntity> getListPrices() {//Me creo método estatico para coverage y funcionalidad
		List<PricesEntity> listPricesOux = new ArrayList<>();

		for (PricesEntity entity : getListPricesAll()) {
			listPricesOux.add(entity);
		}

		return listPricesOux;
	}
}
