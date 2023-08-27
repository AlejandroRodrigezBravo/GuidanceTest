package com.bcnc.prueba.test.guidance.serive;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import com.bcnc.prueba.test.guidance.entity.PricesEntity;
import com.bcnc.prueba.test.guidance.repository.IPricesRepository;
import com.bcnc.prueba.test.guidance.service.impl.PricesServiceServiceImpl;
import com.bcnc.prueba.test.guidance.utils.PricesUtilsTest;


public class PricesServiceTest {
	
	@Mock
	IPricesRepository iPricesRepository;
	
	@Mock
	PricesEntity pricesEntity;
	
	PricesServiceServiceImpl serviceImpl;
	
	@BeforeEach
    public void setUp() {
    	MockitoAnnotations.openMocks(this);
    	serviceImpl = new PricesServiceServiceImpl(iPricesRepository);
    }
	
	@Test 
    void get_WithValidParameters_MustReturnPricesService() throws Exception {
		
		List<PricesEntity> prices = PricesUtilsTest.getListPricesAll();//Lista de la calse utils para poder realizar el coverage y comprobar funcionalidad a razond e los datos de BBDD h2.
		String brandId = "1";
		Long produId= 35455L;
		StringBuilder sB = new StringBuilder();//Clase de stringBuilder para concatenar la respuesta de la lista de test del servicio.
		
		Mockito.when( iPricesRepository.findByBrandIdAndProductIdAndStartDateGreaterThanEqualAndEndDateLessThanEqualOrderByPriorityDesc(Mockito.any(String.class),Mockito.any(Long.class),
				Mockito.any(LocalDateTime.class),Mockito.any(LocalDateTime.class)))
        .thenReturn(prices); //Se mockea el servicio para poder comrpobar funcionalidad y coverage.
		
		//Se realiza varias pruebas para comprobar que realiza la busquedad correctamente.
		//List<PricesEntity>result = serviceImpl.consulta(LocalDateTime.of(LocalDate.of(2020, 06, 14), LocalTime.of(00,00,00)),LocalDateTime.of(LocalDate.of(2020, 12, 31), LocalTime.of(23,59,59)), produId, brandId);
		List<PricesEntity>result = serviceImpl.consulta(LocalDateTime.of(LocalDate.of(2020, 06, 14), LocalTime.of(15,00,00)),LocalDateTime.of(LocalDate.of(2020, 06, 14), LocalTime.of(18,30,00)), produId, brandId);
		
		assertAll(
		          () -> assertNotNull(result.get(0))//Se comprueba con assertion qaue el valor no es nulo y se testea la capa service
		        );
		
		int numtest = 1;//Variable para aumentar y delvolver la lista de test 
		for(PricesEntity entity : result) { //Se recorre la lista y se va concatenando segun valores que recupere de la lista.
			
			sB.append("TEST").append(numtest).append(" : petición a las ").append(entity.getStartDate().getHour())
			.append(":").append(entity.getStartDate().getMinute()).append(entity.getStartDate().getMinute())
			.append(" del día ").append(entity.getStartDate().getDayOfMonth())
			.append(" del producto ").append(entity.getProductId()).append(" para la brand ")
			.append(entity.getBrandId()).append(" (ZARA) ").append(entity.getPrice()).append("\n");
			
			++numtest;
		}
		
		System.out.print(sB); //Muestra por consola la lista de test del servicio testeada, segund datos de BBDD y de la clase utils.
		
	}

}
