package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.listview.accesoDatos.ModelData;
import com.example.listview.logicaDeNagocio.Mascota;
import com.example.listview.logicaDeNagocio.SolicitudAdopcion;

public class ListSolicitudAdopcion extends AppCompatActivity {

    public SolicitudAdopcion miMascota;
    public TextView tvPetName, tvInfoPropietario, tvInfoSolicitante;
    public ImageView ivTipoAnimal;
    public ImageView ivGender;
    public ModelData md;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_solicitud_adopcion);

        //Se hace mapeos de componentes views del layout
        tvPetName = findViewById(R.id.tvPetNameS);
        ivTipoAnimal = findViewById(R.id.ivTipoAnimal);
        ivGender = findViewById(R.id.ivGenderS);
        tvInfoPropietario = findViewById(R.id.tvInfoPropietarioS);
        tvInfoSolicitante = findViewById(R.id.tvInfoSolicitante);
        md = ModelData.getInstance();

        miMascota = (SolicitudAdopcion) getIntent().getSerializableExtra("masAdoptar");
        tvPetName.setText("Nombre: " + miMascota.getMascotaAdoptar().getNombre());

        //Se cargan los datos
        if (miMascota.getMascotaAdoptar().getTipoMascota().equals("Perro")) {
            ivTipoAnimal.setImageResource(R.drawable.mascota);
        } else if (miMascota.getMascotaAdoptar().getTipoMascota().equals("Gato")) {
            ivTipoAnimal.setImageResource(R.drawable.gato);
        } else if (miMascota.getMascotaAdoptar().getTipoMascota().equals("Conejo")) {
            ivTipoAnimal.setImageResource(R.drawable.rabbit);
        }

        if (miMascota.getMascotaAdoptar().getGenero().equals("Macho")) {
            ivGender.setImageResource(R.drawable.macho);
        } else {
            ivGender.setImageResource(R.drawable.hembra);
        }

        tvInfoPropietario.setText("Contacto del Propietario \n" +
                "Nombre: " + miMascota.getMascotaAdoptar().getPropietario().getNombrePropietario() + "\n" +
                "Teléfono: " + miMascota.getMascotaAdoptar().getPropietario().getNumero());

        tvInfoSolicitante.setText("Nombre del Solicitante: " + miMascota.getNuevoPropietarioSolicitante().getNombrePropietario() + "\n" +
                "Teléfono: " + miMascota.getNuevoPropietarioSolicitante().getNumero());


        //Aca se prepara el popup
        DisplayMetrics medidasVentana = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(medidasVentana);

        int ancho = medidasVentana.widthPixels;
        int alto = medidasVentana.heightPixels;

        getWindow().setLayout((int) (ancho * 0.90), (int) (alto * 0.40));
    }
}
