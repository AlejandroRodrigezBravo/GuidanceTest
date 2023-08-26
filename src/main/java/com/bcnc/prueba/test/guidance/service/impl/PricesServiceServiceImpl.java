package com.bcnc.prueba.test.guidance.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcnc.prueba.test.guidance.entity.Prices;
import com.bcnc.prueba.test.guidance.repository.IPricesRepository;
import com.bcnc.prueba.test.guidance.service.PricesService;

/**
 * Implementación del servicio prices
 * @author bravo
 * @version 25/08/2024 1.0.0
 */

@Service
public class PricesServiceServiceImpl implements PricesService {

	@Autowired
	private IPricesRepository repository;
	
	public PricesServiceServiceImpl (IPricesRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Prices> consulta(LocalDateTime  fechaAppStar,LocalDateTime fechaAppEnd, Long idProd, String idBrand) {
		
		List<Prices> prices = repository.findByBrandIdAndProductIdAndStartDateGreaterThanEqualAndEndDateLessThanEqual(idBrand,idProd,fechaAppStar, fechaAppEnd);
	
		return prices;
	}

}
