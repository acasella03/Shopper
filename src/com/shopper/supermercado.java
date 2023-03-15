package com.shopper;

import com.angi.datos.PedirDatos;
import com.shopper.contenedores.Bolsa;
import com.shopper.contenedores.Caja;
import com.shopper.contenedores.FactoryContenedor;
import com.shopper.productos.Congelado;
import com.shopper.productos.Fresco;
import com.shopper.productos.Higiene;

public class supermercado {
    public static void main(String[] args) {
        IPedido miPedido = null;
        IContenedor bolsa = null;
        IContenedor caja = null;
        int opcion;
        do {
            opcion = PedirDatos.pedirEntero("***MENU*** \n\n 1---> Crear Pedido \n 2---> Crear contenedor \n3--->Crear productos \n4--->Mostrar contenedor \n5--->Mostrar pedido \n6--->Salir \n\n Teclea una opcion de las anteriores");
            switch (opcion) {
                case 1:
                    miPedido = new Pedido(PedirDatos.pedirDatos("Escribe la referencia del pedido: "));
                    break;

                case 2:
                    bolsa = FactoryContenedor.getContenedor(FactoryContenedor.BOLSA);
                    caja = FactoryContenedor.getContenedor(FactoryContenedor.CAJA);
                    miPedido.addContenedor(bolsa);
                    miPedido.addContenedor(caja);
                    break;

                case 3:
                    IProducto manzanas = new Fresco("MNZ", 1000, 1500);
                    IProducto helado = new Congelado("HLD", 800, 1000);
                    IProducto papelWC = new Higiene("PWC", 500, 2500);
                    IProducto peras = new Fresco("PER", 800, 1200);
                case 4:
                    /*IContenedor contManzanas = miPedido.addProducto(manzanas);
                    IContenedor contHelado = miPedido.addProducto(helado);
                    IContenedor contPapel = miPedido.addProducto(papelWC);
                    IContenedor contPeras = miPedido.addProducto(peras);*/
                case 5:
                    //System.out.println("Mi pedido con productos: " + miPedido);
                default:
                    break;
            }
        } while (opcion <= 5);

    }
}