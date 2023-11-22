package com.devsuperior.dsmeta.repositories;

import com.devsuperior.dsmeta.dto.SaleSummaryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmeta.entities.Sale;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query(value = """
            SELECT obj FROM Sale obj JOIN FETCH obj.seller WHERE obj.date >= :min AND obj.date <= :max AND UPPER(obj.seller.name) LIKE UPPER(CONCAT('%', :name, '%')) """,
            countQuery = """
                         SELECT COUNT(obj) FROM Sale obj JOIN obj.seller  
                         WHERE obj.date >= :min 
                         AND obj.date <= :max  
                         AND UPPER(obj.seller.name) LIKE UPPER(CONCAT('%', :name, '%')) """)
    Page<SaleSummaryDTO> searchSummaries(LocalDate min, LocalDate max, String name, Pageable pageable);
}
