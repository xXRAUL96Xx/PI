package com.example.sergy.proyectointegrador;

/**
 * Created by Sergy on 16/01/2017.
 */

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


public class TabBuscar extends Fragment {
    Publicaciones publicaciones = new Publicaciones();
    ArrayList<Publicaciones> Pub;
    private ListView lista;
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private Adapter adapter;
    private DatabaseReference mRef;
    private ChildEventListener childEventListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_buscar, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Pub = new ArrayList<>();
        lista = (ListView) view.findViewById(R.id.list_view);

        DatabaseReference ref = firebaseDatabase.getReference("Viaje");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                publicaciones = dataSnapshot.getValue(Publicaciones.class);
                Pub.add(publicaciones);
                adapter = new Adapter(getContext(), Pub);
                lista.setAdapter(adapter);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


/*publicaciones = dataSnapshot.getValue(Publicaciones.class);
                Pub.add(publicaciones);
                adapter = new Adapter(getContext(), Pub);
                lista.setAdapter(adapter);*/


    }
}
