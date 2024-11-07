package com.example.ejercicio1tema6paisesycapitales;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  // El layout principal

        ListView listado = findViewById(R.id.listado);

        // Datos de ejemplo: países y capitales
        Datos[] datos = new Datos[] {
                new Datos("España", "Madrid"),
                new Datos("Francia", "París"),
                new Datos("Venezuela", "Caracas"),
                new Datos("Alemania", "Berlín"),
                new Datos("Irlanda", "Dublín"),
                new Datos("Noruega", "Oslo"),
                new Datos("Italia", "Roma"),
                new Datos("Argentina", "Buenos Aires"),
                new Datos("Canadá", "Ottawa"),
                new Datos("Portugal", "Lisboa")
        };

        

        // Configurar el adaptador
        Adaptador adaptador = new Adaptador(this, datos);
        listado.setAdapter(adaptador);

        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                // Cuando un elemento es seleccionado
                Datos seleccionado = (Datos) adaptador.getItem(position);
                String pais = seleccionado.getTexto1();
                String capital = seleccionado.getTexto2();
                Toast.makeText(MainActivity.this, "Pais: "+ pais + "  Capital - " + capital, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
