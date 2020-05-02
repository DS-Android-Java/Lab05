package com.example.listview.accesoDatos;

import com.example.listview.logicaDeNagocio.Mascota;
import com.example.listview.logicaDeNagocio.Propietario;

import java.util.ArrayList;
import java.util.List;

public class ModelData {

    private List<Propietario> listPropietarios;
    private  List<Mascota> listMascotas;

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
        Propietario miNuevoProp = new Propietario();
        mascotas.add(new Mascota("Skuichi", "Macho","Conejo",listPropietarios.get(0),miNuevoProp));
        mascotas.add(new Mascota("Luna", "Hembra","Perro",listPropietarios.get(1),miNuevoProp));
        mascotas.add(new Mascota("Marcelo", "Macho","Gato",listPropietarios.get(0),miNuevoProp));
        mascotas.add(new Mascota("Minina", "Hembra","Gato",listPropietarios.get(2),miNuevoProp));
        mascotas.add(new Mascota("Ninito", "Macho","Gato",listPropietarios.get(2),miNuevoProp));
        return mascotas;
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
}
