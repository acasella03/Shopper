package com.shopper;

import java.io.File;
import java.util.ArrayList;
import java.util.Set;

/**
 * Datos necesarios para ser implementados en un pedido:
 * Obtener la referencia del pedido.
 * Obtener el producto que incluye el pedido.
 * Obtener el contenedor que usa el pedido.
 * Agregar tipo de contenedor del pedido.
 * Agregar producto de acuerdo al tipo de contenedor del pedido.
 * Visualización fichero.
 * Crear fichero del pedido.
 */

public interface IPedido {
    String getReferencia();
    Set<IProducto> getProductos();
    Set<IContenedor> getContenedores();
    void addContenedor(IContenedor contenedor);
    IContenedor addProducto(IProducto producto);
    String mostrarParaFichero();
    void agregarContenidoFichero(File fichero);
}
