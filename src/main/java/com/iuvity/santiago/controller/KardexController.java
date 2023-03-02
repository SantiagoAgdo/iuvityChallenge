package com.iuvity.santiago.controller;

import com.iuvity.santiago.entity.Item;
import com.iuvity.santiago.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kardex")
public class KardexController {

    @Autowired
    private ProductoService productoService;

    @PostMapping("/addProduct")
    public ResponseEntity<String> addProduct(@RequestBody Item item) {
        if (item == null) {
            return new ResponseEntity<>("Se debe de adjuntar un item", HttpStatus.BAD_REQUEST);
        }
        try {
            if (item.getDetalle().equals("Compra")) {
                productoService.addProducto(item);
            } else {
                boolean rpt = productoService.sellProduct(item);
                if (!rpt) {
                    return new ResponseEntity<>("Inventario Insuficiente para la compra", HttpStatus.BAD_REQUEST);
                }
            }
            return new ResponseEntity<>("Producto Agregado Correctamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al agregar Producto, Intente nuevamente", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/verLista")
    public ResponseEntity<List<Item>> lista() {
        return new ResponseEntity<>(productoService.viewAllProductos(), HttpStatus.OK);
    }

    @RequestMapping("/")
    public ResponseEntity home() {
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
