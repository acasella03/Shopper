package com.shopper;

import com.angi.datos.PedirDatos;
import com.shopper.contenedores.Bolsa;
import com.shopper.contenedores.Caja;
import com.shopper.contenedores.FactoryContenedor;
import com.shopper.productos.*;

public class supermercado {
    public static final String REF = "Escribe referencia:";
    public static final String GR = "Indica el peso en gramos:";
    public static final String VOL = "Indica el volumen(cm3):";
    public static final String PREGUNTA1 = "¿Necesitas más contenedores? Indica S/N";
    public static final String PREGUNTA2 = "¿Tienes más productos? Indica S/N";

    public static void main(String[] args) {
        IPedido miPedido = null;
        IContenedor bolsa = null;
        IContenedor caja = null;
        IProducto pFresco = null;
        IProducto pCongelado = null;
        IProducto pNoPerecedero = null;
        IProducto drogueria = null;
        IProducto mascotas = null;
        IProducto higiene = null;

        int opcion;
        do {
            opcion = PedirDatos.pedirEntero("***MENU*** \n\n 1---> Crear Pedido \n 2---> Crear contenedor \n3--->Crear productos \n4--->Mostrar contenedor \n5--->Mostrar pedido \n6--->Salir \n\n Teclea una opcion de las anteriores");
            switch (opcion) {
                case 1:
                    miPedido = new Pedido(PedirDatos.pedirDatos("Escribe la referencia del pedido: "));
                    break;

                case 2:
                    do{
                        bolsa = FactoryContenedor.getContenedor(FactoryContenedor.BOLSA);
                        caja = FactoryContenedor.getContenedor(FactoryContenedor.CAJA);
                        miPedido.addContenedor(bolsa);
                        miPedido.addContenedor(caja);
                    }while (PedirDatos.pedirDatos(PREGUNTA1).equalsIgnoreCase("s"));
                    break;

                case 3:
                    do {
                        String f = PedirDatos.pedirDatos("¿Tienes alimentos frescos? Indica S/N");
                        if (f.equalsIgnoreCase("s")) {
                            pFresco = FactoryProductos.getProducto(FactoryProductos.FRESCOS);
                        }
                        String c = PedirDatos.pedirDatos("¿Tienes alimentos congelados? Indica S/N");
                        if (c.equalsIgnoreCase("s")) {
                            pCongelado = FactoryProductos.getProducto(FactoryProductos.CONGELADOS);
                        }
                        String nP = PedirDatos.pedirDatos("¿Tienes alimentos no perecederos? Indica S/N:");
                        if (nP.equalsIgnoreCase("s")) {
                            pNoPerecedero = FactoryProductos.getProducto(FactoryProductos.NOPERECEDEROS);
                        }
                        String d = PedirDatos.pedirDatos("¿Tienes productos de droguería? Indica S/N");
                        if (d.equalsIgnoreCase("s")) {
                            drogueria = FactoryProductos.getProducto(FactoryProductos.DROGUERIA);
                        }
                        String m = PedirDatos.pedirDatos("¿Tienes productos para mascotas? Indica S/N");
                        if (m.equalsIgnoreCase("s")) {
                            mascotas = FactoryProductos.getProducto(FactoryProductos.MASCOTA);
                        }
                        String h = PedirDatos.pedirDatos("¿Tienes productos de higiene? Indica S/N");
                        if (h.equalsIgnoreCase("s")) {
                            higiene = FactoryProductos.getProducto(FactoryProductos.HIGIENE);
                        }
                    } while (PedirDatos.pedirDatos(PREGUNTA2).equalsIgnoreCase("s"));

                case 4:
                    IContenedor contManzanas = miPedido.addProducto(pFresco);
                    IContenedor contHelado = miPedido.addProducto(pCongelado);
                    IContenedor contPapel = miPedido.addProducto(higiene);
                    IContenedor contPeras = miPedido.addProducto(pFresco);
                case 5:
                    System.out.println("Mi pedido con productos: " + miPedido);
                default:
                    break;
            }
        } while (opcion <= 5);

    }
}