package com.shopper.productos;

import com.shopper.IContenedor;
import com.shopper.IProducto;
import com.shopper.enums.Categoria;

public abstract class Producto implements IProducto {
    /**
     * Identificador del producto.
     */
    private String referencia;
    /**
     * Peso en gramos del producto.
     */
    private int peso;
    /**
     * Volumen en cm3 del producto.
     */
    private int volumen;
    /**
     * Contenedor del producto.
     */
    private IContenedor contenedor;

    /**
     * Constructor parametrizado.
     *
     * @param referencia del producto.
     * @param peso       del producto.
     * @param volumen    del producto.
     */
    public Producto(String referencia, int peso, int volumen) {
        this.referencia = referencia;
        this.peso = peso;
        this.volumen = volumen;
    }

    /**
     * Método para obtener la referencia del producto.
     *
     * @return la referencia del producto.
     */
    @Override
    public String getReferencia() {
        return referencia;
    }

    /**
     * Método para obtener el peso del producto.
     *
     * @return el peso del producto.
     */
    @Override
    public int getPeso() {
        return peso;
    }

    /**
     * Método para obtener el volumen del producto.
     *
     * @return el volumen del producto.
     */
    @Override
    public int getVolumen() {
        return volumen;
    }

    /**
     * Médodo para comprobar si el contenedor tiene espacio suficiente para agregar otro producto.
     *
     * @param contenedor tipo de contenedor.
     * @return si el contenedor tiene espacio o no.
     */
    @Override
    public boolean tengoEspacio(IContenedor contenedor) {
        return contenedor.volumenDisponible() > volumen;
    }

    /**
     * Método para identificar cuando un producto ya está dentro del contenedor.
     *
     * @param contenedor tipo de contenedor.
     */
    @Override
    public void meter(IContenedor contenedor) {
        this.contenedor = contenedor;
    }

    /**
     * Imprime por ventana información completa de los productos incluidos en el contenedor.
     *
     * @return información de todos los productos incluidos en el contenedor.
     */
    @Override
    public String toString() {
        return getCategoria() + ": " + "\n\t\t\t" + referencia + "\n\t\t\tcontenedor utilizado: "
                + contenedor.getReferencia();
    }

    /**
     * Imprime en el fichero información de los productos en el contenedor.
     *
     * @return información de todos los productos incluidos en el contenedor.
     */
    @Override
    public String mostrar() {
        return getCategoria() + ", " + referencia;
    }
}
