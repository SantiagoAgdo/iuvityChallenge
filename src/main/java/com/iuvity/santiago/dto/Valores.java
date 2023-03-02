package com.iuvity.santiago.dto;

public class Valores {
    private int cantidad;
    private int valorUnitario;
    private  int total;

    public Valores() {
    }

    public Valores(int cantidad, int valorUnitario, int total) {
        this.cantidad = cantidad;
        this.valorUnitario = valorUnitario;
        this.total = total;
    }
    public Valores(int cantidad, int valorUnitario) {
        this.cantidad = cantidad;
        this.valorUnitario = valorUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(int valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
