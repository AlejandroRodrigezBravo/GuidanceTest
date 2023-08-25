package com.bcnc.prueba.test.guidance.rest.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	
	@GetMapping("/prices")
	public ResponseEntity<?> pricesEndPoint(@RequestParam(name = "fechaApp") Date fechaApp,
            @RequestParam(name = "idProd") long idProd,
            @RequestParam(name = "idBrand") long idBrand) {
				return null;
		
		
	}
	
	
}
