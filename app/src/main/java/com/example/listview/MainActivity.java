package com.example.listview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.LocalActivityManager;
import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import android.widget.Toast;

import com.example.listview.accesoDatos.ModelData;
import com.example.listview.adaptadores.MyAdapterPet;
import com.example.listview.logicaDeNagocio.Mascota;
import com.example.listview.logicaDeNagocio.Propietario;

import java.util.ArrayList;

public class MainActivity extends TabActivity {

    public TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabHost = findViewById(android.R.id.tabhost);
        tabHost.setup();

        //tab1
        TabHost.TabSpec spec = tabHost.newTabSpec("Mascotas");
        Intent intentM = new Intent(this,AnimalList.class);
        spec.setContent(intentM);
        spec.setIndicator("",getResources().getDrawable(R.drawable.iconopet));
        tabHost.addTab(spec);

        //tab2
        spec = tabHost.newTabSpec("Agregar Mascota");
        Intent intent = new Intent(this, FormularioAddAnimal.class);
        spec.setContent(intent);
        spec.setIndicator("",getResources().getDrawable(R.drawable.agregarmas));
        tabHost.addTab(spec);

        //tab3
        spec = tabHost.newTabSpec("Solicitudes de Adopción");
        Intent intentA = new Intent(this, AnimalPorAdoptar.class);
        spec.setContent(intentA);
        spec.setIndicator("",getResources().getDrawable(R.drawable.solicadop));
        tabHost.addTab(spec);

        //tab4
        spec = tabHost.newTabSpec("Redes Sociales");
        Intent intent1 = new Intent(this, RedesSociales.class);
        spec.setContent(intent1);
        spec.setIndicator("",getResources().getDrawable(R.drawable.socialmedia));
        tabHost.addTab(spec);

        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                // display the name of the tab whenever a tab is changed
                Toast.makeText(getApplicationContext(), tabId, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
