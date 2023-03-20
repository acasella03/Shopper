package com.shopper.contenedores;

import com.angi.datos.PedirDatos;
import com.shopper.IContenedor;

public class FactoryContenedor {
    public static final int BOLSA = 1;
    public static final int CAJA = 2;

    public static IContenedor getContenedor(int tipoContedor) {
        switch (tipoContedor) {
            case BOLSA:
                return new Bolsa(PedirDatos.pedirDatos("Escribe la referencia de la bolsa:\n(Una letra y tres números)"), PedirDatos.pedirEntero("Escribe la altura de la bolsa(cm):"), PedirDatos.pedirEntero("Escribe el ancho de la bolsa(cm):"), PedirDatos.pedirEntero("Escribe la resistencia de la bolsa(gr):"));
            case CAJA:
                return new Caja(PedirDatos.pedirDatos("Escribe la referencia de la caja:\n(Una letra y tres números)"), PedirDatos.pedirEntero("Escribe la altura de la caja(cm):"), PedirDatos.pedirEntero("Escribe el ancho de la caja(cm):"), PedirDatos.pedirEntero("Escribe el largo de la caja(cm):"));
            default:
                return null;
        }
    }
}
