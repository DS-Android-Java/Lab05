package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.listview.accesoDatos.ModelData;
import com.example.listview.logicaDeNagocio.Mascota;
import com.example.listview.logicaDeNagocio.Propietario;
import com.example.listview.logicaDeNagocio.SolicitudAdopcion;

import java.util.ArrayList;

public class FormAdopcion extends AppCompatActivity {

    public Mascota miMascota;
    public TextView tvPetName, tvInfoPropietario;
    public ImageView ivTipoAnimal;
    public ImageView ivGender;
    public EditText etNombreAdopt, etTelefonoAdopt;
    public Button btnEnviaSol;
    public ModelData md;


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
        md = ModelData.getInstance();


        miMascota = (Mascota) getIntent().getSerializableExtra("masAdoptar");
        tvPetName.setText("Nombre: " + miMascota.getNombre());

        //Se cargan los datos
        if (miMascota.getTipoMascota().equals("Perro")) {
            ivTipoAnimal.setImageResource(R.drawable.mascota);
        } else if (miMascota.getTipoMascota().equals("Gato")) {
            ivTipoAnimal.setImageResource(R.drawable.gato);
        } else if (miMascota.getTipoMascota().equals("Conejo")) {
            ivTipoAnimal.setImageResource(R.drawable.rabbit);
        }

        if (miMascota.getGenero().equals("Macho")) {
            ivGender.setImageResource(R.drawable.macho);
        } else {
            ivGender.setImageResource(R.drawable.hembra);
        }

        tvInfoPropietario.setText("Contacto del Propietario \n" +
                "Nombre: " + miMascota.getPropietario().getNombrePropietario() + "\n" +
                "Teléfono: " + miMascota.getPropietario().getNumero());

        btnEnviaSol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SolicitudAdopcion();
            }
        });

        //Aca se prepara el popup
        DisplayMetrics medidasVentana = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(medidasVentana);

        int ancho = medidasVentana.widthPixels;
        int alto = medidasVentana.heightPixels;

        getWindow().setLayout((int) (ancho * 0.90), (int) (alto * 0.55));
    }

    private void SolicitudAdopcion() {
        Mascota miMascAdop = miMascota;
        SolicitudAdopcion miSolicitudAdop = new SolicitudAdopcion();

        if (validate()) {
            Propietario miNuevoProp = new Propietario();
            miNuevoProp.setNombrePropietario(etNombreAdopt.getText().toString());
            miNuevoProp.setNumero(etTelefonoAdopt.getText().toString());

            miSolicitudAdop.setMascotaAdoptar(miMascota);
            miSolicitudAdop.setNuevoPropietarioSolicitante(miNuevoProp);

            md.getListSolicitudMascotasAdopt().add(miSolicitudAdop);
            Log.d("cantidadMasA", "El tamanio de la lista es: " + md.getListSolicitudMascotasAdopt().size());
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
            Toast.makeText(this, "Solicitud de Adopción Enviada Correctamente!", Toast.LENGTH_LONG).show();
            finish();
        } else {
            Toast.makeText(this, "Debe rellenar los campos con sus datos!", Toast.LENGTH_LONG).show();
        }

    }

    public boolean validate() {
        boolean valido = true;
        int error=0;
        if (etNombreAdopt.getText().toString().equals("")) {
            etNombreAdopt.setError("Debe ingresar su nombre completo!");
            error++;
        }
        if(etTelefonoAdopt.getText().toString().equals("")){
            etTelefonoAdopt.setError("Debe ingresar su número de teléfono");
            error++;
        }
        if(error>0){
            valido=false;
        }

        return valido;
    }
}
