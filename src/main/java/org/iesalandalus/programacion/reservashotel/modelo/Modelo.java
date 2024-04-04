package org.iesalandalus.programacion.reservashotel.modelo;

import javax.naming.OperationNotSupportedException;
import java.org.iesalandalus.programacion.reservashotel.modelo.dominio.Habitacion;
import java.org.iesalandalus.programacion.reservashotel.modelo.dominio.Huesped;
import java.org.iesalandalus.programacion.reservashotel.modelo.dominio.Reserva;
import java.org.iesalandalus.programacion.reservashotel.modelo.dominio.TipoHabitacion;
import java.org.iesalandalus.programacion.reservashotel.modelo.negocio.Habitaciones;
import java.org.iesalandalus.programacion.reservashotel.modelo.negocio.Huespedes;
import java.org.iesalandalus.programacion.reservashotel.modelo.negocio.Reservas;
import java.time.LocalDateTime;

public class Modelo {
    private static final int CAPACIDAD=8;
    private Huespedes huespedes;
    private Reservas reservas;
    private Habitaciones habitaciones;
    public Modelo(){

    }
     public void comenzar(){
        huespedes=new Huespedes(CAPACIDAD);
        reservas=new Reservas(CAPACIDAD);
        habitaciones=new Habitaciones(CAPACIDAD);
     }
     public void terminar(){
         System.out.println("El modelo ha terminado");
     }
    public void insertar(Huesped huesped) throws OperationNotSupportedException {
        huespedes.insertar(new Huesped(huesped));
    }

    public Huesped buscar(Huesped huesped) {
       return huespedes.buscar(huesped);
    }
    public void borrar(Huesped huesped) throws OperationNotSupportedException {
        huespedes.borrar(huesped);
    }
    public Huesped[] getHuespedes(){
    Huesped[] conjHuespedes=new Huesped[huespedes.getCapacidad()];
    for (int i =0;i<getHuespedes().length;i++){
        conjHuespedes[i]=(huespedes.get()[i]);
        }
        return conjHuespedes;
    }
    public void insertar(Habitacion habitacion) throws OperationNotSupportedException {
        habitaciones.insertar(habitacion);
    }
    public Habitacion buscar(Habitacion habitacion){
        return habitaciones.buscar(habitacion);
    }
    public void borrar(Habitacion habitacion) throws OperationNotSupportedException {
        habitaciones.borrar(habitacion);
    }
    public Habitacion[] getHabitaciones(){
        Habitacion[] conjHabitaciones=new Habitacion[habitaciones.getCapacidad()];
        for (int i =0;i<getHabitaciones().length;i++){
            conjHabitaciones[i]=(habitaciones.get()[i]);
        }
        return conjHabitaciones;
    }
    public Habitacion[] getHabitaciones(TipoHabitacion tipoHabitacion){
        Habitacion[] conjHabitaciones=new Habitacion[habitaciones.getCapacidad()];
        for (int i =0;i< getHabitaciones().length;i++){
            conjHabitaciones[i]=(habitaciones.get(tipoHabitacion)[i]);
        }
        return conjHabitaciones;
    }
    public void insertar(Reserva reserva) throws OperationNotSupportedException{
        reservas.insertar(reserva);
    }
    public void borrar(Reserva reserva) throws OperationNotSupportedException {
        reservas.borrar(reserva);
    }
    public Reserva buscar(Reserva reserva){
        return reservas.buscar(reserva);
    }
    public Reserva[] getReservas(){

        return reservas.get();
    }
    public Reserva[] getReservas(Huesped huesped){

        return reservas.getReservas(huesped);
    }
    public Reserva[] getReservas(TipoHabitacion tipoHabitacion){

        return reservas.getReservas(tipoHabitacion);
    }
    public Reserva[] getReservasFuturas(Habitacion habitacion){
        Reserva[] conjReservasFuturas =reservas.getReservasFuturas(habitacion);
        return conjReservasFuturas;
    }
    public void realizarCheckin(Reserva reserva LocalDateTime fecha){

        fecha=reservas.getHuesped(getReservas(reserva.setCheckIn(LocalDateTime.now());

    }
    public void realizarCheckout(Reserva reserva LocalDateTime fecha){
        LocalDateTime;
    }
}


