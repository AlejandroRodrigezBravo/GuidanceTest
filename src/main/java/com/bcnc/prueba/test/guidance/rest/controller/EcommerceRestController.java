package com.bcnc.prueba.test.guidance.rest.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
* @version 27/08/2023 1.0.0
*/

@RestController
@RequestMapping("/api")
public class EcommerceRestController {

	private static final Logger logger = LoggerFactory.getLogger(EcommerceRestController.class);
	
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
		//Se crea la lista a devolver.
		List<PricesEntity> price = new ArrayList<>();
		//Se crea la respuesta a devolver.
		ResponseEntity<List<PricesEntity>> rest = null;
		
		try {
			//Se realiza llamada a la implementacion del servicio para recuperar datos segun existan en BBDD con los parametros pasados.
			price = pricesServices.consulta(fechaAppStar, fechaAppEnd, idProd, idBrand);
			logger.info("Lista encontrada " +  price);
			//Si es diferente a  null o vacio se devuelve la repuesta ok - estado 200. Significa que todo ha ido bien.
			if(price != null && !price.isEmpty()) {
				logger.info("Se encuntra la sguiente lista según parametros pasados: -fecha de inicio: " + fechaAppStar + ", -fecha final: " + fechaAppEnd +", -IdProducto: " + idProd + ", -idBrand: " + idBrand);
				rest = new ResponseEntity<>(price,HttpStatus.OK);
				
			} else { //y si no se devuelve la respuesta no encontrada- estado 404.
				logger.info("No se ha encontrado ningun resultado con parametros de busqueda -fecha de inicio: " + fechaAppStar + ", -fecha final: " + fechaAppEnd + ", -IdProducto: " + idProd + ", -idBrand: " + idBrand);
				rest= new ResponseEntity<>(price,HttpStatus.NOT_FOUND);
			}
			
		} catch (Exception e) { //Se añada la exception para controlar las 500
			logger.info("Error: " + e.getMessage() + "Causa" + e.getCause());
			throw e;
		}
		return rest;
			
	}
	
	
}
