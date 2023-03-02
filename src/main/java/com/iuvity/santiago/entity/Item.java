package com.iuvity.santiago.entity;


import javax.persistence.*;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
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

    public Item() {
    }

    public Item(Integer id, String fecha, String detalle, int cantidadEntrada, int vrUnitarioEntrada, int vrTotalEntrada, int cantidadSalida, int vrUnitarioSalida, int vrTotalSalida, int cantidadSaldos, int vrUnitarioSaldos, int vrTotalSaldos) {
        this.id = id;
        this.fecha = fecha;
        this.detalle = detalle;
        this.cantidadEntrada = cantidadEntrada;
        this.vrUnitarioEntrada = vrUnitarioEntrada;
        this.vrTotalEntrada = vrTotalEntrada;
        this.cantidadSalida = cantidadSalida;
        this.vrUnitarioSalida = vrUnitarioSalida;
        this.vrTotalSalida = vrTotalSalida;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getCantidadEntrada() {
        return cantidadEntrada;
    }

    public void setCantidadEntrada(int cantidadEntrada) {
        this.cantidadEntrada = cantidadEntrada;
    }

    public int getVrUnitarioEntrada() {
        return vrUnitarioEntrada;
    }

    public void setVrUnitarioEntrada(int vrUnitarioEntrada) {
        this.vrUnitarioEntrada = vrUnitarioEntrada;
    }

    public int getVrTotalEntrada() {
        return vrTotalEntrada;
    }

    public void setVrTotalEntrada(int vrTotalEntrada) {
        this.vrTotalEntrada = vrTotalEntrada;
    }

    public int getCantidadSalida() {
        return cantidadSalida;
    }

    public void setCantidadSalida(int cantidadSalida) {
        this.cantidadSalida = cantidadSalida;
    }

    public int getVrUnitarioSalida() {
        return vrUnitarioSalida;
    }

    public void setVrUnitarioSalida(int vrUnitarioSalida) {
        this.vrUnitarioSalida = vrUnitarioSalida;
    }

    public int getVrTotalSalida() {
        return vrTotalSalida;
    }

    public void setVrTotalSalida(int vrTotalSalida) {
        this.vrTotalSalida = vrTotalSalida;
    }

    public int getCantidadSaldos() {
        return cantidadSaldos;
    }

    public void setCantidadSaldos(int cantidadSaldos) {
        this.cantidadSaldos = cantidadSaldos;
    }

    public int getVrUnitarioSaldos() {
        return vrUnitarioSaldos;
    }

    public void setVrUnitarioSaldos(int vrUnitarioSaldos) {
        this.vrUnitarioSaldos = vrUnitarioSaldos;
    }

    public int getVrTotalSaldos() {
        return vrTotalSaldos;
    }

    public void setVrTotalSaldos(int vrTotalSaldos) {
        this.vrTotalSaldos = vrTotalSaldos;
    }
}