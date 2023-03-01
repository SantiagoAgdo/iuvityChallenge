package com.iuvity.hulkstore.service.impl;
import com.iuvity.hulkstore.dto.Valores;
import com.iuvity.hulkstore.service.itemStrategy;
public class salidaImpl  implements  itemStrategy{

    private Valores valores;

    public salidaImpl(Valores valores){
        this.valores = valores;
    }
    @Override
    public void movimiento() {
        System.out.println("moviendo Salidas");
    }
}
