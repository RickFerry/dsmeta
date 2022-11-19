package br.com.ferry.dsmeta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ferry.dsmeta.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{
    
}
