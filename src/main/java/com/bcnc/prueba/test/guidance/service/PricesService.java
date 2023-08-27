package com.bcnc.prueba.test.guidance.service;

import java.time.LocalDateTime;
import java.util.List;

import com.bcnc.prueba.test.guidance.entity.PricesEntity;

/**
 * Funcionalidad de prices
 * @author bravo
 * @version 25/08/2023 1.0.0
 */

public interface PricesService {

	/**
	 * Método para realizar la llamada a BBDD para recuperar todos los datos segun coincidencias.
	 * @param fechaAppStar fecha de inicio de aplicación.
	 * @param fechaAppEnd fecha de fin de aplicación.
	 * @param idProd identificador del producto.
	 * @param idBrand identificador de brand.
	 * @return devuelve una lista con todos los valores recuperados.
	 */
	public List<PricesEntity>  consulta(LocalDateTime fechaAppStar,LocalDateTime fechaAppEnd, Long idProd, String idBrand);
}
