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

    public ListView listView;
    int images[] = {R.drawable.facebook,R.drawable.wa,R.drawable.twitter,R.drawable.insta,R.drawable.youtube};
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
        spec.setIndicator("Agregar Mascota");
        tabHost.addTab(spec);

        //tab3
        spec = tabHost.newTabSpec("Solicitudes de Adopción");
        Intent intentA = new Intent(this, AnimalPorAdoptar.class);
        spec.setContent(intentA);
        spec.setIndicator("Solicitudes de Adopción");
        tabHost.addTab(spec);

        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                // display the name of the tab whenever a tab is changed
                Toast.makeText(getApplicationContext(), tabId, Toast.LENGTH_SHORT).show();
            }
        });

    }

    class MyAdapter extends ArrayAdapter<String>{

        Context context;
        String tvT[];
        String tvD[];
        int ima[];

        MyAdapter(Context context, String tvT[], String tvD[],int ima[]){
            super(context,R.layout.row, R.id.textView1, tvT);
            this.context = context;
            this.tvT = tvT;
            this.tvD = tvD;
            this.ima = ima;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater layoutInflater =
                    (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View row = layoutInflater.inflate(R.layout.row,parent, false);
            ImageView images = row.findViewById(R.id.imagen);
            TextView myTittle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textViewD);

            //now set our resources on views
            images.setImageResource(ima[position]);
            myTittle.setText(tvT[position]);
            myDescription.setText(tvD[position]);

            return row;
        }
    }
}
