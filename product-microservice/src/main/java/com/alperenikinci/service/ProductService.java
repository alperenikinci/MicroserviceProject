package com.alperenikinci.service;

import com.alperenikinci.repository.IProductRepository;
import com.alperenikinci.repository.entity.Product;
import com.alperenikinci.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends ServiceManager<Product, Long> {

    private final IProductRepository repository;

    public ProductService(IProductRepository repository){
        super(repository);
        this.repository=repository;
    }
}
