package org.iesalandalus.programacion.reservashotel.vista;

import javax.naming.OperationNotSupportedException;
import java.org.iesalandalus.programacion.reservashotel.controlador.Controlador;
import java.org.iesalandalus.programacion.reservashotel.modelo.dominio.Habitacion;
import java.org.iesalandalus.programacion.reservashotel.modelo.dominio.Huesped;
import java.org.iesalandalus.programacion.reservashotel.modelo.dominio.Reserva;
import java.org.iesalandalus.programacion.reservashotel.modelo.dominio.TipoHabitacion;
import java.org.iesalandalus.programacion.reservashotel.modelo.negocio.Huespedes;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

public class Vista {
    private Controlador controlador;

    public void setControlador(Controlador controlador) {
        if (controlador== null){
            throw  new NullPointerException("ERROR: El controlador no puede ser nulo.");
        }
        this.controlador = controlador;
    }
    public void comenzar(){
        Opcion seleccion = null;
        do {
            Consola.elegirOpcion();
            ejecutarOpcion(seleccion);
        }
        while (seleccion!=Opcion.SALIR);
    }
    public void terminar(){
        System.out.println("La vista ha finalizado.");
    }

    private void ejecutarOpcion(Opcion opcion) {
        switch (opcion) {
            case INSERTAR_HUESPED: {
                insertarHuesped();
                break;
            }
            case BORRAR_HUESPED: {
                borrarHuesped();
                break;
            }
            case BUSCAR_HUESPED: {
                buscarHuesped();
                break;
            }
            case BUSCAR_HABITACION: {
                buscarHabitacion();
                break;
            }
            case MOSTRAR_HUESPEDES:{
                mostrarHuespedes();
                break;
            }
            case INSERTAR_HABITACION: {
                insertarHabitacion();
                break;
            }
            case BORRAR_HABITACION: {
                borrarHabitacion();
                break;
            }
            case MOSTRAR_HABITACIONES: {
                mostrarHabitaciones();
                break;
            }
            case INSERTAR_RESERVA:{
                insertarReserva();
                break;
            }
            case ANULAR_RESERVA: {
                anularReserva();
                break;
            }
            case MOSTRAR_RESERVAS:{
                mostrarReserva();
                break;
            }
            case REALIZAR_CHECKIN:{
                realizarCheckin();
                break;
            }
            case REALIZAR_CHECKOUT:{
                realizarCheckout();
                break;
            }

            case SALIR:{
                break;
            }
        }
    }
    private  void insertarHuesped() {
        try {
            controlador.insertar(Consola.leerHuesped());
        }
        catch (NullPointerException | IllegalArgumentException | OperationNotSupportedException e) {
            System.out.println(e.getMessage());
        }
    }
    private void buscarHuesped() {
        try {
            System.out.println(controlador.buscar(Consola.getHuespedPorDni()));
        }
        catch (NullPointerException | IllegalArgumentException e)  {
            System.out.println(e.getMessage());
        }
    }
    private  void borrarHuesped() {
        try {
            controlador.borrar(Consola.getHuespedPorDni());
        } catch (NullPointerException | IllegalArgumentException | OperationNotSupportedException e)  {
            System.out.println(e.getMessage());        }
    }
    private  void mostrarHuespedes() {
        try {
            Huesped[] huespedes =controlador.getHuespedes();
            for (int i =0;i<huespedes.length;i++){
                System.out.println(huespedes[i]);
            }

        }catch (NullPointerException | IllegalArgumentException e)  {
            System.out.println(e.getMessage());
        }
    }
    private   void insertarHabitacion(){
        try {
            controlador.insertar(Consola.leerHabitacion());
        }catch (NullPointerException | IllegalArgumentException | OperationNotSupportedException e)  {
            System.out.println(e.getMessage());
        }
    }
    private  void buscarHabitacion(){
        try {
            controlador.buscar(Consola.leerHabitacionPorIdentificador());
        }catch (NullPointerException | IllegalArgumentException e)  {
            System.out.println(e.getMessage());
        }
    }
    private  void borrarHabitacion(){
        try {
            controlador.borrar(Consola.leerHabitacionPorIdentificador());
        } catch (NullPointerException | IllegalArgumentException | OperationNotSupportedException e)  {
            System.out.println(e.getMessage());
        }
    }
    private  void mostrarHabitaciones() {
        try {
            Habitacion[] habitaciones =controlador.getHabitaciones();;
            for (int i =0;i<habitaciones.length;i++){
                System.out.println(habitaciones[i]);
            }
        }catch (NullPointerException | IllegalArgumentException e)  {
            System.out.println(e.getMessage());
        }
    }
    private  void insertarReserva() {
        try {
            controlador.insertar(Consola.leerReserva());
        }catch (NullPointerException | IllegalArgumentException | OperationNotSupportedException e)  {
            System.out.println(e.getMessage());
        }
    }
    private  void listarReservas(Huespedes huespedes){
        try {
            Reserva[] reservas =controlador.getReservas(Consola.getHuespedPorDni());
            for (int i =0;i<reservas.length;i++){
                System.out.println(reservas[i]);
            }
        }catch (NullPointerException | IllegalArgumentException e)  {
            System.out.println(e.getMessage());
        }
    }
    private  void listarReservas(TipoHabitacion tipoHabitacion){
        try {
            Reserva[] reservas =controlador.getReservas(Consola.leerTipoHabitacion());
            for (int i =0;i<reservas.length;i++){
                System.out.println(reservas[i]);
            }
        }catch (NullPointerException | IllegalArgumentException e)  {
            System.out.println(e.getMessage());
        }
    }
    private  Reserva [] getReservasAnulables(Reserva[] reserva){
        try {
            reserva =  controlador.getReservasFuturas(Consola.leerHabitacion());
        }catch (NullPointerException | IllegalArgumentException e)  {
            System.out.println(e.getMessage());
        }
        return reserva;
    }

