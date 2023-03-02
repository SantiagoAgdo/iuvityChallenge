package com.iuvity.santiago.entity;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Rule;


import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private  Item item;

    @Before
    public void setUp() {
        List<Item> lista = new ArrayList<>();
        item = new Item(1,"12/02/2023","Compra",10,100,0,0,0,0,0,0,0);
        lista.add(item);
    }

    @Test
    public void saveDetalleInItem() {
        Assertions.assertEquals(item.getDetalle(), "Compra");
    }

    @Test
    public void saveCantidadEntradaInItem() {
        Assertions.assertEquals(item.getCantidadEntrada(), 10);
    }






}
