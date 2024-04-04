package org.iesalandalus.programacion.reservashotel.modelo.dominio;

public enum Regimen {
    SOLO_ALOJAMIENTO("solo alojamiento",0),ALOJAMIENTO_DESAYUNO("alojamiento desayuno",15),MEDIA_PENSION("media pensión",30)
    ,PENSION_COMPLETA("pensión comppleta",50);
    private String cadenaAMostrar;
    private double incrementoPrecio;
    private Regimen(String cadenaAMostrar,int incrementoPrecio){
        this.cadenaAMostrar=cadenaAMostrar;
        this.incrementoPrecio=incrementoPrecio;
    }

    public double getIncrementoPrecio() {

        return incrementoPrecio;
    }

    @Override
    public String toString() {
        return cadenaAMostrar;
    }
}
