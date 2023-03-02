package com.iuvity.santiago.controller;

import com.iuvity.santiago.entity.Item;
import com.iuvity.santiago.repository.ProductoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class KardexControllerTest {

    @Autowired
    ProductoRepository productoRepository;


    @Test
    public void guardarItem(){
        Item item = mock();
        productoRepository.save(item);
    }


    public Item mock() {
        Item item = new Item(1,"Compra","12/02/2023",10,100,0,0,0,0,0,0,0);
        return item;
    }
}
