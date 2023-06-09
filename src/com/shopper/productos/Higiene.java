package com.shopper.productos;

import com.shopper.IProducto;
import com.shopper.enums.Categoria;

public class Higiene extends Producto {

    public Higiene(String referencia, int peso, int volumen) {
        super(referencia, peso, volumen);
    }

    @Override
    public Categoria getCategoria() {
        return Categoria.HIGIENE;
    }

    @Override
    public boolean esCompatible(IProducto p) {
        return !Categoria.ALIMENTACION.equals(p.getCategoria()) && !Categoria.DROGUERIA.equals(p.getCategoria()) && !Categoria.MASCOTAS.equals(p.getCategoria());
    }
}
