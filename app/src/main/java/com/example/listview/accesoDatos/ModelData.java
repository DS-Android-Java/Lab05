package com.example.listview.accesoDatos;

import com.example.listview.logicaDeNagocio.Mascota;
import com.example.listview.logicaDeNagocio.Propietario;
import com.example.listview.logicaDeNagocio.SolicitudAdopcion;

import java.util.ArrayList;
import java.util.List;

public class ModelData {

    private List<Propietario> listPropietarios;
    private  List<Mascota> listMascotas;
    private List<SolicitudAdopcion> listSolicitudMascotasAdopt;

    private static ModelData modelData;

    public static ModelData getInstance(){
        if(modelData == null){
            modelData = new ModelData();
        }
        return modelData;
    }

    public ModelData() {
        listPropietarios = InitPropietarios();
        listMascotas = InitMascotas();
        listSolicitudMascotasAdopt = InitMascotasAdopt();
    }

    public List<Propietario> InitPropietarios(){
        List<Propietario> propietarios = new ArrayList<>();
        propietarios.add(new Propietario("Diego", "87390479"));
        propietarios.add(new Propietario("Allison", "6352728"));
        propietarios.add(new Propietario("Nicol", "62404885"));
        return propietarios;
    }


    public List<Mascota> InitMascotas(){
        List<Mascota> mascotas = new ArrayList<>();
        mascotas.add(new Mascota("Skuichi", "Macho","Conejo",listPropietarios.get(0)));
        mascotas.add(new Mascota("Luna", "Hembra","Perro",listPropietarios.get(1)));
        mascotas.add(new Mascota("Marcelo", "Macho","Gato",listPropietarios.get(0)));
        mascotas.add(new Mascota("Minina", "Hembra","Gato",listPropietarios.get(2)));
        mascotas.add(new Mascota("Ninito", "Macho","Gato",listPropietarios.get(2)));
        return mascotas;
    }

    public List<SolicitudAdopcion> InitMascotasAdopt(){
        List<SolicitudAdopcion> solicitudAdopcionList = new ArrayList<>();
        solicitudAdopcionList.add(new SolicitudAdopcion(new Mascota("Rambo", "Macho","Conejo",listPropietarios.get(0))
                , new Propietario("Eloy Perez","12345678")));

        solicitudAdopcionList.add(new SolicitudAdopcion(new Mascota("Rocky", "Macho","Perro",listPropietarios.get(1))
                , new Propietario("Juanito Perez","87654321")));
        solicitudAdopcionList.add(new SolicitudAdopcion(new Mascota("Pelusa", "Macho","Gato",listPropietarios.get(0))
                , new Propietario("Daniel Paniagua","62134654")));
        solicitudAdopcionList.add(new SolicitudAdopcion(new Mascota("Toby", "Hembra","Perro",listPropietarios.get(2))
                , new Propietario("Kattia Cruz","71123445")));
        solicitudAdopcionList.add(new SolicitudAdopcion(new Mascota("Tom", "Macho","Gato",listPropietarios.get(2))
                , new Propietario("Gabriel Ramirez","83224333")));
        return solicitudAdopcionList;
    }


    public List<Propietario> getListPropietarios() {
        return listPropietarios;
    }

    public void setListPropietarios(List<Propietario> listPropietarios) {
        this.listPropietarios = listPropietarios;
    }

    public List<Mascota> getListMascotas() {
        return listMascotas;
    }

    public void setListMascotas(List<Mascota> listMascotas) {
        this.listMascotas = listMascotas;
    }

    public List<SolicitudAdopcion> getListSolicitudMascotasAdopt() {
        return listSolicitudMascotasAdopt;
    }

    public void setListSolicitudMascotasAdopt(List<SolicitudAdopcion> listSolicitudMascotasAdopt) {
        this.listSolicitudMascotasAdopt = listSolicitudMascotasAdopt;
    }
}
