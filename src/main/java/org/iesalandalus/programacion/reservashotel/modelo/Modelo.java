package org.iesalandalus.programacion.reservashotel.modelo;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.reservashotel.modelo.dominio.Habitacion;
import org.iesalandalus.programacion.reservashotel.modelo.dominio.Huesped;
import org.iesalandalus.programacion.reservashotel.modelo.dominio.Reserva;
import org.iesalandalus.programacion.reservashotel.modelo.dominio.TipoHabitacion;
import org.iesalandalus.programacion.reservashotel.modelo.negocio.Habitaciones;
import org.iesalandalus.programacion.reservashotel.modelo.negocio.Huespedes;
import org.iesalandalus.programacion.reservashotel.modelo.negocio.Reservas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Modelo {
    private Huespedes huespedes;
    private Reservas reservas;
    private Habitaciones habitaciones;
    public Modelo(){

    }
     public void comenzar(){
        huespedes=new Huespedes();
        reservas=new Reservas();
        habitaciones=new Habitaciones();
     }
     public void terminar(){
         System.out.println("El modelo ha terminado");
     }
    public void insertar(Huesped huesped) throws OperationNotSupportedException {
        huespedes.insertar(new Huesped(huesped));
    }

    public Huesped buscar(Huesped huesped) {
        try {
            return huespedes.buscar(huesped);
        } catch (OperationNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
    public void borrar(Huesped huesped) throws OperationNotSupportedException {
        huespedes.borrar(huesped);
    }
    public List<Huesped> getHuespedes(){
        return huespedes.get();
    }
    public void insertar(Habitacion habitacion) throws OperationNotSupportedException {
        habitaciones.insertar(habitacion);
    }
    public Habitacion buscar(Habitacion habitacion){

        try {
            return habitaciones.buscar(habitacion);
        } catch (OperationNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
    public void borrar(Habitacion habitacion) throws OperationNotSupportedException {
        habitaciones.borrar(habitacion);
    }
    public List<Habitacion> getHabitaciones(){
        return habitaciones.get();
    }
    public List<Habitacion> getHabitaciones(TipoHabitacion tipoHabitacion){
        return habitaciones.get(tipoHabitacion);
    }
    public void insertar(Reserva reserva) throws OperationNotSupportedException{
        reservas.insertar(reserva);
    }
    public void borrar(Reserva reserva) throws OperationNotSupportedException {
        reservas.borrar(reserva);
    }
    public Reserva buscar(Reserva reserva){
        try {
            return reservas.buscar(reserva);
        } catch (OperationNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Reserva> getReservas(){

        return reservas.get();
    }
    public List<Reserva> getReservas(Huesped huesped){

        return reservas.getReservas(huesped);
    }
    public List<Reserva> getReservas(TipoHabitacion tipoHabitacion){

        return reservas.getReservas(tipoHabitacion);
    }
    public List<Reserva> getReservasFuturas(Habitacion habitacion){
        List<Reserva> conjReservasFuturas =reservas.getReservasFuturas(habitacion);
        return conjReservasFuturas;
    }
    public void realizarCheckin(Reserva reserva,LocalDateTime fecha) throws OperationNotSupportedException {

       reservas.realizarCheckin(reserva,fecha);

    }
    public void realizarCheckout(Reserva reserva,LocalDateTime fecha ) throws OperationNotSupportedException {
        reservas.realizarCheckout(reserva,fecha);
    }
}


