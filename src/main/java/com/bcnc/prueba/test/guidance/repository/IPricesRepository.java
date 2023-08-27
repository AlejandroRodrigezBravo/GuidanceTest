package com.bcnc.prueba.test.guidance.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bcnc.prueba.test.guidance.entity.PricesEntity;

@Repository
public interface IPricesRepository extends JpaRepository<PricesEntity, Long> {

	List<PricesEntity> findByBrandIdAndProductIdAndStartDateGreaterThanEqualAndEndDateLessThanEqualOrderByPriorityDesc(String brandId,Long product,LocalDateTime star,LocalDateTime end);
	//Se puede hacer de muchas maneras donde una vez recupere la lista de todoas las coincidencias añadir filtro más especifico y devolver en vez de una lista un solo elemento.
	//PricesEntity findByBrandIdAndProductIdAndStartDateGreaterThanEqualAndEndDateLessThanEqualOrderByPriorityDesc(String brandId,Long product,LocalDateTime star,LocalDateTime end);
	//List<PricesEntity> findByStartDateOrderByPriorityDesc(LocalDateTime star);
	//List<PricesEntity> findByEndDateOrderByPriorityDesc(LocalDateTime end);
	
	
}
