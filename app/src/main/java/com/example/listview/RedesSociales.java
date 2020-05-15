 package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import com.example.listview.adaptadores.MyAdapterRedesSociales;

 public class RedesSociales extends AppCompatActivity {

    GridView gridView;
    String [] values ={
            "Facebook",
            "Twitter",
            "Instagram",
            "Youtube"
    };
    int mg [] ={
            R.drawable.facebook,
            R.drawable.twitter,
            R.drawable.insta,
            R.drawable.youtube
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redes_sociales);


        gridView = (GridView) findViewById(R.id.contenedorR);
        MyAdapterRedesSociales myAdapterRedesSociales = new MyAdapterRedesSociales(this, values,mg);
        gridView.setAdapter(myAdapterRedesSociales);

    }
}
