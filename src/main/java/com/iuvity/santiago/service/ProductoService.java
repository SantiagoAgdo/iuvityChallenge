package com.iuvity.santiago.service;


import com.iuvity.santiago.entity.Item;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    void addProducto(Item item);

    boolean sellProduct(Item item);

    List<Item> viewAllProductos();

    Item viewProductoByDetalle(String detalle);

    boolean productoExists(String detalle);

    boolean deleteProducto(String detalle);

    void updateProducto(String detalle, int cantidad);

    Optional<Item> getItem(Integer id);
}
