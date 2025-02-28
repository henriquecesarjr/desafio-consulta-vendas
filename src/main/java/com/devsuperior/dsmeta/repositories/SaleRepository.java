package com.devsuperior.dsmeta.repositories;

import com.devsuperior.dsmeta.dto.SaleReportDTO;
import com.devsuperior.dsmeta.dto.SaleSummaryDTO;
import net.bytebuddy.asm.Advice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmeta.entities.Sale;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT new com.devsuperior.dsmeta.dto.SaleSummaryDTO(obj.seller.name, SUM(obj.amount)) " +
            "FROM Sale obj " +
            "WHERE obj.date BETWEEN :min AND :max " +
            "GROUP BY obj.seller.name")
    Page<SaleSummaryDTO> searchSummaries(LocalDate min, LocalDate max, Pageable pageable);

    @Query(value = """
                    SELECT obj FROM Sale obj JOIN FETCH obj.seller WHERE obj.date BETWEEN :min AND :max AND UPPER(obj.seller.name) LIKE UPPER(CONCAT('%', :name, '%'))""",
            countQuery = """
                             SELECT COUNT(obj) FROM Sale obj JOIN obj.seller
                              WHERE obj.date BETWEEN :min AND :max
                                AND UPPER(obj.seller.name) LIKE UPPER(CONCAT('%', :name, '%'))
                               """)
    Page<SaleReportDTO> searchReports(LocalDate min, LocalDate max, String name, Pageable pageable);
}
