package com.bcnc.prueba.test.guidance.web;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.bcnc.prueba.test.guidance.entity.PricesEntity;
import com.bcnc.prueba.test.guidance.rest.controller.EcommerceRestController;
import com.bcnc.prueba.test.guidance.service.PricesService;
import com.bcnc.prueba.test.guidance.utils.PricesUtilsTest;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

@WebMvcTest(EcommerceRestController.class)
public class PricesRestControllerTest {

	
	private MockMvc mockMvc;
	
	@MockBean
	PricesService pricesService;
	
	EcommerceRestController controller;
	
	 @BeforeEach
	    public void setUp() {//se mockea la llamada del controller
	        RestAssuredMockMvc.mockMvc(mockMvc);
	        RestAssuredMockMvc.standaloneSetup(new EcommerceRestController(pricesService));
	        MockitoAnnotations.openMocks(this);
	        controller = new EcommerceRestController(pricesService);
	    }

	@Test
	void testVerEcommercesRest() throws Exception {
		List<PricesEntity> prices = PricesUtilsTest.getListPrices();
		String brandId = "1";
		Long produId= 35455L;
		
		Mockito.when(pricesService.consulta(LocalDateTime.of(LocalDate.of(2020, 06, 14), LocalTime.of(00,00, 00)),LocalDateTime.of(LocalDate.of(2020, 12, 31), LocalTime.of(23,59,59)), produId, brandId))
		.thenReturn(prices); //Mockeo el servicio
		
		RestAssuredMockMvc.given()
		.param("fechaAppStar", "2020-06-14T00:00:00.00") //Parámetros a probar
		.param("fechaAppEnd", "2020-12-31T23:59:59.00")
        .param("idProd", 35455)
        .param("idBrand", "1")
		.header("Content-type", "application/json")
		.contentType(MediaType.APPLICATION_JSON_VALUE)
		.when()
			.get("/api/prices")//endPoint
		.then()
			.log().ifValidationFails()
			.statusCode(HttpStatus.OK.value());

	}
	
	@Test
	void testVerEcommercesRestNotFound() throws Exception {

		RestAssuredMockMvc.given()
		.param("fechaAppStar", "2020-06-14T00:00:00.00")
		.param("fechaAppEnd", "2020-12-31T23:59:59.00")
        .param("idProd", 35455)
        .param("idBrand", "2")
		.header("Content-type", "application/json")
		.contentType(MediaType.APPLICATION_JSON_VALUE)
		.when()
			.get("/api/prices")
		.then()
			.log().ifValidationFails()
			.status(HttpStatus.NOT_FOUND); //Se comprueba la respuesta 404

	}
	
	@Test
	void testVerEcommercesRestBadRequest() throws Exception {

		RestAssuredMockMvc.given()
		.param("fechaAppStar", "2020-06-14T00:00:00.00")
		.param("fechaAppEnd", "2020-12-31T23:59:59.00")
        .param("idProd", 35455)
		.header("Content-type", "application/json")
		.contentType(MediaType.APPLICATION_JSON_VALUE)
		.when()
			.get("/api/prices")
		.then()
			.log().ifValidationFails()
			.status(HttpStatus.BAD_REQUEST);//Se comprueba la respuesta 400

	}

}
