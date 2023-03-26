package com.shopper;

import com.angi.datos.PedirDatos;
import com.shopper.contenedores.FactoryContenedor;
import com.shopper.productos.*;

import javax.swing.*;
import java.io.File;

public class Supermercado {
    public static final String ADVERTENCIA = "Toma en cuenta que: \nLos productos de las distintas categorías (ALIMENTACION, DROGUERIA, HIGIENE, MASCOTAS) no se mezclan en los contenedores. \nLas bolsas tienen una resistencia máxima. \nLas cajas soportan cualquier peso.";
    public static final String PREGUNTA1 = "¿Necesitas más contenedores? Indica S/N";

    public static void main(String[] args) {
        IPedido miPedido = new Pedido();
        String contenedor;
        File f = new File("Pedidos.txt");

        int opcion;
        try {
            do {
                opcion = PedirDatos.pedirEntero("***MENU*** \n\n1---> Crear Pedido \n2---> Crear contenedor \n3--->Crear productos \n4--->Crear fichero pedidos \n5--->Salir \n\n Teclea una opcion de las anteriores");
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
                        int opcionProductos;
                        do {
                            opcionProductos = PedirDatos.pedirEntero("***PRODUCTOS*** \n\n1---> Alimentos Fresco \n2---> Alimentos Congelados \n3--->Alimentos No Perecederos" +
                                    " \n4--->Droguería \n5--->Higiene \n6--->Mascotas \n7--->Salir \n\n Teclea una opcion de las anteriores");
                            switch (opcionProductos) {
                                case 1:
                                    miPedido.addProducto(FactoryProductos.getProducto(FactoryProductos.FRESCOS));
                                    break;
                                case 2:
                                    miPedido.addProducto(FactoryProductos.getProducto(FactoryProductos.CONGELADOS));
                                    break;
                                case 3:
                                    miPedido.addProducto(FactoryProductos.getProducto(FactoryProductos.NOPERECEDEROS));
                                    break;
                                case 4:
                                    miPedido.addProducto(FactoryProductos.getProducto(FactoryProductos.DROGUERIA));
                                    break;
                                case 5:
                                    miPedido.addProducto(FactoryProductos.getProducto(FactoryProductos.HIGIENE));
                                    break;
                                case 6:
                                    miPedido.addProducto(FactoryProductos.getProducto(FactoryProductos.MASCOTA));
                                    break;
                                default:
                                    break;
                            }
                        } while (opcionProductos <= 6);

                        JOptionPane.showMessageDialog(null, miPedido);
                        break;
                    case 4:
                        miPedido.agregarContenidoFichero(f);
                        break;
                    default:
                        break;
                }
            } while (opcion <= 4);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Adios");
        }
    }
}