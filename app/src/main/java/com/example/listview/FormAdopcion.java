package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.listview.logicaDeNagocio.Mascota;

public class FormAdopcion extends AppCompatActivity {

    public Mascota miMascota;
    public TextView tvPetName,tvInfoPropietario;
    public ImageView ivTipoAnimal;
    public ImageView ivGender;
    public EditText etNombreAdopt,etTelefonoAdopt;
    public Button btnEnviaSol;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_adopcion);

        //Se hace mapeos de componentes views del layout
        tvPetName = findViewById(R.id.tvPetName);
        ivTipoAnimal = findViewById(R.id.ivTipoAnimal);
        ivGender = findViewById(R.id.ivGender);
        etNombreAdopt = findViewById(R.id.etNombreAdopt);
        etTelefonoAdopt = findViewById(R.id.etTelefonoAdopt);
        btnEnviaSol = findViewById(R.id.btnEnviarSolicitud);
        tvInfoPropietario = findViewById(R.id.tvInfoPropietario);


        miMascota = (Mascota) getIntent().getSerializableExtra("masAdoptar");
        tvPetName.setText("Nombre: "+miMascota.getNombre());

        //Se cargan los datos
        if(miMascota.getTipoMascota().equals("Perro")){
            ivTipoAnimal.setImageResource(R.drawable.mascota);
        }else if(miMascota.getTipoMascota().equals("Gato")){
            ivTipoAnimal.setImageResource(R.drawable.gato);
        }else if(miMascota.getTipoMascota().equals("Conejo")){
            ivTipoAnimal.setImageResource(R.drawable.rabbit);
        }

        if(miMascota.getGenero().equals("Macho")){
            ivGender.setImageResource(R.drawable.macho);
        }else{
            ivGender.setImageResource(R.drawable.hembra);
        }

        tvInfoPropietario.setText("Contacto propietario \n"+
                "Nombre: " + miMascota.getPropietario().getNombrePropietario() + "\n"+
                "Telefono: " + miMascota.getPropietario().getNumero());

        //Aca se prepara el popup
        DisplayMetrics medidasVentana = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(medidasVentana);

        int ancho = medidasVentana.widthPixels;
        int alto = medidasVentana.heightPixels;

        getWindow().setLayout((int) (ancho * 0.90), (int) (alto * 0.65));
    }
}
