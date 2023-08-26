package com.bcnc.prueba.test.guidance.rest.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bcnc.prueba.test.guidance.entity.PricesEntity;
import com.bcnc.prueba.test.guidance.service.PricesService;

/**
* Endpoint de ecommerce de la tabla prices
* @author bravo
* @version 01/04/2022 1.0.0
*/

@RestController
@RequestMapping("/api")
public class EcommerceRestController {

	
	@Autowired
	private PricesService pricesServices;
	
	public EcommerceRestController(PricesService pricesServices) {
		this.pricesServices= pricesServices;
	}
	
	@GetMapping("/prices")
	public ResponseEntity<List<PricesEntity>> pricesEndPoint(@RequestParam(name = "fechaAppStar") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaAppStar,
			@RequestParam(name = "fechaAppEnd") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaAppEnd,
            @RequestParam(name = "idProd") long idProd,
            @RequestParam(name = "idBrand") String idBrand) throws Exception {
		
		List<PricesEntity> price = new ArrayList<>();
		ResponseEntity<List<PricesEntity>> rest = null;
		
		try {
			price = pricesServices.consulta(fechaAppStar, fechaAppEnd, idProd, idBrand);
			if(price != null && !price.isEmpty()) {
				rest = new ResponseEntity<>(price,HttpStatus.OK);
				
			} else {
				rest= new ResponseEntity<>(price,HttpStatus.NOT_FOUND);
			}
			
		} catch (Exception e) {
			throw e;
		}
		return rest;
			
	}
	
	
}
