package com.example.listview.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.listview.R;
import com.example.listview.logicaDeNagocio.Mascota;

import java.util.ArrayList;

public class MyAdapterPet extends ArrayAdapter<String> {

    Context context;
    ArrayList<String> tvNP;
    int imaP[];
    int imaPG[];
    ArrayList<Mascota> mascotas;

    public MyAdapterPet(Context context, ArrayList<String> tvNP,int imaP[],int imaPG[], ArrayList<Mascota> mascotas){
        super(context, R.layout.row_animal, R.id.tvNameP, tvNP);
        this.context = context;
        this.tvNP = tvNP;
        this.imaP = imaP;
        this.imaPG = imaPG;
        this.mascotas = mascotas;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

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
        myPO.setText("Dueño: "+mascotas.get(position).getPropietario().getNombrePropietario()+" Teléfono: " + mascotas.get(position).getPropietario().getNumero());
        if(mascotas.get(position).getGenero().equals("Macho")){
            imaPGender.setImageResource(imaPG[0]);
        }else if(mascotas.get(position).getGenero().equals("Hembra")){
            imaPGender.setImageResource(imaPG[1]);
        }

        return row2;
    }
}
