package com.bcnc.prueba.test.guidance.serive;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.jdbc.Sql;

import com.bcnc.prueba.test.guidance.entity.PricesEntity;
import com.bcnc.prueba.test.guidance.repository.IPricesRepository;
import com.bcnc.prueba.test.guidance.service.impl.PricesServiceServiceImpl;
import com.bcnc.prueba.test.guidance.utils.PricesUtilsTest;
@Sql("/data.sql")
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
		
		List<PricesEntity> prices = PricesUtilsTest.getListPrices();
		String brandId = "1";
		Long produId= 35455L;
		StringBuilder sB = new StringBuilder();
		
		Mockito.when( iPricesRepository.findByBrandIdAndProductIdAndStartDateGreaterThanEqualAndEndDateLessThanEqual(Mockito.any(String.class),Mockito.any(Long.class),
				Mockito.any(LocalDateTime.class),Mockito.any(LocalDateTime.class)))
        .thenReturn(prices); 
		
		List<PricesEntity>result = serviceImpl.consulta(LocalDateTime.of(LocalDate.of(2020, 06, 14), LocalTime.of(00,00,00)),LocalDateTime.of(LocalDate.of(2020, 12, 31), LocalTime.of(23,59,59)), produId, brandId);
		
		assertAll(
		          () -> assertNotNull(result.get(0))
		        );
		
		int numtest = 1;
		for(PricesEntity entity : result) {
			sB.append("TEST").append(numtest).append(" : petición a las ").append(entity.getStartDate().getHour()).append(entity.getStartDate().getMinute()).append(" del día ").append(entity.getStartDate().getDayOfMonth())
			.append(" del producto ").append(entity.getProductId()).append(" para la brand ").append(entity.getBrandId()).append(" (ZARA) ").append("\n");
			
			++numtest;
		}
		
		System.out.print(sB);
		
	}

}
