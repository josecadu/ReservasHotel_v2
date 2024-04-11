package org.iesalandalus.programacion.reservashotel.modelo.dominio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Reserva {
    public static final int MAX_NUMERO_MESES_RESERVA=3;
    private static final int MAX_HORAS_POSTERIOR_CHECKOUT=12;
    public static final DateTimeFormatter FORMATO_FECHA_RESERVA= DateTimeFormatter.ofPattern("dd/MM/yyyy") ;
    public static final DateTimeFormatter FORMATO_FECHA_HORA_RESERVA=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private Huesped huesped;
    private Habitacion habitacion;
    private Regimen regimen;
    private LocalDate fechaInicioReserva;
    private LocalDate fechaFinReserva;
    private  LocalDateTime checkIn;
    private  LocalDateTime checkOut;
    private  double precio;
    private int numeroPersonas;

    public Reserva(Huesped huesped,Habitacion habitacion,Regimen regimen
            ,LocalDate fechaInicioReserva, LocalDate fechaFinReserva,int numeroPersonas){
        setHuesped(huesped);
        setHabitacion(habitacion);
        setRegimen(regimen);
        setFechaInicioReserva(fechaInicioReserva);
        setFechaFinReserva(fechaFinReserva);
        setNumeroPersonas(numeroPersonas);
    }
    public Reserva(Reserva reserva){
        if(reserva==null)
            throw  new NullPointerException("ERROR: La reserva no puede ser nula.");
        setHuesped(reserva.getHuesped());
        setHabitacion(reserva.getHabitacion());
        setRegimen(reserva.getRegimen());
        setFechaInicioReserva(reserva.getFechaInicioReserva());
        setFechaFinReserva(reserva.getFechaFinReserva());
        setNumeroPersonas(reserva.getNumeroPersonas());
        setPrecio();
    }
    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        if(huesped==null)
            throw  new NullPointerException("ERROR: El huesped no puede ser nulo.");
        this.huesped = huesped;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        if(habitacion==null)
            throw new NullPointerException("ERROR: La habitación no puede ser nula.");
        this.habitacion = habitacion;
    }

    public Regimen getRegimen() {
        return regimen;
    }

    public void setRegimen(Regimen regimen) {
        if(regimen==null)
            throw new NullPointerException("ERROR: El regimen no puede ser nulo.");
        this.regimen = regimen;
    }

    public LocalDate getFechaInicioReserva() {
        return fechaInicioReserva;
    }

    public void setFechaInicioReserva(LocalDate fechaInicioReserva) {
        if(fechaInicioReserva.isBefore(LocalDate.now()))
                throw new IllegalArgumentException("ERROR: La fecha de inicio de reserva no puede ser anterior a hoy.");
        if(ChronoUnit.MONTHS.between(LocalDateTime.now(),fechaInicioReserva)>MAX_NUMERO_MESES_RESERVA)
                throw new IllegalArgumentException("ERROR: No es posible resevar una habitacion con mas de 3 meses de antelacion.");
        this.fechaInicioReserva = fechaInicioReserva;
    }

    public LocalDate getFechaFinReserva() {
        return fechaFinReserva;
    }

    public void setFechaFinReserva(LocalDate fechaFinReserva) {
        if (fechaInicioReserva.isAfter(fechaFinReserva))
            throw new IllegalArgumentException("ERROR: La fecha de fin de reserva no puede ser antes que la de inicio.");
        this.fechaFinReserva = fechaFinReserva;
    }

    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDateTime checkIn) {
        if (checkIn == null)
            throw new NullPointerException("ERROR: La fecha de check in no puee ser nula");
        if (checkIn.isBefore(fechaInicioReserva.atStartOfDay()))
            throw new IllegalArgumentException("ERROR L afecha dde check in no puede ser anterior a la fecha de inicio de reserva.");

        this.checkIn = checkIn;
    }

    public LocalDateTime getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDateTime checkOut) {
        if (checkIn == null)
            throw new NullPointerException("ERROR: No ha realizado el check in.");
        if (checkOut == null)
            throw new NullPointerException("ERROR: La fecha de check out no puee ser nula");
        if (checkOut.isBefore(checkIn))
            throw new IllegalArgumentException("ERROR L afecha dde check in no puede ser anterior a la fecha de inicio de reserva.");
        if (checkOut.isAfter(fechaFinReserva.atStartOfDay().plus(MAX_HORAS_POSTERIOR_CHECKOUT,ChronoUnit.HOURS)))
            throw  new IllegalArgumentException("ERROR: La fecha de checout no puede ser posterior en 12 horas a la fecha de fin de reserva.");
        this.checkOut = checkOut;
        setPrecio();
    }

    public double getPrecio() {
        return precio;
    }

    private void setPrecio() {
        precio=(getRegimen().getIncrementoPrecio()*numeroPersonas)+habitacion.MIN_PRECIO_HABITACION;
        if(precio>habitacion.MAX_PRECIO_HABITACION) {
            precio = habitacion.MAX_PRECIO_HABITACION;
        }
        this.precio = precio;
    }

    public int getNumeroPersonas() {
        return numeroPersonas;
    }

    public void setNumeroPersonas(int numeroPersonas) {
        if(numeroPersonas>habitacion.getTipoHabitacion().getNumeroMaximoPersonas())
            throw  new IllegalArgumentException("ERROR: El numero de personas supera el maximo permitido.");
        this.numeroPersonas = numeroPersonas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reserva reserva)) return false;
        return Objects.equals(getHabitacion(), reserva.getHabitacion()) && Objects.equals(getFechaInicioReserva(), reserva.getFechaInicioReserva());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHabitacion(), getFechaInicioReserva());
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "habitacion=" + habitacion +
                ", regimen=" + regimen +
                ", fechaInicioReserva=" + fechaInicioReserva +
                '}';
    }
}