    private  void anularReserva(){
        try {
            controlador.borrar(Consola.leerReserva());
        }catch (NullPointerException | IllegalArgumentException | OperationNotSupportedException e)  {
            System.out.println(e.getMessage());
        }
    }
    private  void mostrarReserva(){
        try {
            Reserva[] reservas =controlador.getReservas();
            for (int i =0;i<reservas.length;i++){
                System.out.println(reservas[i]);
            }
            controlador.getReservas();
        }catch (NullPointerException | IllegalArgumentException e)  {
            System.out.println(e.getMessage());
        }
    }
    private Habitacion consultarDisponibilidad(TipoHabitacion tipoHabitacion, LocalDate fechaInicioReserva, LocalDate fechaFinReserva)
    {
        boolean tipoHabitacionEncontrada=false;
        Habitacion habitacionDisponible=null;
        int numElementos=0;

        Habitacion[] habitacionesTipoSolicitado= controlador.getHabitaciones(tipoHabitacion);

        if (habitacionesTipoSolicitado==null)
            return habitacionDisponible;

        for (int i=0; i<habitacionesTipoSolicitado.length && !tipoHabitacionEncontrada; i++)
        {

            if (habitacionesTipoSolicitado[i]!=null)
            {
                Reserva[] reservasFuturas = controlador.getReservasFuturas(habitacionesTipoSolicitado[i]);
                numElementos=getNumElementosNoNulos(reservasFuturas);

                if (numElementos == 0)
                {
                    //Si la primera de las habitaciones encontradas del tipo solicitado no tiene reservas en el futuro,
                    // quiere decir que está disponible.
                    habitacionDisponible=new Habitacion(habitacionesTipoSolicitado[i]);
                    tipoHabitacionEncontrada=true;
                }
                else {

                    //Ordenamos de mayor a menor las reservas futuras encontradas por fecha de fin de la reserva.
                    // Si la fecha de inicio de la reserva es posterior a la mayor de las fechas de fin de las reservas
                    // (la reserva de la posición 0), quiere decir que la habitación está disponible en las fechas indicadas.

                    Arrays.sort(reservasFuturas, 0, numElementos, Comparator.comparing(Reserva::getFechaFinReserva).reversed());

                    /*System.out.println("\n\nMostramos las reservas ordenadas por fecha de inicio de menor a mayor (numelementos="+numElementos+")");
                    mostrar(reservasFuturas);*/

                    if (fechaInicioReserva.isAfter(reservasFuturas[0].getFechaFinReserva())) {
                        habitacionDisponible = new Habitacion(habitacionesTipoSolicitado[i]);
                        tipoHabitacionEncontrada = true;
                    }

                    if (!tipoHabitacionEncontrada)
                    {
                        //Ordenamos de menor a mayor las reservas futuras encontradas por fecha de inicio de la reserva.
                        // Si la fecha de fin de la reserva es anterior a la menor de las fechas de inicio de las reservas
                        // (la reserva de la posición 0), quiere decir que la habitación está disponible en las fechas indicadas.

                        Arrays.sort(reservasFuturas, 0, numElementos, Comparator.comparing(Reserva::getFechaInicioReserva));

                        /*System.out.println("\n\nMostramos las reservas ordenadas por fecha de inicio de menor a mayor (numelementos="+numElementos+")");
                        mostrar(reservasFuturas);*/

                        if (fechaFinReserva.isBefore(reservasFuturas[0].getFechaInicioReserva())) {
                            habitacionDisponible = new Habitacion(habitacionesTipoSolicitado[i]);
                            tipoHabitacionEncontrada = true;
                        }
                    }

                    //Recorremos el array de reservas futuras para ver si las fechas solicitadas están algún hueco existente entre las fechas reservadas
                    if (!tipoHabitacionEncontrada)
                    {
                        for(int j=1;j<reservasFuturas.length && !tipoHabitacionEncontrada;j++)
                        {
                            if (reservasFuturas[j]!=null && reservasFuturas[j-1]!=null)
                            {
                                if(fechaInicioReserva.isAfter(reservasFuturas[j-1].getFechaFinReserva()) &&
                                        fechaFinReserva.isBefore(reservasFuturas[j].getFechaInicioReserva())) {

                                    habitacionDisponible = new Habitacion(habitacionesTipoSolicitado[i]);
                                    tipoHabitacionEncontrada = true;
                                }
                            }
                        }
                    }


                }
            }
        }

        return habitacionDisponible;
    }
    private int getNumElementosNoNulos(Reserva[] reservas){
        int elementosNoNulos=0;
        for(int i =0;i< reservas.length;i++){
            if(reservas[i]!=null){
                elementosNoNulos+=1;
            }
        }
        return elementosNoNulos;
    }
    private void realizarCheckin(){

    }
    private void realizarCheckout(){

    }
}
