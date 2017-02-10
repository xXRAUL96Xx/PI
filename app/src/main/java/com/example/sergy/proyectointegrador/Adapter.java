package com.example.sergy.proyectointegrador;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sergy on 23/01/2017.
 */

public class Adapter extends BaseAdapter {
    private Context contexto;
    private ArrayList<Publicaciones> publicaciones;

    public Adapter(Context contexto, ArrayList<Publicaciones> publicaciones) {
        this.contexto = contexto;
        this.publicaciones = publicaciones;
    }

    @Override
    public int getCount() {
        return publicaciones.size();
    }

    @Override
    public Object getItem(int position) {
        return publicaciones.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        final ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(contexto).inflate(R.layout.item_publicaciones, null);

            holder = new ViewHolder();
            holder.origen = (TextView) convertView.findViewById(R.id.item_origen);
            holder.destino = (TextView) convertView.findViewById(R.id.item_destino);
            holder.fecha = (TextView) convertView.findViewById(R.id.item_fecha);
            holder.hora = (TextView) convertView.findViewById(R.id.item_hora);
            holder.precio = (TextView) convertView.findViewById(R.id.item_precio);


            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.origen.setText(publicaciones.get(position).getOrigen());
        holder.destino.setText(publicaciones.get(position).getDestino());
        holder.fecha.setText(publicaciones.get(position).getFecha());
        holder.hora.setText(publicaciones.get(position).getHora());
        holder.precio.setText(publicaciones.get(position).getPrecio());


        //Log.i("origen",publicaciones.get(position).getOrigen());

        return convertView;
    }

    private class ViewHolder {
        TextView origen, destino, fecha, hora, precio;
    }
}
