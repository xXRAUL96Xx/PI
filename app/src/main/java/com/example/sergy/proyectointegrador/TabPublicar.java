package com.example.sergy.proyectointegrador;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Sergy on 16/01/2017.
 */

public class TabPublicar extends Fragment {
    int nPub = 0;
    EditText e_origen;
    EditText e_destino;
    EditText e_fecha;
    EditText e_hora;
    EditText e_precio;
    Button b_publicar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_publicar, container, false);
        e_origen = (EditText) rootView.findViewById(R.id.P_Origen);
        e_destino = (EditText) rootView.findViewById(R.id.P_Destino);
        e_fecha = (EditText) rootView.findViewById(R.id.P_Fecha);
        e_hora = (EditText) rootView.findViewById(R.id.P_Hora);
        e_precio = (EditText) rootView.findViewById(R.id.P_Precio);
        b_publicar = (Button) rootView.findViewById(R.id.P_Publicar);
        b_publicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nPub++;
                String origen = e_origen.getText().toString();
                String destino = e_destino.getText().toString();
                String fecha = e_fecha.getText().toString();
                String hora = e_hora.getText().toString();
                String precio = e_precio.getText().toString();

                DatabaseReference dbRef =
                        FirebaseDatabase.getInstance().getReference();
                String key = dbRef.child("posts").push().getKey();

                /*Map<String, String> publicacion = new HashMap<>();
                publicacion.put("Origen", origen);
                publicacion.put("Destino", destino);
                publicacion.put("Fecha", fecha);
                publicacion.put("Hora", hora);
                publicacion.put("Precio", precio);*/

                //dbRef.child("Pub"+nPub).setValue(publicacion);
                Publicaciones p = new Publicaciones();
                p.setOrigen(origen);
                p.setDestino(destino);
                p.setFecha(fecha);
                p.setHora(hora);
                p.setPrecio(precio);
                dbRef.child("Viaje").child(key).setValue(p);

                e_origen.setText("");
                e_destino.setText("");
                e_fecha.setText("");
                e_hora.setText("");
                e_precio.setText("");

                Toast.makeText(getContext(), "publicacion creada", Toast.LENGTH_SHORT).show();

            }
        });

        return rootView;
    }


}