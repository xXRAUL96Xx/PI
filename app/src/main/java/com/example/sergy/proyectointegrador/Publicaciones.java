package com.example.sergy.proyectointegrador;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sergy on 23/01/2017.
 */

public class Publicaciones {
    private String origen;
    private String destino;
    private String fecha;
    private String hora;
    private String precio;

    public Publicaciones(String origen, String destino, String fecha, String hora, String precio) {
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.hora = hora;
        this.precio = precio;
    }

    public Publicaciones() {
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("Origen", origen);
        result.put("Destino", destino);
        result.put("Fecha", fecha);
        result.put("Hora", hora);
        result.put("Precio", precio);
        return result;
    }
}
