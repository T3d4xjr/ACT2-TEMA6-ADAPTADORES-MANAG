package com.example.ejercicio1tema6paisesycapitales;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Ajustes de padding para bordes de sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ListView listado = findViewById(R.id.listado);

        // Inflar el TextView 'textoCabecera' y agregarlo como encabezado
        LayoutInflater inflater = getLayoutInflater();
        View textoCabecera = inflater.inflate(R.layout.activity_main, listado, false);
        listado.addHeaderView(textoCabecera);

        // Datos de ejemplo: países y capitales
        Datos[] datos = new Datos[] {
                new Datos("España", "Madrid"),
                new Datos("Francia", "París"),
                new Datos("Venezuela", "Caracas"),
                new Datos("Alemania","Berlin"),
                new Datos("Irlanda","Dublin"),
                new Datos("Noruega","Oslo"),
                new Datos("Italia","Roma"),
                new Datos("Argentina","Buenos Aires"),
                new Datos("Canadá","Ottawa"),
                new Datos("Portugal","Lisboa")

                // Agrega más datos si es necesario
        };

        // Configurar el adaptador
        Adaptador adaptador = new Adaptador(this, datos);
        listado.setAdapter(adaptador);


        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Datos seleccionado =(Datos) adaptador.getItem(position);

                String pais =seleccionado.getTexto1();
                String capital =seleccionado.getTexto2();
                Toast.makeText(MainActivity.this, "Seleccionado: " + pais + " - " + capital, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

