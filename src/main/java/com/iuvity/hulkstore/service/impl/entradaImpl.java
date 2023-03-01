package com.iuvity.hulkstore.service.impl;

import com.iuvity.hulkstore.dto.Valores;
import com.iuvity.hulkstore.service.itemStrategy;

public class entradaImpl implements itemStrategy {

    private Valores valores;

    public entradaImpl(Valores valores){
        this.valores = valores;
    }


    @Override
    public void movimiento() {
        System.out.println("moviendo Entrada");
    }
}
