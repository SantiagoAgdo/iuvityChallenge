package com.iuvity.santiago.repository;

import com.iuvity.santiago.entity.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

import static org.junit.Assert.assertEquals;

@DataJpaTest
@ExtendWith(SpringExtension.class)
@Transactional
public class ProductoRepositoryTest {

    @Autowired
    private ProductoRepository productoRepository;

    @Test
    public void testFindByDetalle() {
        Item item = new Item();
        productoRepository.save(item);
        Item result = productoRepository.findByDetalle(item.getDetalle());
        Assertions.assertEquals(item.getDetalle(), result.getDetalle());
    }

}
