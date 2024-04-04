package org.iesalandalus.programacion.reservashotel.modelo.negocio;



import javax.naming.OperationNotSupportedException;
import java.org.iesalandalus.programacion.reservashotel.modelo.dominio.Habitacion;
import java.org.iesalandalus.programacion.reservashotel.modelo.dominio.Huesped;
import java.org.iesalandalus.programacion.reservashotel.modelo.dominio.Reserva;
import java.org.iesalandalus.programacion.reservashotel.modelo.dominio.TipoHabitacion;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Reservas {
    private int capacidad;
    private int tamano;
    private Reserva[] coleccionReservas;
    public Reservas(int capacidad){
        this.capacidad=capacidad;
        this.coleccionReservas =new Reserva[capacidad];
        tamano=0;
    }

    public int getTamano() {
        return tamano;
    }

    public int getCapacidad() {
        return capacidad;
    }
    public Reserva[] get(){
        return copiaProfundaReservas();
    }
    private Reserva[] copiaProfundaReservas(){
        Reserva[] copiaProfunda=new Reserva[capacidad];
        for (int i = 0; i< coleccionReservas.length; i++){
            copiaProfunda[i]=(coleccionReservas[i]);
        }
        return copiaProfunda;
    }
    public void insertar(Reserva reserva) throws OperationNotSupportedException {
        if(reserva ==null)
            throw  new NullPointerException("ERROR: No se puede insertar un huesped nulo.");
        if(capacidadSuperada(buscarIndice(reserva)))
            throw new OperationNotSupportedException("ERROR: No se aceptan mas huespedes.");
        if(!tamanoSuperado(buscarIndice(reserva)))
            throw  new OperationNotSupportedException("ERROR: Ya hay un huesped con ese dni.");
        coleccionReservas[buscarIndice(reserva)]=new Reserva(reserva);
        tamano++;
        System.out.println("La reserva se realizo correctamente");
    }
    private int buscarIndice(Reserva reserva){
        int indice=-1;
        boolean find=false;
        for (int i = 0; i< coleccionReservas.length && !find; i++){
            if(coleccionReservas[i] != null && coleccionReservas[i].equals(reserva)){
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
    public Reserva buscar(Reserva reserva){
        if(reserva==null){
            throw  new NullPointerException("ERROR: No se puede buscar una reserva nula.");
        }
        Reserva reserva1= null;
        boolean find=false;
        for(int i=0 ; i< coleccionReservas.length && !find ; i++){
            if(coleccionReservas[i] != null && coleccionReservas[i].equals(reserva)){
                reserva1= coleccionReservas[i];
                find= true;
            }
        }
        return reserva1;
    }
    public void borrar(Reserva reserva) throws OperationNotSupportedException {
        if(reserva==null){
            throw new NullPointerException("ERROR: No se puede borrar una reserva nula.");
        }
        int indice =buscarIndice(reserva);
        if (indice==-1){
            throw new OperationNotSupportedException("ERROR: No existe ninguna reserva como la indicada.");
        }
        else {
            desplazarPosicionHaciaIzquierda(indice);
            tamano--;
            System.out.println("La reserva a sido borrada.");
        }

    }
    private void desplazarPosicionHaciaIzquierda(int indice){
        for(int i = indice; i< coleccionReservas.length-1 && coleccionReservas[i]!=null; i++){
            coleccionReservas[i]= coleccionReservas[i+1];
        }
    }
    public Reserva[] getReservas(Huesped huesped){
        Reserva[] reservaHuesped = new Reserva[capacidad];
        for(int i=0;i< coleccionReservas.length;i++){
            if (coleccionReservas[i].getHuesped().equals(huesped)){
                reservaHuesped[i]=(coleccionReservas[i]);
            }
        }
        return reservaHuesped;
    }
    public Reserva[] getReservas(TipoHabitacion tipoHabitacion){
        Reserva[] reservaTipo = new Reserva[capacidad];
        for (int i=0;i< coleccionReservas.length;i++){
            if (coleccionReservas[i].getHabitacion().getTipoHabitacion().equals(tipoHabitacion)){
                reservaTipo[i]=(coleccionReservas[i]);
            }
        }
        return reservaTipo;
    }
    public Reserva[] getReservasFuturas(Habitacion habitacion){
        Reserva[] reservaFutura = new Reserva[capacidad];
        for(int i =0;i< coleccionReservas.length;i++){
            if (coleccionReservas[i].getHabitacion().equals(habitacion)
                    && coleccionReservas[i].getFechaInicioReserva().isAfter(LocalDate.now())){
                reservaFutura[i]=coleccionReservas[i];
            }
        }
        return reservaFutura;
    }
    public void realizarCheckin(Reserva reserva ,LocalDateTime fecha) {
    reserva.setCheckIn(fecha);

    }
    public void realizarCheckout(Reserva reserva , LocalDateTime fecha){
    reserva.setCheckOut(fecha
    );
    }
}