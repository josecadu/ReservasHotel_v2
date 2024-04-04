package org.iesalandalus.programacion.reservashotel.modelo.negocio;



import javax.naming.OperationNotSupportedException;
import java.org.iesalandalus.programacion.reservashotel.modelo.dominio.Habitacion;
import java.org.iesalandalus.programacion.reservashotel.modelo.dominio.TipoHabitacion;

public class Habitaciones {
    private int capacidad;
    private int tamano;
    private Habitacion[] coleccionHabitaciones;
    public Habitaciones(int capacidad){
        this.capacidad=capacidad;
        this.coleccionHabitaciones =new Habitacion[capacidad];
        tamano=0;
    }

    public int getTamano() {
        return tamano;
    }

    public int getCapacidad() {
        return capacidad;
    }
    public Habitacion[] get(){
        return copiaProfundaHabitaciones();
    }
    private Habitacion[] copiaProfundaHabitaciones(){
        Habitacion[] copiaProfunda=new Habitacion[capacidad];
        for (int i = 0; i< coleccionHabitaciones.length; i++){
            copiaProfunda[i]=(coleccionHabitaciones[i]);
        }
        return copiaProfunda;
    }
    public Habitacion[] get(TipoHabitacion tipoHabitacion){
        Habitacion[] copiaProfundaTipo=new Habitacion[capacidad];
        for (int i = 0; i< coleccionHabitaciones.length; i++){
            if (coleccionHabitaciones[i].getTipoHabitacion().equals(tipoHabitacion)){
                copiaProfundaTipo[i]=(coleccionHabitaciones[i]);
            }
        }
        return copiaProfundaTipo;
    }
    public void insertar(Habitacion habitacion) throws OperationNotSupportedException {
        if(habitacion==null)
            throw  new NullPointerException("ERROR: No se puede insertar una habitación nula.");
        if(capacidadSuperada(buscarIndice(habitacion)))
            throw new OperationNotSupportedException("ERROR: No se aceptan mas habitaciónes.");
        if(!tamanoSuperado(buscarIndice(habitacion)))
            throw  new OperationNotSupportedException("ERROR: Ya hay una habitación con ese identificador.");
        coleccionHabitaciones[buscarIndice(habitacion)]=new Habitacion(habitacion);
        tamano++;
        System.out.println("La habitación se añadio correctamente");
    }
    private int buscarIndice(Habitacion habitacion){
        int indice=-1;
        boolean find=false;
        for (int i = 0; i< coleccionHabitaciones.length && !find; i++){
            if(coleccionHabitaciones[i] != null && coleccionHabitaciones[i].equals(habitacion)){
                indice = i;
                find=true;
            }
            else {
                indice=getTamano()+1;
            }
        }
        return indice;
    }
    private Boolean tamanoSuperado(int indice){
        if(indice>=tamano){
            return true;
        }
        else{
            return false;
        }

    }
    private Boolean capacidadSuperada(int indice){
        if(indice>=capacidad){
            return true;
        }
        else {
            return false;
        }
    }
    public Habitacion buscar(Habitacion habitacion){
        if(habitacion==null){
            throw  new NullPointerException("ERROR: No se puede buscar una habitación nula.");
        }
        Habitacion habitacion1= null;
        boolean find=false;
        for(int i = 0; i< coleccionHabitaciones.length && !find ; i++){
            if(coleccionHabitaciones[i] != null && coleccionHabitaciones[i].equals(habitacion)){
                habitacion1= coleccionHabitaciones[i];
                find= true;
            }
        }
        return habitacion1;
    }
    public void borrar(Habitacion habitacion) throws OperationNotSupportedException {
        if(habitacion==null){
            throw new NullPointerException("ERROR: No se puede borrar una habitacion nula.");
        }
        int indice =buscarIndice(habitacion);
        if (indice==-1){
            throw new OperationNotSupportedException("ERROR: No existe ningun habitación asi.");
        }
        else {
            desplazarPosicionHaciaIzquierda(indice);
            tamano--;
            System.out.println("La habitación ha sido borrada.");
        }

    }
    private void desplazarPosicionHaciaIzquierda(int indice){
        for(int i = indice; i< coleccionHabitaciones.length-1 && coleccionHabitaciones[i]!=null; i++){
            coleccionHabitaciones[i]= coleccionHabitaciones[i+1];
        }
    }
}
