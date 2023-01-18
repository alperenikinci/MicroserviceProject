package com.alperenikinci.controller;

import com.alperenikinci.dto.request.BaseRequestDto;
import com.alperenikinci.repository.entity.Sale;
import com.alperenikinci.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.alperenikinci.constants.RestApi.*;
@RestController
@RequestMapping(SALES)
@RequiredArgsConstructor
public class SaleController {

    private final SaleService saleService;

    @PostMapping(GETALL)
    public ResponseEntity<List<Sale>> getAll(@RequestBody @Valid BaseRequestDto dto){
        return ResponseEntity.ok(saleService.findAll());
    }
}
