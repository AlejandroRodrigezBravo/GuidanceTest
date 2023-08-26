package com.bcnc.prueba.test.guidance.repository;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.bcnc.prueba.test.guidance.entity.PricesEntity;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class PricesRepositoryTest {

	@Autowired
	IPricesRepository repository;
	
	@BeforeEach
	public void setUp() {
	}

	
	@Test
	void get_WithValidParameters_MustReturnPrices() {
		String brandId = "1";
		Long produId= 35455L;

		List<PricesEntity> listPrices = repository.findByBrandIdAndProductIdAndStartDateGreaterThanEqualAndEndDateLessThanEqual(brandId, produId,LocalDateTime.of(LocalDate.of(2020, 06, 14), LocalTime.of(00,00, 00)),LocalDateTime.of(LocalDate.of(2020, 12, 31), LocalTime.of(23,59,59)));

		assertAll(
				() -> assertNotNull(listPrices)
		);
	}
}
