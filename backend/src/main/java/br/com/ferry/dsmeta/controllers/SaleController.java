package br.com.ferry.dsmeta.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ferry.dsmeta.entities.Sale;
import br.com.ferry.dsmeta.services.SaleService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/sales")
public class SaleController {
    
    private SaleService saleService;

    @GetMapping
    public List<Sale> findAllSales(){
        return saleService.findAllSales();
    }
}
