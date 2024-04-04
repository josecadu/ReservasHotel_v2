package org.iesalandalus.programacion.reservashotel.modelo.dominio;

public enum TipoHabitacion {
    SUITE("suite",2),SIMPLE("simple",1),DOBLE("doble",2),TRIPLE("triple",3);
    private String cadenaAMostrar;
    private int numeroMaximoPersonas;
    private  TipoHabitacion(String cadenaAMostrar, int numeroMaximoPersonas){
        this.cadenaAMostrar=cadenaAMostrar;
        this.numeroMaximoPersonas=numeroMaximoPersonas;
    }
    public int getNumeroMaximoPersonas(){
        return numeroMaximoPersonas;
    }
    @Override
    public String toString(){
        return cadenaAMostrar;
    }
}
