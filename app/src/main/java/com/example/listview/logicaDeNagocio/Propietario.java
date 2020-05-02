package com.example.listview.logicaDeNagocio;

import java.io.Serializable;

public class Propietario implements Serializable {

    private String nombrePropietario;
    private String numero;

    public Propietario() {
    }

    public Propietario(String nombrePropietario, String numero) {
        this.nombrePropietario = nombrePropietario;
        this.numero = numero;
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Propietario{" +
                "nombrePropietario='" + nombrePropietario + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }
}
