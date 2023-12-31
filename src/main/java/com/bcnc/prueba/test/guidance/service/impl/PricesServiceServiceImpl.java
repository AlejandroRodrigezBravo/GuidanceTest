package com.bcnc.prueba.test.guidance.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcnc.prueba.test.guidance.entity.PricesEntity;
import com.bcnc.prueba.test.guidance.repository.IPricesRepository;
import com.bcnc.prueba.test.guidance.service.PricesService;

/**
 * Implementación del servicio prices
 * @author bravo
 * @version 25/08/2023 1.0.0
 */

@Service
public class PricesServiceServiceImpl implements PricesService {

	@Autowired
	private IPricesRepository repository;
	
	public PricesServiceServiceImpl (IPricesRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<PricesEntity> consulta(LocalDateTime  fechaAppStar,LocalDateTime fechaAppEnd, Long idProd, String idBrand) {
		
		//Por falta de DT(Documento tecnico) más explicito con lo que se espera hacer en la logica me creo solo una llamda donde busque segun fechas de inicio , final
		//idProducto e idBrand con el orderByDesc de priority para Desambiguador.
		List<PricesEntity> prices = repository.findByBrandIdAndProductIdAndStartDateGreaterThanEqualAndEndDateLessThanEqualOrderByPriorityDesc(idBrand,idProd,fechaAppStar, fechaAppEnd);
		
		return prices;
		
	}
	

}
