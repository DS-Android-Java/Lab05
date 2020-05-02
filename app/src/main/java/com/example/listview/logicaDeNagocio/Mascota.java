package com.example.listview.logicaDeNagocio;

import java.io.Serializable;

public class Mascota implements Serializable {

    private String nombre;
    private String genero;
    private String tipoMascota;
    private Propietario propietario;
    private Propietario nuevoPropietario;

    public Mascota() {
    }

    public Mascota(String nombre, String genero,String tipoMascota, Propietario propietario, Propietario nuevoPropietario) {
        this.nombre = nombre;
        this.genero = genero;
        this.tipoMascota = tipoMascota;
        this.propietario = propietario;
        this.nuevoPropietario = nuevoPropietario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTipoMascota() {
        return tipoMascota;
    }

    public void setTipoMascota(String tipoMascota) {
        this.tipoMascota = tipoMascota;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public Propietario getNuevoPropietario() {
        return nuevoPropietario;
    }

    public void setNuevoPropietario(Propietario nuevoPropietario) {
        this.nuevoPropietario = nuevoPropietario;
    }

    @Override
    public String toString() {
        return "Mascota{" +
                "nombre='" + nombre + '\'' +
                ", genero='" + genero + '\'' +
                ", propietario=" + propietario +
                '}';
    }
}
