package com.alperenikinci.controller;

import com.alperenikinci.dto.request.BaseRequestDto;
import com.alperenikinci.repository.entity.Product;
import com.alperenikinci.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.alperenikinci.constants.RestApi.*;
@RestController
@RequestMapping(PRODUCT)
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping(GETALL)
    public ResponseEntity<List<Product>> getAll(@RequestBody @Valid BaseRequestDto dto){
        return ResponseEntity.ok(productService.findAll());
    }
}
