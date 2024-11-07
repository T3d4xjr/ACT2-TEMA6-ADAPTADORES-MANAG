package com.example.actividad2adaptadorestiendamusica;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class InstrumentAdapter extends ArrayAdapter<Instrument> {

    private Context context;
    private List<Instrument> instrumentList;

    public InstrumentAdapter(Context context, List<Instrument> instrumentList) {
        super(context, R.layout.item_instrument, instrumentList);
        this.context = context;
        this.instrumentList = instrumentList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Inflar el diseño de cada item
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_instrument, parent, false);
        }

        // Obtener el instrumento en la posición actual
        Instrument currentInstrument = instrumentList.get(position);

        // Asignar la imagen del instrumento
        ImageView instrumentImage = convertView.findViewById(R.id.instrumentImage);
        instrumentImage.setImageResource(currentInstrument.getImageResourceId());

        // Asignar el nombre del instrumento
        TextView instrumentName = convertView.findViewById(R.id.instrumentName);
        instrumentName.setText(currentInstrument.getName());

        // Asignar el precio del instrumento
        TextView instrumentPrice = convertView.findViewById(R.id.instrumentPrice);
        instrumentPrice.setText(currentInstrument.getPrice());

        // Configurar el botón para agregar al carrito
        Button addToCartButton = convertView.findViewById(R.id.addToCartButton);
        addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aquí puedes añadir la lógica para agregar al carrito
                // Por ejemplo, mostrar un mensaje cuando se presiona el botón
                Toast.makeText(context, currentInstrument.getName() + " añadido al carrito", Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }
}
