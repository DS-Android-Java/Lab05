package com.example.listview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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
import android.widget.TextView;
import android.widget.Toast;

import com.example.listview.accesoDatos.ModelData;
import com.example.listview.logicaDeNagocio.Mascota;
import com.example.listview.logicaDeNagocio.Propietario;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ListView listView;
    public String mTitle[] = {"Facebook","Whatsapp","Twitter","Instagram","Youtube"};
    public String mDescription[] = {"Facebook description","Whatsapp description","Twitter description","Instagram description","Youtube description"};
    int images[] = {R.drawable.facebook,R.drawable.wa,R.drawable.twitter,R.drawable.insta,R.drawable.youtube};
    public TabHost tabHost;

    public ListView listViewAnimals;
    //public String mPName[] = {"Skuichi","Luna","Marcelo","Minina","Ninito"};
    public ArrayList<String> mPName = new ArrayList<>();
    int imagesP[] = {R.drawable.rabbit,R.drawable.mascota,R.drawable.gato,R.drawable.gatito,R.drawable.gatito};
    int imagesPG[] = {R.drawable.macho,R.drawable.hembra};

    public ArrayList<Mascota> mascotas;
    public ModelData md;
    public Button btnAgregarMascota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        md = ModelData.getInstance();
        mascotas = (ArrayList<Mascota>) md.getListMascotas();

        tabHost = findViewById(R.id.tabHost);
        tabHost.setup();

        //tab1
        TabHost.TabSpec spec = tabHost.newTabSpec("Mascotas");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Mascotas");
        tabHost.addTab(spec);

        //tab2
        spec = tabHost.newTabSpec("Tab Two");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Tab Two");
        tabHost.addTab(spec);

        //tab3
        spec = tabHost.newTabSpec("Tab Three");
        spec.setContent(R.id.tab3);
        spec.setIndicator("Tab Three");
        tabHost.addTab(spec);

        btnAgregarMascota = findViewById(R.id.btnAgregarMascota);
        listView = findViewById(R.id.listView);
        listViewAnimals = findViewById(R.id.listViewAnimals);
        //now create an adapter class

        MyAdapter adapter =  new MyAdapter(this,mTitle,mDescription,images);
        listView.setAdapter(adapter);

        for(Mascota m : mascotas){
            mPName.add(m.getNombre());
        }
        MyAdapterPet adapterPet = new MyAdapterPet(this,mPName,imagesP,imagesPG,mascotas);
        listViewAnimals.setAdapter(adapterPet);

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

        listViewAnimals.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Mascota mAdoptar = new Mascota();
                mAdoptar = mascotas.get(position);
                IrAdoptar(mAdoptar);
            }
        });

        btnAgregarMascota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IrAgregarAnimal();
            }
        });
    }

    public void IrAdoptar(Mascota mascotaAdoptar){
        Intent i = new Intent(this, FormAdopcion.class);
        i.putExtra("masAdoptar",mascotaAdoptar);
        startActivity(i);
    }

    public void IrAgregarAnimal(){
        Intent i = new Intent(this,FormularioAddAnimal.class);
        startActivity(i);
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

    class MyAdapterPet extends ArrayAdapter<String>{

        Context context;
        ArrayList<String> tvNP;
        int imaP[];
        int imaPG[];
        ArrayList<Mascota> mascotas;

        MyAdapterPet(Context context, ArrayList<String> tvNP,int imaP[],int imaPG[], ArrayList<Mascota> mascotas){
            super(context,R.layout.row_animal, R.id.tvNameP, tvNP);
            this.context = context;
            this.tvNP = tvNP;
            this.imaP = imaP;
            this.imaPG = imaPG;
            this.mascotas = mascotas;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater layoutInflater =
                    (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View row2 = layoutInflater.inflate(R.layout.row_animal,parent, false);
            ImageView imaPet = row2.findViewById(R.id.imagenPet);
            TextView myPN = row2.findViewById(R.id.tvNameP);
            TextView myPO = row2.findViewById(R.id.contactOwner);
            ImageView imaPGender = row2.findViewById(R.id.imagenGender);

            //now set our resources on views
            if(mascotas.get(position).getTipoMascota().equals("Perro")){
                imaPet.setImageResource(imaP[1]);
            }else if(mascotas.get(position).getTipoMascota().equals("Gato")){
                imaPet.setImageResource(imaP[2]);
            }else if(mascotas.get(position).getTipoMascota().equals("Conejo")){
                imaPet.setImageResource(imaP[0]);
            }

            myPN.setText(mascotas.get(position).getNombre());
            myPO.setText("Dueño: "+mascotas.get(position).getPropietario().getNombrePropietario()+" Telefono: " + mascotas.get(position).getPropietario().getNumero());
            if(mascotas.get(position).getGenero().equals("Macho")){
                imaPGender.setImageResource(imaPG[0]);
            }else if(mascotas.get(position).getGenero().equals("Hembra")){
                imaPGender.setImageResource(imaPG[1]);
            }

            return row2;
        }
    }
}
