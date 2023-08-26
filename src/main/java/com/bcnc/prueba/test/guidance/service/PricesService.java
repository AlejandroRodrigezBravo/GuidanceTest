package com.bcnc.prueba.test.guidance.service;

import java.time.LocalDateTime;
import java.util.List;

import com.bcnc.prueba.test.guidance.entity.Prices;

/**
 * Funcionalidad de prices
 * @author bravo
 * @version 25/08/2022 1.0.0
 */

public interface PricesService {

	public List<Prices>  consulta(LocalDateTime fechaAppStar,LocalDateTime fechaAppEnd, Long idProd, String idBrand);
}
