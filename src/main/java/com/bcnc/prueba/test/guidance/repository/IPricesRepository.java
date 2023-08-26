package com.bcnc.prueba.test.guidance.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bcnc.prueba.test.guidance.entity.Prices;

@Repository
public interface IPricesRepository extends JpaRepository<Prices, Long> {

	List<Prices> findByBrandIdAndProductIdAndStartDateGreaterThanEqualAndEndDateLessThanEqual(String brandId,Long product,LocalDateTime star,LocalDateTime end);
	
	//Prices findByProductID(Long product);
	
	//Prices findByStartDateGreaterThanEqualAndEndDateLessThanEqual(LocalDate star, LocalDate  end);
	
}
