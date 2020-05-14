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

public class MyAdapterAdopPet extends ArrayAdapter<String> {
    Context context;
    ArrayList<String> tvNPA;
    int imaPA[];
    int imaPGA[];
    ArrayList<Mascota> mascotaA;

    public MyAdapterAdopPet(Context context, ArrayList<String> tvNPA, int[] imaPA, int[] imaPGA, ArrayList<Mascota> mascotaA) {
        super(context, R.layout.row_animal_adop, R.id.tvNamePA, tvNPA);
        this.context = context;
        this.tvNPA = tvNPA;
        this.imaPA = imaPA;
        this.imaPGA = imaPGA;
        this.mascotaA = mascotaA;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View row2 = layoutInflater.inflate(R.layout.row_animal_adop,parent, false);
        ImageView imaPet = row2.findViewById(R.id.imagenPetA);
        TextView myPN = row2.findViewById(R.id.tvNamePA);
        TextView myPO = row2.findViewById(R.id.contactOwnerA);
        ImageView imaPGender = row2.findViewById(R.id.imagenGenderA);

        //now set our resources on views
        if(mascotaA.get(position).getTipoMascota().equals("Perro")){
            imaPet.setImageResource(imaPA[1]);
        }else if(mascotaA.get(position).getTipoMascota().equals("Gato")){
            imaPet.setImageResource(imaPA[2]);
        }else if(mascotaA.get(position).getTipoMascota().equals("Conejo")){
            imaPet.setImageResource(imaPA[0]);
        }

        myPN.setText(mascotaA.get(position).getNombre());
        myPO.setText("Postulante: "+mascotaA.get(position).getPropietario().getNombrePropietario()+" Teléfono: " + mascotaA.get(position).getPropietario().getNumero());
        if(mascotaA.get(position).getGenero().equals("Macho")){
            imaPGender.setImageResource(imaPGA[0]);
        }else if(mascotaA.get(position).getGenero().equals("Hembra")){
            imaPGender.setImageResource(imaPGA[1]);
        }

        return row2;
    }
}
