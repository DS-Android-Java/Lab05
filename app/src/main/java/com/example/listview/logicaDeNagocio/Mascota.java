package com.example.listview.logicaDeNagocio;

public class Mascota {

    private String nombre;
    private String genero;
    private String tipoMascota;
    private Propietario propietario;

    public Mascota() {
    }

    public Mascota(String nombre, String genero,String tipoMascota, Propietario propietario) {
        this.nombre = nombre;
        this.genero = genero;
        this.tipoMascota = tipoMascota;
        this.propietario = propietario;
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

    @Override
    public String toString() {
        return "Mascota{" +
                "nombre='" + nombre + '\'' +
                ", genero='" + genero + '\'' +
                ", propietario=" + propietario +
                '}';
    }
}
