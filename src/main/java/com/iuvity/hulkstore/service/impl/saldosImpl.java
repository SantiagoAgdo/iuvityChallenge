package com.iuvity.hulkstore.service.impl;

import com.iuvity.hulkstore.dto.Valores;
import com.iuvity.hulkstore.service.itemStrategy;

public class saldosImpl implements  itemStrategy{

    private Valores valores;

    public saldosImpl(Valores valores){
        this.valores = valores;
    }
    @Override
    public void movimiento() {
        System.out.println("moviendo Saldos");
    }
}
