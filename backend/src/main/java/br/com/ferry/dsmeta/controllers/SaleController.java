package br.com.ferry.dsmeta.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public Page<Sale> findAllSales(@RequestParam(value = "minDate", defaultValue = "") String minDate,
			@RequestParam(value = "miaxDate", defaultValue = "") String maxDate, Pageable page) {
		return saleService.findAllSales(minDate, maxDate, page);
	}
}
