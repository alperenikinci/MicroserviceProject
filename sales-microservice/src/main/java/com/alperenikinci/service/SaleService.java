package com.alperenikinci.service;

import com.alperenikinci.repository.ISaleRepository;
import com.alperenikinci.repository.entity.Sale;
import com.alperenikinci.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class SaleService extends ServiceManager<Sale, Long> {

    private final ISaleRepository repository;

    public SaleService(ISaleRepository repository){
        super(repository);
        this.repository=repository;
    }
}
