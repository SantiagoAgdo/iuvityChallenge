package com.iuvity.hulkstore.entity;

import com.iuvity.hulkstore.dto.Valores;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String fecha;
    private String detalle;

    // Entradas
    private int cantidadEntrada;
    private int vrUnitarioEntrada;
    private int vrTotalEntrada;
    // Salidas
    private int cantidadSalida;
    private int vrUnitarioSalida;
    private int vrTotalSalida;
    // Saldos
    private int cantidadSaldos;
    private int vrUnitarioSaldos;
    private int vrTotalSaldos;
}
