package br.com.ferry.dsmeta.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ferry.dsmeta.entities.Sale;
import br.com.ferry.dsmeta.repositories.SaleRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SaleService {

    private SaleRepository saleRepository;

    public List<Sale> findAllSales() {
        return saleRepository.findAll();
    }
}
