package com.shopper;

import com.angi.datos.PedirDatos;
import com.shopper.contenedores.FactoryContenedor;
import com.shopper.productos.*;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

public class Supermercado {
    public static final String ADVERTENCIA = "Toma en cuenta que: \nLos productos de las distintas categorías (ALIMENTACION, DROGUERIA, HIGIENE, MASCOTAS) no se mezclan en los contenedores. \nLas bolsas tienen una resistencia máxima. \nLas cajas soportan cualquier peso.";
    public static final String PREGUNTA1 = "¿Necesitas más contenedores? Indica S/N";
    public static final String PREGUNTA2 = "¿Tienes más productos? Indica S/N";

    public static void main(String[] args) {
        IPedido miPedido = null;
        String contenedor;
        File f = new File("Pedidos.txt");

        int opcion;
        do {
            opcion = PedirDatos.pedirEntero("***MENU*** \n\n1---> Crear Pedido \n2---> Crear contenedor \n3--->Crear productos \n4--->Crear fichero pedidos \n5--->Motrar fichero pedidos \n6--->Salir \n\n Teclea una opcion de las anteriores");
            switch (opcion) {
                case 1:
                    miPedido = new Pedido(PedirDatos.pedirDatos("Escribe la referencia del pedido: "));
                    break;

                case 2:
                    JOptionPane.showMessageDialog(null, ADVERTENCIA);
                    do {
                        contenedor = PedirDatos.pedirDatos("¿Necesitas una bolsa o una caja? Indica B/C");
                        if (contenedor.equalsIgnoreCase("b")) {
                            miPedido.addContenedor(FactoryContenedor.getContenedor(FactoryContenedor.BOLSA));
                        } else if (contenedor.equalsIgnoreCase("c")) {
                            miPedido.addContenedor(FactoryContenedor.getContenedor(FactoryContenedor.CAJA));
                        }
                    } while (PedirDatos.pedirDatos(PREGUNTA1).equalsIgnoreCase("s"));
                    break;

                case 3:
                    do {
                        String fr = PedirDatos.pedirDatos("¿Tienes alimentos frescos? Indica S/N");
                        if (fr.equalsIgnoreCase("s")) {
                            miPedido.addProducto(FactoryProductos.getProducto(FactoryProductos.FRESCOS));
                        }
                        String c = PedirDatos.pedirDatos("¿Tienes alimentos congelados? Indica S/N");
                        if (c.equalsIgnoreCase("s")) {
                            miPedido.addProducto(FactoryProductos.getProducto(FactoryProductos.CONGELADOS));
                        }
                        String nP = PedirDatos.pedirDatos("¿Tienes alimentos no perecederos? Indica S/N:");
                        if (nP.equalsIgnoreCase("s")) {
                            miPedido.addProducto(FactoryProductos.getProducto(FactoryProductos.NOPERECEDEROS));
                        }
                        String d = PedirDatos.pedirDatos("¿Tienes productos de droguería? Indica S/N");
                        if (d.equalsIgnoreCase("s")) {
                            miPedido.addProducto(FactoryProductos.getProducto(FactoryProductos.DROGUERIA));
                        }
                        String m = PedirDatos.pedirDatos("¿Tienes productos para mascotas? Indica S/N");
                        if (m.equalsIgnoreCase("s")) {
                            miPedido.addProducto(FactoryProductos.getProducto(FactoryProductos.MASCOTA));
                        }
                        String h = PedirDatos.pedirDatos("¿Tienes productos de higiene? Indica S/N");
                        if (h.equalsIgnoreCase("s")) {
                            miPedido.addProducto(FactoryProductos.getProducto(FactoryProductos.HIGIENE));
                        }
                    } while (PedirDatos.pedirDatos(PREGUNTA2).equalsIgnoreCase("s"));

                    JOptionPane.showMessageDialog(null, "Mi pedido con productos: " + miPedido);

                case 4:
                    miPedido.agregarPalabras(f);
                case 5:
                    ArrayList<Pedido> lista = miPedido.leerObjeto(f);
                    miPedido.mostrarFichero(lista);
                default:
                    break;
            }
        } while (opcion <= 5);

    }
}