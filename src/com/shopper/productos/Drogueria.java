package com.shopper.productos;

import com.shopper.IProducto;
import com.shopper.enums.Categoria;

public class Drogueria extends Producto {

    public Drogueria(String referencia, int peso, int volumen) {
        super(referencia, peso, volumen);
    }

    @Override
    public Categoria getCategoria() {
        return Categoria.DROGUERIA;
    }

    @Override
    public boolean esCompatible(IProducto p) {
        return !Categoria.ALIMENTACION.equals(p.getCategoria()) && !Categoria.MASCOTAS.equals(p.getCategoria()) && !Categoria.HIGIENE.equals(p.getCategoria());
    }
}
