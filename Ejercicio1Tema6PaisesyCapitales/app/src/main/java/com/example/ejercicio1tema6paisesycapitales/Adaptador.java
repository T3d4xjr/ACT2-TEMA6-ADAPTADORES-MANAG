package com.example.ejercicio1tema6paisesycapitales;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class Adaptador extends ArrayAdapter<Datos> {
    private Datos[] datos;

    public Adaptador(Context context, Datos[] datos) {
        super(context, R.layout.elemento, datos);
        this.datos = datos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View elemento = inflater.inflate(R.layout.elemento, parent, false);

        // Obtener referencias a los TextView del layout elemento.xml
        TextView texto1 = elemento.findViewById(R.id.texto1);
        TextView texto2 = elemento.findViewById(R.id.texto2);

        // Asignar los valores de los datos actuales a los TextView
        texto1.setText(datos[position].getTexto1());
        texto2.setText(datos[position].getTexto2());

        return elemento;
    }
}
