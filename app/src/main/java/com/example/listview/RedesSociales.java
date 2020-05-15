 package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.listview.adaptadores.MyAdapterRedesSociales;

 public class RedesSociales extends AppCompatActivity {

    GridView gridView;
    String [] values ={
            "Facebook",
            "Twitter",
            "Instagram",
            "Youtube",
            "Whatsapp"
    };
    int mg [] ={
            R.drawable.facebook,
            R.drawable.twitter,
            R.drawable.insta,
            R.drawable.youtube,
            R.drawable.wa
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redes_sociales);


        gridView = (GridView) findViewById(R.id.contenedorR);
        MyAdapterRedesSociales myAdapterRedesSociales = new MyAdapterRedesSociales(this, values,mg);
        gridView.setAdapter(myAdapterRedesSociales);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                redSocial(position);
            }
        });

    }

    private void redSocial(int position){
        if(position==0){
            Toast.makeText(this,"https://www.facebook.com/territoriodezaguates/",Toast.LENGTH_LONG).show();
        }
        else if(position == 1){
            Toast.makeText(this,"https://twitter.com/terrizaguates",Toast.LENGTH_LONG).show();
        }
        else if(position == 2){
            Toast.makeText(this,"https://www.instagram.com/territorio_de_zaguates/?hl=es-la",Toast.LENGTH_LONG).show();
        }
        else if(position ==3){
            Toast.makeText(this,"https://www.youtube.com/channel/UCvHc3BIZdnloZ9gVDv7fX2g",Toast.LENGTH_LONG).show();
        }
        else  if(position==4){
            Toast.makeText(this,"https://info.territoriodezaguates.com/info/adopciones/",Toast.LENGTH_LONG).show();
        }
    }
}
