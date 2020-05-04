package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.listview.accesoDatos.ModelData;
import com.example.listview.adaptadores.MyAdapterPet;
import com.example.listview.logicaDeNagocio.Mascota;

import java.util.ArrayList;

public class AnimalList extends AppCompatActivity {

    public ListView listViewAnimals;
    public ArrayList<String> mPName = new ArrayList<>();
    int imagesP[] = {R.drawable.rabbit,R.drawable.mascota,R.drawable.gato,R.drawable.gatito,R.drawable.gatito};//Lista
    int imagesPG[] = {R.drawable.macho,R.drawable.hembra};
    public ArrayList<Mascota> mascotas;
    public ModelData md;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_list);

        //Se instancian mapea o llenan los elementos necesarios
        md = ModelData.getInstance();
        mascotas = (ArrayList<Mascota>) md.getListMascotas();
        listViewAnimals = findViewById(R.id.listViewAnimals);

        //Se carga la lista
        for(Mascota m : mascotas){
            mPName.add(m.getNombre());
        }
        MyAdapterPet adapterPet = new MyAdapterPet(this,mPName,imagesP,imagesPG,mascotas);
        listViewAnimals.setAdapter(adapterPet);

        listViewAnimals.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Mascota mAdoptar = new Mascota();
                mAdoptar = mascotas.get(position);
                IrAdoptar(mAdoptar);
            }
        });

    }

    public void IrAdoptar(Mascota mascotaAdoptar){//Funcion que redirecciona a formulario de adopcion
        Intent i = new Intent(this, FormAdopcion.class);
        i.putExtra("masAdoptar",mascotaAdoptar);
        startActivity(i);
    }
}
