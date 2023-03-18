package com.shopper.productos;

import com.angi.datos.PedirDatos;
import com.shopper.IProducto;
import com.shopper.contenedores.Bolsa;
import com.shopper.contenedores.Caja;

public class FactoryProductos {
    public static final int FRESCOS = 1;
    public static final int CONGELADOS = 2;
    public static final int NOPERECEDEROS = 3;
    public static final int DROGUERIA = 4;
    public static final int HIGIENE = 5;
    public static final int MASCOTA = 6;

    public static IProducto getProducto(int tipoProducto) {
        switch (tipoProducto) {
            case FRESCOS:
                return new Fresco(PedirDatos.pedirDatos("Escribe referencia del producto fresco:"), PedirDatos.pedirEntero("Escribe el peso total del producto fresco:"), PedirDatos.pedirEntero("Escribe el volumen(cm3) del producto fresco:"));
            case CONGELADOS:
                return new Congelado(PedirDatos.pedirDatos("Escribe referencia del producto fresco:"), PedirDatos.pedirEntero("Escribe el peso total del producto fresco:"), PedirDatos.pedirEntero("Escribe el volumen(cm3) del producto fresco:"));
            case NOPERECEDEROS:
                return new NoPerecedero(PedirDatos.pedirDatos("Escribe referencia del producto fresco:"), PedirDatos.pedirEntero("Escribe el peso total del producto fresco:"), PedirDatos.pedirEntero("Escribe el volumen(cm3) del producto fresco:"));
            case DROGUERIA:
                return new Drogueria(PedirDatos.pedirDatos("Escribe referencia del producto fresco:"), PedirDatos.pedirEntero("Escribe el peso total del producto fresco:"), PedirDatos.pedirEntero("Escribe el volumen(cm3) del producto fresco:"));
            case HIGIENE:
                return new Higiene(PedirDatos.pedirDatos("Escribe referencia del producto fresco:"), PedirDatos.pedirEntero("Escribe el peso total del producto fresco:"), PedirDatos.pedirEntero("Escribe el volumen(cm3) del producto fresco:"));
            case MASCOTA:
                return new Mascotas(PedirDatos.pedirDatos("Escribe referencia del producto fresco:"), PedirDatos.pedirEntero("Escribe el peso total del producto fresco:"), PedirDatos.pedirEntero("Escribe el volumen(cm3) del producto fresco:"));
            default:
                return null;
        }
    }
}
