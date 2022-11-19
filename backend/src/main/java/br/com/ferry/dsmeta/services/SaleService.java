package br.com.ferry.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.ferry.dsmeta.entities.Sale;
import br.com.ferry.dsmeta.repositories.SaleRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SaleService {

    private SaleRepository saleRepository;

    public Page<Sale> findAllSales(String minDate, String maxDate, Pageable page) {
    	LocalDate now = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
    	
        LocalDate min = minDate.equals("") ? now.minusDays(365) : LocalDate.parse(minDate);
        LocalDate max =  maxDate.equals("") ? now : LocalDate.parse(maxDate);
    	
    	return saleRepository.findSales(min, max, page);
    }
}
