package com.shopper;

import com.angi.datos.PedirDatos;
import com.shopper.contenedores.Bolsa;
import com.shopper.contenedores.Caja;
import com.shopper.productos.Congelado;
import com.shopper.productos.Fresco;
import com.shopper.productos.Higiene;

public class supermercado {
    public static void main(String[] args) {
        int opcion;
        do{
            opcion = PedirDatos.pedirEntero("***MENU*** \n\n 1---> Crear Pedido \n 2---> Crear contenedor  \n 3---> Añadir contenedor al pedido \n\n Teclea una opcion de las anteriores");
            switch (opcion) {
                case 1:
                    IPedido miPedido = new Pedido(PedirDatos.pedirDatos("Escribe la referencia del pedido: "));
                    break;

                case 2:
                    IContenedor bolsa1 = new Bolsa("B111", 40, 25,900);
                    IContenedor caja1 = new Caja("C222", 30, 50, 75);
                    break;
                case 3:
                    miPedido.addContenedor(bolsa1);
                    miPedido.addContenedor(caja1);

                default:
                    break;
            }
        }while (opcion<=);





        System.out.println("Bolsa: "+bolsa1);
        System.out.println("Caja: "+caja1);
        System.out.println("Mi pedido con contenedores: "+miPedido);

        IProducto manzanas = new Fresco("MNZ", 1000, 1500);
        IProducto helado = new Congelado("HLD", 800, 1000);
        IProducto papelWC = new Higiene("PWC", 500, 2500);
        IProducto peras = new Fresco("PER", 800, 1200);

        IContenedor contManzanas = miPedido.addProducto(manzanas);
        IContenedor contHelado = miPedido.addProducto(helado);
        IContenedor contPapel = miPedido.addProducto(papelWC);
        IContenedor contPeras = miPedido.addProducto(peras);
        System.out.println("Mi pedido con productos: "+miPedido);

    }
}