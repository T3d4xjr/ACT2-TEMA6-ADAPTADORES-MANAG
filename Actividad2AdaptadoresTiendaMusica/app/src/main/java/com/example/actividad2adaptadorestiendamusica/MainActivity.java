package com.example.actividad2adaptadorestiendamusica;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Declaramos el ListView
    private ListView listViewInstruments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializamos el ListView
        listViewInstruments = findViewById(R.id.listView_instruments);

        // Creamos una lista de instrumentos
        ArrayList<Instrument> instrumentList = new ArrayList<>();
        instrumentList.add(new Instrument("Guitarra Acústica", "2.439 €", R.drawable.guitarraacustica));
        instrumentList.add(new Instrument("Batería", "1.999 €", R.drawable.bateria));
        instrumentList.add(new Instrument("Piano", "3.500 €", R.drawable.piano));
        instrumentList.add(new Instrument("Violín", "1.200 €", R.drawable.violin));

        // Creamos un adaptador para el ListView
        InstrumentAdapter adapter = new InstrumentAdapter(this, instrumentList);

        // Asignamos el adaptador al ListView
        listViewInstruments.setAdapter(adapter);

        // Configuramos un listener para cuando el usuario haga clic en un instrumento
        listViewInstruments.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parentView, View view, int position, long id) {
                Instrument selectedInstrument = instrumentList.get(position);
                // Mostrar un mensaje con el nombre del instrumento
                Toast.makeText(MainActivity.this, "Seleccionaste: " + selectedInstrument.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
