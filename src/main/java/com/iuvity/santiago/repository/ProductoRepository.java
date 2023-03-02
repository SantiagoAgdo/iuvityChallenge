package com.iuvity.santiago.repository;

import com.iuvity.santiago.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Item, Integer> {

    Item findByDetalle(String detalle);
    boolean existsByDetalle(String detalle);

    void deleteByDetalle(String detalle);
}
