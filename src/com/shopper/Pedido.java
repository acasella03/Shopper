package com.shopper;

import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Datos del pedido.
 */
public class Pedido implements IPedido {
    /**
     * Identificador del pedido.
     */
    private String referencia;
    /**
     * Tipo de contenedor del pedido.
     */
    private Set<IContenedor> contenedores;

    FileWriter out = null;
    PrintWriter fich = null;
    Scanner sc;

    /**
     * Constructor parametrizado.
     *
     * @param referencia identificadora del pedido.
     */
    public Pedido(String referencia) {
        this.referencia = referencia;
        this.contenedores = new HashSet<>();
    }

    /**
     * Obtiene la referencia del pedido.
     *
     * @return la referencia del pedido.
     */
    @Override
    public String getReferencia() {
        return referencia;
    }

    /**
     * Obtiene el producto del pedido.
     *
     * @return producto del pedido.
     */
    @Override
    public Set<IProducto> getProductos() {
        Set<IProducto> productos = null;
        for (IContenedor c : contenedores) {
            if (productos == null) {
                productos = c.getProductos();
            } else {
                productos.addAll(c.getProductos());
            }
        }
        return productos;
    }

    /**
     * Obtiene el tipo de contenedor que usa el pedido.
     *
     * @return el tipo de contenedor del pedido.
     */
    @Override
    public Set<IContenedor> getContenedores() {
        return contenedores;
    }

    /**
     * Agrega el tipo de contenedor que usa el pedido.
     *
     * @param contenedor utilizado en el pedido.
     */
    @Override
    public void addContenedor(IContenedor contenedor) {
        contenedores.add(contenedor);
    }

    /**
     * Agrega el producto al contenedor de un pedido.
     *
     * @param producto tipo de producto agregado.
     * @return el contenedor en el que se ha colocado el producto, si es null no ha localizado el contenedor para el producto.
     */
    @Override
    public IContenedor addProducto(IProducto producto) {
        for (IContenedor contenedor : contenedores) {
            if (contenedor.meter(producto)) {
                return contenedor;
            }
        }
        return null;
    }

    /**
     * Imprime información el pedido.
     *
     * @return información completa del pedido.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pedido: " + referencia + "\n");
        for (IContenedor contenedor : contenedores) {
            sb.append("\t" + contenedor + "\n");
        }
        return sb.toString();
    }

    /**
     * Método para crear un fichero.
     *
     * @param fichero donde se va a almacenar el pedido.
     */
    @Override
    public void agregarPalabras(File fichero) {
        try {
            out = new FileWriter(fichero, true);
            fich = new PrintWriter(out);
            fich.println(new Pedido(referencia));
        } catch (IOException e) {
            System.out.println("Error de escritura" + e.getMessage());
        } finally {
            fich.close();
        }
    }

    /**
     * Método para leer un fichero.
     *
     * @param fichero que se leerá.
     * @return fichero leído.
     */
    @Override
    public ArrayList<Pedido> leerObjeto(File fichero) {
        ArrayList<Pedido> lista = new ArrayList<>();
        String[] aux;
        try {
            sc = new Scanner(fichero);
            while (sc.hasNextLine()) {
                aux = sc.nextLine().split("");
                lista.add(new Pedido(aux[0]));
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se puede leer el fichero");
        } finally {
            sc.close();
        }
        return lista;
    }

    @Override
    public void mostrarFichero(ArrayList<Pedido> lista) {
            for (Pedido pedido : lista) {
                System.out.println(pedido);
            }
        }
}
