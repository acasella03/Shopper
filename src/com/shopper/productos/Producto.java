package com.shopper.productos;

import com.shopper.IContenedor;
import com.shopper.IProducto;
import com.shopper.enums.Categoria;

public abstract class Producto implements IProducto {
    private String referencia;
    private int peso;
    private int volumen;
    private IContenedor contenedor;

    public Producto(String referencia, int peso, int volumen) {
        this.referencia = referencia;
        this.peso = peso;
        this.volumen = volumen;
    }

    @Override
    public String getReferencia() {
        return referencia;
    }

    @Override
    public int getPeso() {
        return peso;
    }

    @Override
    public int getVolumen() {
        return volumen;
    }

    @Override
    public boolean tengoEspacio(IContenedor contenedor) {
        return contenedor.volumenDisponible() > volumen;
    }

    @Override
    public void meter(IContenedor contenedor) {
        this.contenedor = contenedor;
    }

    @Override
    public String toString() {
        return "Producto de " + getCategoria() + "\n\t\t\tRef.= " + referencia + "\n\t\t\tpeso= " + peso + "\n\t\t\tvolumen= " + volumen + "\n\t\t\tcontenedor= "
                + contenedor.getReferencia();
    }
}
