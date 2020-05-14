package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.listview.accesoDatos.ModelData;
import com.example.listview.logicaDeNagocio.Mascota;
import com.example.listview.logicaDeNagocio.Propietario;

import java.util.ArrayList;

public class FormularioAddAnimal extends AppCompatActivity {

    public EditText etNombre;
    public EditText etTelefono;
    public Spinner spTipoMascota;
    public Spinner spGenero;
    public EditText etNombreMascota;
    public Button btnAgregarMascota;
    public ModelData md;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_add_animal);

        etNombre = findViewById(R.id.etNombre);
        etTelefono = findViewById(R.id.etTelefono);
        etNombreMascota = findViewById(R.id.etNombreMascota);
        spTipoMascota = findViewById(R.id.sTipoMascota);
        spGenero = findViewById(R.id.sGenero);
        btnAgregarMascota = findViewById(R.id.btnAgregarMascota);

        ArrayList<String> tipoMascota = new ArrayList<>();
        tipoMascota.add("Perro");
        tipoMascota.add("Gato");
        tipoMascota.add("Conejo");
        ArrayAdapter<String> adaptadorTM = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, tipoMascota);
        spTipoMascota.setAdapter(adaptadorTM);

        ArrayList<String> generos = new ArrayList<>();
        generos.add("Macho");
        generos.add("Hembra");
        ArrayAdapter<String> adaptadorC = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, generos);
        spGenero.setAdapter(adaptadorC);

        btnAgregarMascota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AgregaMascota();
            }
        });

    }

    public boolean validate(){
        boolean valido = false;
        int error = 0;
        if(etNombre.getText().toString().isEmpty()){
            etNombre.setError("Debe ingresar un nombre");
            error++;
        }
        if(error>0){
            Toast.makeText(this,"Algunos errores",Toast.LENGTH_LONG).show();
            valido = false;
        }else {
            valido = true;
        }
        return valido;
    }

    public void AgregaMascota(){
        if(validate()){
            md = ModelData.getInstance();
            Mascota miMascota = new Mascota();
            Propietario miPropietario = new Propietario();

            //Carga de datos
            miPropietario.setNombrePropietario(etNombre.getText().toString());
            miPropietario.setNumero(etTelefono.getText().toString());

            miMascota.setNombre(etNombreMascota.getText().toString());
            miMascota.setGenero(spGenero.getSelectedItem().toString());
            miMascota.setTipoMascota(spTipoMascota.getSelectedItem().toString());
            miMascota.setPropietario(miPropietario);
            md.getListMascotas().add(miMascota);

            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
            Toast.makeText(this,"Animal agregado a lista de adopción!", Toast.LENGTH_LONG).show();
            finish();
        }
    }
}
