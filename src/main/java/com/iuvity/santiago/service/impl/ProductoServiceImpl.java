package com.iuvity.santiago.service.impl;

import com.iuvity.santiago.entity.Item;
import com.iuvity.santiago.repository.ProductoRepository;
import com.iuvity.santiago.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public void addProducto(Item item) {
        if (productoRepository.existsByDetalle(item.getDetalle())) {
            addMoreProduct(item);
        } else {
            addInitialProduct(item);
        }
    }

    public void addInitialProduct(Item item) {
        Item i = new Item();

        i.setFecha(item.getFecha());
        i.setDetalle(item.getDetalle());

        i.setCantidadEntrada(item.getCantidadEntrada());
        i.setVrUnitarioEntrada(item.getVrUnitarioEntrada());
        i.setVrTotalEntrada(item.getVrUnitarioEntrada() * item.getCantidadEntrada());

        i.setCantidadSaldos(item.getCantidadEntrada());
        i.setVrUnitarioSaldos(item.getVrUnitarioEntrada());
        i.setVrTotalSaldos(item.getVrUnitarioEntrada() * item.getCantidadEntrada());

        productoRepository.save(i);
    }

    public void addMoreProduct(Item item) {
        item.setFecha(item.getFecha());
        item.setDetalle(item.getDetalle());
        item.setVrTotalEntrada(item.getVrUnitarioEntrada() * item.getCantidadEntrada());
        item.setCantidadSaldos(item.getCantidadEntrada());

        Item itemSend = item;
        try {
            Optional<Item> itemPrevius = productoRepository.findById(item.getId() - 1);

            int vrUnitarioSaldo = (itemPrevius.get().getVrTotalSaldos() + item.getVrTotalEntrada()) / (itemPrevius.get().getCantidadEntrada() + item.getCantidadEntrada());
            int total = itemPrevius.get().getVrTotalSaldos() + item.getVrTotalEntrada();

            itemSend.setCantidadSaldos(itemPrevius.get().getCantidadSaldos() + item.getCantidadSaldos());
            itemSend.setVrUnitarioSaldos(vrUnitarioSaldo);
            itemSend.setVrTotalSaldos(total);
            productoRepository.save(itemSend);
        }catch (Exception e){
            System.out.println("Error En la secuencia de Identificadores");
        }
    }

    @Override
    public boolean sellProduct(Item item) {
        Optional<Item> itemPrevius = productoRepository.findById(item.getId() - 1);
        try {
            if (itemPrevius.get().getCantidadSaldos() <= 0 || item.getCantidadSalida() > itemPrevius.get().getCantidadSaldos()) {
                return false;
            }
            addMoreSellProduct(item);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public void addMoreSellProduct(Item item) {
        item.setFecha(item.getFecha());
        item.setDetalle(item.getDetalle());
        item.setVrTotalSalida(item.getVrUnitarioSalida() * item.getCantidadSalida());

        Item itemSend = item;
        Optional<Item> itemPrevius = productoRepository.findById(item.getId() - 1);

        itemSend.setCantidadSaldos(itemPrevius.get().getCantidadSaldos() - item.getCantidadSalida());
        itemSend.setVrUnitarioSaldos(item.getVrUnitarioSalida());
        itemSend.setVrTotalSaldos(itemPrevius.get().getVrTotalSaldos() - item.getVrTotalSalida());
        productoRepository.save(itemSend);
    }

    @Override
    public List<Item> viewAllProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Item viewProductoByDetalle(String detalle) {
        return productoRepository.findByDetalle(detalle);
    }

    @Override
    public boolean productoExists(String detalle) {
        return productoRepository.existsByDetalle(detalle);
    }

    @Override
    public boolean deleteProducto(String detalle) {
        try {
            productoRepository.deleteByDetalle(detalle);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public void updateProducto(String detalle, int cantidad) {

        Item item = productoRepository.findByDetalle(detalle);

//        item.setCantidadEntrada();


    }

    @Override
    public Optional<Item> getItem(Integer id) {
        return productoRepository.findById(id);
    }
}
