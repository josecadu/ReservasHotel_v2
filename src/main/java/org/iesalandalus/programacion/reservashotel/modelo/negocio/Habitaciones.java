package org.iesalandalus.programacion.reservashotel.modelo.negocio;



import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.reservashotel.modelo.dominio.Habitacion;
import org.iesalandalus.programacion.reservashotel.modelo.dominio.TipoHabitacion;

import java.util.ArrayList;
import java.util.List;

public class Habitaciones {

    private List<Habitacion> coleccionHabitaciones;
    public Habitaciones(){
        coleccionHabitaciones =new ArrayList<>();
    }

    public List<Habitacion> get(){

        return copiaProfundaHabitaciones();
    }


    private List<Habitacion> copiaProfundaHabitaciones(){
        List<Habitacion> copiaColeccion= new ArrayList<>();
        copiaColeccion.addAll(coleccionHabitaciones);
        return copiaColeccion;
    }
    public List<Habitacion> get(TipoHabitacion tipoHabitacion){
        List<Habitacion> coleccionTipo = new ArrayList<>();
        for (Habitacion tipoHab : coleccionHabitaciones)
            if (tipoHab.getTipoHabitacion().equals(tipoHabitacion)) {
               coleccionTipo.add( (Habitacion) coleccionHabitaciones);
            }
        return coleccionTipo;
       
    }
    public void insertar(Habitacion habitacion) throws OperationNotSupportedException {

        if(coleccionHabitaciones.contains(habitacion)){
        throw new OperationNotSupportedException("ERROR: Ya hay una habitaci�n con ese identificador.");
        }
        if(habitacion==null) {
            throw new NullPointerException("ERROR: No se puede insertar una habitaci�n nula.");
        }
        Habitacion nuevaHabitacion =new Habitacion(habitacion);
        coleccionHabitaciones.add(nuevaHabitacion);
        System.out.println("La habitaci�n se a�adio correctamente");
    }



    public Habitacion buscar(Habitacion habitacion) throws OperationNotSupportedException {
        if (habitacion == null)
            throw new NullPointerException("ERROR: No se puede buscar una habitacion nula.");
        if (!coleccionHabitaciones.contains(habitacion)){
            throw new OperationNotSupportedException("ERROR: No existe ninguna habitaci�n asi.");
        }
        int indice = coleccionHabitaciones.indexOf(habitacion);
        if (indice != -1)
            return coleccionHabitaciones.get(indice);
        else
            return null;
    }
    public void borrar(Habitacion habitacion) throws OperationNotSupportedException {
        if(habitacion==null){
            throw new NullPointerException("ERROR: No se puede borrar una habitacion nula.");
        }
        if (!coleccionHabitaciones.contains(habitacion)){
            throw new OperationNotSupportedException("ERROR: No existe ningun habitaci�n asi.");
        }
            coleccionHabitaciones.remove(habitacion);
            System.out.println("La habitaci�n ha sido borrada.");
        }


    public int getTamano() {
        return coleccionHabitaciones.size();
    }

}
