package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.listview.R;
import com.example.listview.accesoDatos.ModelData;
import com.example.listview.adaptadores.MyAdapterAdopPet;
import com.example.listview.logicaDeNagocio.Mascota;

import java.util.ArrayList;

public class AnimalPorAdoptar extends AppCompatActivity {


    public ListView listViewAnimalsAdop;
    public ArrayList<String> mPNameA = new ArrayList<>();
    int imagesP[] = {R.drawable.rabbit,R.drawable.mascota,R.drawable.gato,R.drawable.gatito,R.drawable.gatito};//Lista
    int imagesPG[] = {R.drawable.macho,R.drawable.hembra};
    public ArrayList<Mascota> mascotaA;
    public ModelData md;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_por_adoptar);

        md=ModelData.getInstance(); //instanceamos
        mascotaA = (ArrayList<Mascota>) md.getListMascotasAdopt();
        listViewAnimalsAdop = findViewById(R.id.listViewAnimalsXAdopt);


        for(Mascota mascota : mascotaA){
            mPNameA.add(mascota.getNombre());
        }
        MyAdapterAdopPet adapterAdopPet = new MyAdapterAdopPet(this,mPNameA,imagesP,imagesPG,mascotaA);
        listViewAnimalsAdop.setAdapter(adapterAdopPet);
    }
}
