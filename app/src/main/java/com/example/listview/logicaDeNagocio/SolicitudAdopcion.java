package com.example.listview.logicaDeNagocio;

import java.io.Serializable;

public class SolicitudAdopcion implements Serializable {

    private Mascota mascotaAdoptar;
    private Propietario nuevoPropietarioSolicitante;

    public SolicitudAdopcion() {
    }

    public SolicitudAdopcion(Mascota mascotaAdoptar, Propietario nuevoPropietarioSolicitante) {
        this.mascotaAdoptar = mascotaAdoptar;
        this.nuevoPropietarioSolicitante = nuevoPropietarioSolicitante;
    }

    public Mascota getMascotaAdoptar() {
        return mascotaAdoptar;
    }

    public void setMascotaAdoptar(Mascota mascotaAdoptar) {
        this.mascotaAdoptar = mascotaAdoptar;
    }

    public Propietario getNuevoPropietarioSolicitante() {
        return nuevoPropietarioSolicitante;
    }

    public void setNuevoPropietarioSolicitante(Propietario nuevoPropietarioSolicitante) {
        this.nuevoPropietarioSolicitante = nuevoPropietarioSolicitante;
    }
}
