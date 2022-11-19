package br.com.ferry.dsmeta.repositories;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.ferry.dsmeta.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{

	@Query("SELECT p FROM Sale p WHERE p.date BETWEEN :min AND :max ORDER BY p.amount DESC")
	Page<Sale> findSales(LocalDate min, LocalDate max, Pageable page);
}
