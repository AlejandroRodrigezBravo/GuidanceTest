package com.bcnc.prueba.test.guidance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bcnc.prueba.test.guidance.entity.Prices;

@Repository
public interface IPricesRepository extends JpaRepository<Prices, Long> {

}
