package com.iuvity.hulkstore.controller;

import com.iuvity.hulkstore.context.Procesar;
import com.iuvity.hulkstore.dto.Valores;
import com.iuvity.hulkstore.service.impl.entradaImpl;
import com.iuvity.hulkstore.service.impl.saldosImpl;
import com.iuvity.hulkstore.service.impl.salidaImpl;
import com.iuvity.hulkstore.service.itemStrategy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/kardex")
public class kardexController {

    @GetMapping("/getStrategy")
    public ResponseEntity getStrategy(){

        Valores valores = new Valores(10, 1000, 10);

        List<itemStrategy> itemStrategyList = new ArrayList<>();

        itemStrategy itemStrategy1 = new entradaImpl(valores);
        itemStrategyList.add(itemStrategy1);
        itemStrategy itemStrategy2 = new salidaImpl(valores);
        itemStrategyList.add(itemStrategy2);
        itemStrategy itemStrategy3 = new saldosImpl(valores);
        itemStrategyList.add(itemStrategy3);

        Procesar order = new Procesar();

        itemStrategyList.forEach(itemStrategy -> order.procesarProducto(itemStrategy));

        return ResponseEntity.noContent().build();
    }



}