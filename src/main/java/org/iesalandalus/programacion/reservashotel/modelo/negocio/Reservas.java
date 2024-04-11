package org.iesalandalus.programacion.reservashotel.modelo.negocio;



import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.reservashotel.modelo.dominio.Habitacion;
import org.iesalandalus.programacion.reservashotel.modelo.dominio.Huesped;
import org.iesalandalus.programacion.reservashotel.modelo.dominio.Reserva;
import org.iesalandalus.programacion.reservashotel.modelo.dominio.TipoHabitacion;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Reservas {
    private int capacidad;
    private int tamano;
    private List<Reserva> coleccionReservas;
    public Reservas ()
    {
        List<Reserva> coleccionReservas=new ArrayList<>();
    }

    public int getTamano() {
        return coleccionReservas.size();
    }


    public List<Reserva> get(){

        return copiaProfundaReservas();
    }
    private List<Reserva> copiaProfundaReservas(){
        List<Reserva> copiaColeccion=new ArrayList<>();
        copiaColeccion.addAll(coleccionReservas);
        return copiaColeccion;
    }
    public void insertar(Reserva reserva) throws OperationNotSupportedException {
        if(reserva ==null)
            throw  new NullPointerException("ERROR: No se puede insertar una reserva nula.");

        if(coleccionReservas.contains(reserva)) {
            throw new OperationNotSupportedException("ERROR: Ya hay una reserva para ese huesped.");
        }
        Reserva nuevaReserva=new Reserva(reserva);
        coleccionReservas.add(nuevaReserva);
        System.out.println("La reserva se realizo correctamente.");
    }



    public Reserva buscar(Reserva reserva) throws OperationNotSupportedException {
        if(reserva==null){
            throw  new NullPointerException("ERROR: No se puede buscar una reserva nula.");
        }
        if(!coleccionReservas.contains(reserva)){
            throw  new OperationNotSupportedException("ERROR: No Existe ninguna reserva para ese huesped.");
        }
        int indice= coleccionReservas.indexOf(reserva);
        if (indice!= -1) {
            return coleccionReservas.get(indice);
        }
        else
            return null;
    }
    public void borrar(Reserva reserva) throws OperationNotSupportedException {
        if(reserva==null){
            throw new NullPointerException("ERROR: No se puede borrar una reserva nula.");
        }
        if (!coleccionReservas.contains(reserva)){
            throw new OperationNotSupportedException("ERROR: No existe ninguna reserva como la indicada.");
        }
            coleccionReservas.remove(reserva);
            System.out.println("La reserva a sido borrada.");
    }
    public List<Reserva> getReservas(Huesped huesped) {
        List<Reserva> reservaHuesped = new ArrayList<>();
        for (Reserva i : coleccionReservas)
            if (i.getHuesped().equals(huesped)) {
                reservaHuesped.add((Reserva) coleccionReservas);
        }
        return reservaHuesped;
    }
    public List<Reserva> getReservas(TipoHabitacion tipoHabitacion){
        List<Reserva> reservaTipo = new ArrayList<>();
        for (Reserva i : coleccionReservas)
            if (i.getHabitacion().getTipoHabitacion().equals(tipoHabitacion)) {
                reservaTipo.add((Reserva) coleccionReservas);
            }
        return reservaTipo;
    }
    public List<Reserva> getReservasFuturas(Habitacion habitacion){
        List<Reserva> reservaFutura =  new ArrayList<>();
        for (Reserva i : coleccionReservas)
            if (i.getHabitacion().equals(habitacion)
                    && i.getFechaInicioReserva().isAfter(LocalDate.now())){
                reservaFutura.add((Reserva) coleccionReservas);
            }

        return reservaFutura;
    }
    public void realizarCheckin(Reserva reserva ,LocalDateTime fecha) throws OperationNotSupportedException {
        if (reserva ==null)
            throw new NullPointerException("ERROR: La reserva no puede ser nula.");
        if (fecha==null)
            throw new NullPointerException("ERROR: La fecha no puede ser nula.");
        Reserva reservaCheck= buscar(reserva);
        if (reservaCheck == null)
            throw new NullPointerException("ERROR: No se ha encontrado la reserva para hacer el check in.");
    reservaCheck.setCheckIn(fecha);

    }
    public void realizarCheckout(Reserva reserva , LocalDateTime fecha) throws OperationNotSupportedException {
        if (reserva ==null)
            throw new NullPointerException("ERROR: La reserva no puede ser nula.");
        if (fecha==null)
            throw new NullPointerException("ERROR: La fecha no puede ser nula.");
        Reserva reservaCheck= buscar(reserva);
        if (reservaCheck == null)
            throw new NullPointerException("ERROR: No se ha encontrado la reserva para hacer el check out.");
    reservaCheck.setCheckOut(fecha);
    }
}