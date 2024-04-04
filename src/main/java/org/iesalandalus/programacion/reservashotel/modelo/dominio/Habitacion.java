package org.iesalandalus.programacion.reservashotel.modelo.dominio;

import java.util.Objects;

public class Habitacion {
    public final double MIN_PRECIO_HABITACION=40.00;
    public final double MAX_PRECIO_HABITACION=150.00;
    public final int MIN_NUMERO_PUERTA=0;
    public final int MAX_NUMERO_PUERTA=14;
    public final int MIN_NUMERO_PLANTA=1;
    public final int MAX_NUMERO_PLANTA=3;
    private String indentificador;
    private  int planta;
    private  int puerta;
    private double precio;
    private TipoHabitacion tipoHabitacion;



    public String getIndentificador() {

        return indentificador;
    }

    private void setIndentificador(String indentificador) {
        int id1=getPlanta();
        int id2=getPuerta();
        indentificador= ""+id1+id2;
        this.indentificador = indentificador;
    }

    public int getPlanta() {
        return planta;
    }

    private void setPlanta(int planta) {

        this.planta = planta;
    }

    public int getPuerta() {

        return puerta;
    }

    private void setPuerta(int puerta) {

        this.puerta = puerta;
    }

    public double getPrecio() {

        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {

        this.tipoHabitacion = tipoHabitacion;
    }
    public Habitacion(int planta, int puerta, double precio, String indentificador){
        setPlanta(planta);
        setPuerta(puerta);
        setPrecio(precio);
        setIndentificador(indentificador);

    }
    public Habitacion(int planta,int puerta,double precio,TipoHabitacion tipoHabitacion,String indentificador){
        setPlanta(planta);
        setPuerta(puerta);
        setPrecio(precio);
        setTipoHabitacion(tipoHabitacion);
        setIndentificador(indentificador);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Habitacion that)) return false;
        return Objects.equals(getIndentificador(), that.getIndentificador());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIndentificador());
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "indentificador='" + indentificador + '\'' +
                ", planta=" + planta +
                ", puerta=" + puerta +
                ", precio=" + precio +
                ", tipoHabitacion=" + tipoHabitacion +
                '}';
    }

    public Habitacion (Habitacion habitacion){
        if(habitacion==null)
            throw new NullPointerException("ERROR: No es posible crear una habitación nula.");
        setPlanta(habitacion.getPlanta());
        setPuerta(habitacion.getPuerta());
        setPrecio(habitacion.getPrecio());
        setTipoHabitacion(habitacion.getTipoHabitacion());
        setIndentificador(habitacion.getIndentificador());
    }
}
