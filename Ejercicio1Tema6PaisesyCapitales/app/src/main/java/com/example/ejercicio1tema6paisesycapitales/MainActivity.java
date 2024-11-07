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

        // Limitamos a mostrar entre 4 y 5 elementos de la lista
        final int elementosAMostrar = 5;  // Aquí puedes cambiar a 4 si prefieres 4 elementos

        // Crear un array con los primeros 4 o 5 elementos
        Datos[] datosLimitados = new Datos[elementosAMostrar];
        System.arraycopy(datos, 0, datosLimitados, 0, elementosAMostrar);

        // Configurar el adaptador
        Adaptador adaptador = new Adaptador(this, datosLimitados);
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
