package com.example.ejercicio1tema6paisesycapitales;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
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

        // Obtener referencias a los TextView y ImageView del layout
        TextView texto1 = elemento.findViewById(R.id.texto1);
        TextView texto2 = elemento.findViewById(R.id.texto2);
        ImageView imagenBandera = elemento.findViewById(R.id.imagenBandera);

        // Asignar los valores de los datos actuales a los TextView
        texto1.setText(datos[position].getTexto1());  // Nombre del país
        texto2.setText(datos[position].getTexto2());  // Capital

        // Asignar la imagen de la bandera correspondiente según el país
        switch (datos[position].getTexto1()) {
            case "España":
                imagenBandera.setImageResource(R.drawable.espana);
                break;
            case "Francia":
                imagenBandera.setImageResource(R.drawable.francia);
                break;
            case "Venezuela":
                imagenBandera.setImageResource(R.drawable.venezuela);
                break;
            case "Alemania":
                imagenBandera.setImageResource(R.drawable.alemania);
                break;
            case "Irlanda":
                imagenBandera.setImageResource(R.drawable.irlanda);
                break;
            case "Noruega":
                imagenBandera.setImageResource(R.drawable.noruega);
                break;
            case "Italia":
                imagenBandera.setImageResource(R.drawable.italia);
                break;
            case "Argentina":
                imagenBandera.setImageResource(R.drawable.argentina);
                break;
            case "Canadá":
                imagenBandera.setImageResource(R.drawable.canada);
                break;
            case "Portugal":
                imagenBandera.setImageResource(R.drawable.portugal);
                break;
            default:
                 // Bandera por defecto si no hay coincidencia
        }

        return elemento;
    }
}
