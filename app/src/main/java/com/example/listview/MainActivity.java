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
    public String mTitle[] = {"Facebook","Whatsapp","Twitter","Instagram","Youtube"};
    public String mDescription[] = {"Facebook description","Whatsapp description","Twitter description","Instagram description","Youtube description"};
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
        spec = tabHost.newTabSpec("Tab Three");
        spec.setContent(R.id.tab3);
        spec.setIndicator("Tab Three");
        tabHost.addTab(spec);

        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                // display the name of the tab whenever a tab is changed
                Toast.makeText(getApplicationContext(), tabId, Toast.LENGTH_SHORT).show();
            }
        });

        listView = findViewById(R.id.listView);
        //now create an adapter class

        MyAdapter adapter =  new MyAdapter(this,mTitle,mDescription,images);
        listView.setAdapter(adapter);

        //now set item click on list row
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Toast.makeText(MainActivity.this,"Facebook Description",Toast.LENGTH_LONG).show();
                }
                if(position == 1){
                    Toast.makeText(MainActivity.this,"Whatsapp Description",Toast.LENGTH_LONG).show();
                }
                if(position == 2){
                    Toast.makeText(MainActivity.this,"Twitter Description",Toast.LENGTH_LONG).show();
                }
                if(position == 3){
                    Toast.makeText(MainActivity.this,"Instagram Description",Toast.LENGTH_LONG).show();
                }
                if(position == 4){
                    Toast.makeText(MainActivity.this,"Youtube Description",Toast.LENGTH_LONG).show();
                }
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
