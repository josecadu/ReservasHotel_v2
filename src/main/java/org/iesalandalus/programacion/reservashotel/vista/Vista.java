package org.iesalandalus.programacion.reservashotel.vista;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.reservashotel.controlador.Controlador;
import org.iesalandalus.programacion.reservashotel.modelo.dominio.Habitacion;
import org.iesalandalus.programacion.reservashotel.modelo.dominio.Huesped;
import org.iesalandalus.programacion.reservashotel.modelo.dominio.Reserva;
import org.iesalandalus.programacion.reservashotel.modelo.dominio.TipoHabitacion;
import org.iesalandalus.programacion.utilidades.Entrada;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Vista {
    private Controlador controlador;

    public void setControlador(Controlador controlador) {
        if (controlador== null){
            throw  new NullPointerException("ERROR: El controlador no puede ser nulo.");
        }
        this.controlador = controlador;
    }
    public void comenzar()  {
        Opcion seleccion ;
        do {
            seleccion=Consola.elegirOpcion();
            ejecutarOpcion(seleccion);
        }
        while (seleccion!=Opcion.SALIR );
        controlador.terminar();
    }
    public void terminar(){
        System.out.println("La vista ha finalizado.");
    }

    private void ejecutarOpcion(Opcion opcion)  {
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
                mostrarReservas();
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
            List<Huesped> huespedes =controlador.getHuespedes();
            huespedes.sort(Comparator.comparing(Huesped::getNombre));
            for (Huesped i : huespedes){
                System.out.println(i);
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
            List<Habitacion> habitaciones =controlador.getHabitaciones();
            habitaciones.sort(Comparator.comparing(Habitacion::getPlanta).thenComparing(Habitacion::getPuerta));
            for (Habitacion i : habitaciones){
                System.out.println(i);
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
    private  void listarReservas(Huesped huesped){
        try {
            Comparator<Huesped> huespedComparator=Comparator.comparing(Huesped::getNombre);
            List<Reserva> reservas =controlador.getReservas(huesped);
            reservas.sort(Comparator.comparing(Reserva::getFechaInicioReserva).reversed().thenComparing(Reserva::getHuesped,huespedComparator));
            for (Reserva i : reservas){

                System.out.println(i);
            }
        }catch (NullPointerException | IllegalArgumentException e)  {
            System.out.println(e.getMessage());
        }
    }
    private  void listarReservas(TipoHabitacion tipoHabitacion){
        try {
            List<Reserva> reservas =controlador.getReservas(tipoHabitacion);
            Comparator<Habitacion> habitacionComparator=Comparator.comparing(Habitacion::getPlanta).
                    thenComparing(Habitacion::getPuerta);
            reservas.sort(Comparator.comparing(Reserva::getFechaInicioReserva).reversed().
                    thenComparing(Reserva::getHabitacion,habitacionComparator));
            for (Reserva i : reservas){
                System.out.println(i);
            }
        }catch (NullPointerException | IllegalArgumentException e)  {
            System.out.println(e.getMessage());
        }
    }
    private  List<Reserva> getReservasAnulables(List<Reserva> reservaAAnular){
        List<Reserva> reservasParaAnular= new ArrayList<>();
        try {
            for (Reserva reserva : reservaAAnular){
                if(reserva.getFechaInicioReserva().isAfter(LocalDate.now()))
                    reservasParaAnular.add(reserva);
            }
        }catch (NullPointerException | IllegalArgumentException e)  {
            System.out.println(e.getMessage());
        }
        return reservasParaAnular;
    }

    private  void anularReserva(){
        try {
            controlador.borrar(Consola.leerReserva());
        }catch (NullPointerException | IllegalArgumentException | OperationNotSupportedException e)  {
            System.out.println(e.getMessage());
        }
    }
    private  void mostrarReservas(){
        try {
            List<Reserva> reservas =controlador.getReservas();
            Comparator<Habitacion> habitacionComparator= Comparator.comparing(Habitacion::getPlanta).thenComparing(Habitacion::getPuerta);
            reservas.sort(Comparator.comparing(Reserva::getFechaInicioReserva).reversed().thenComparing(Reserva::getHabitacion,habitacionComparator));
            for (Reserva i : reservas){
                System.out.println(i);
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

        List<Habitacion> habitacionesTipoSolicitado= controlador.getHabitaciones(tipoHabitacion);

        if (habitacionesTipoSolicitado==null)
            return habitacionDisponible;

        for (int i=0; i<habitacionesTipoSolicitado.size() && !tipoHabitacionEncontrada; i++)
        {

            if (habitacionesTipoSolicitado.get(i) !=null)
            {
                List <Reserva> reservasFuturas = controlador.getReservasFuturas(habitacionesTipoSolicitado.get(i));
                numElementos=getNumElementosNoNulos(reservasFuturas);

                if (numElementos == 0)
                {
                    //Si la primera de las habitaciones encontradas del tipo solicitado no tiene reservas en el futuro,
                    // quiere decir que está disponible.
                    habitacionDisponible=new Habitacion(habitacionesTipoSolicitado.get(i));
                    tipoHabitacionEncontrada=true;
                }
                else {

                    //Ordenamos de mayor a menor las reservas futuras encontradas por fecha de fin de la reserva.
                    // Si la fecha de inicio de la reserva es posterior a la mayor de las fechas de fin de las reservas
                    // (la reserva de la posición 0), quiere decir que la habitación está disponible en las fechas indicadas.

                    Collections.sort(reservasFuturas, Comparator.comparing(Reserva::getFechaFinReserva).reversed());

                    /*System.out.println("\n\nMostramos las reservas ordenadas por fecha de inicio de menor a mayor (numelementos="+numElementos+")");
                    mostrar(reservasFuturas);*/

                    if (fechaInicioReserva.isAfter(reservasFuturas.get(0).getFechaFinReserva())) {
                        habitacionDisponible = new Habitacion(habitacionesTipoSolicitado.get(i));
                        tipoHabitacionEncontrada = true;
                    }

                    if (!tipoHabitacionEncontrada)
                    {
                        //Ordenamos de menor a mayor las reservas futuras encontradas por fecha de inicio de la reserva.
                        // Si la fecha de fin de la reserva es anterior a la menor de las fechas de inicio de las reservas
                        // (la reserva de la posición 0), quiere decir que la habitación está disponible en las fechas indicadas.

                        Collections.sort(reservasFuturas, Comparator.comparing(Reserva::getFechaInicioReserva));

                        /*System.out.println("\n\nMostramos las reservas ordenadas por fecha de inicio de menor a mayor (numelementos="+numElementos+")");
                        mostrar(reservasFuturas);*/

                        if (fechaFinReserva.isBefore(reservasFuturas.get(0).getFechaInicioReserva())) {
                            habitacionDisponible = new Habitacion(habitacionesTipoSolicitado.get(i));
                            tipoHabitacionEncontrada = true;
                        }
                    }

                    //Recorremos el array de reservas futuras para ver si las fechas solicitadas están algún hueco existente entre las fechas reservadas
                    if (!tipoHabitacionEncontrada)
                    {
                        for(int j=1;j<reservasFuturas.size() && !tipoHabitacionEncontrada;j++)
                        {
                            if (reservasFuturas.get(j) !=null && reservasFuturas.get(j - 1) !=null)
                            {
                                if(fechaInicioReserva.isAfter(reservasFuturas.get(j - 1).getFechaFinReserva()) &&
                                        fechaFinReserva.isBefore(reservasFuturas.get(j).getFechaInicioReserva())) {

                                    habitacionDisponible = new Habitacion(habitacionesTipoSolicitado.get(i));
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
    private int getNumElementosNoNulos(List<Reserva> reservas){
        int elementosNoNulos=0;
        for(Reserva reservaNoNula : reservas){
            if(reservaNoNula!=null){
                elementosNoNulos+=1;
            }
        }
        return elementosNoNulos;
    }
    private void realizarCheckin() {

        Huesped huesped= Consola.getHuespedPorDni();
        Huesped huespedRegistrado=controlador.buscar(huesped);
        List<Reserva> listaHuespedRegistrado=controlador.getReservas(huespedRegistrado);
        int i=1;
        for (Reserva reserva : listaHuespedRegistrado){
            System.out.println(i +".-" + reserva);
            i++;
        }
        System.out.println("Elige el numero de reserva desde 1 hasta" + "-." + (i-1) + ".");
        int seleccion = Entrada.entero();
        Reserva reserva= listaHuespedRegistrado.get(seleccion-1);
        LocalDateTime fecha=Consola.leerFechaHora("checkin");


        try {
            controlador.realizarCheckin(reserva,fecha );
        } catch (OperationNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
    private void realizarCheckout()  {
        Huesped huesped= Consola.getHuespedPorDni();
        Huesped huespedRegistrado=controlador.buscar(huesped);
        List<Reserva> listaHuespedRegistrado=controlador.getReservas(huespedRegistrado);
        int i=1;
        for (Reserva reserva : listaHuespedRegistrado){
            System.out.println(i +".-" + reserva);
            i++;
        }
        System.out.println("Elige el numero de reserva desde 1 hasta" + "-." + (i-1) + ".");
        int seleccion = Entrada.entero();
        Reserva reserva= listaHuespedRegistrado.get(seleccion-1);
        LocalDateTime fecha=Consola.leerFechaHora("checkout");


        try {
            controlador.realizarCheckout(reserva,fecha);
        } catch (OperationNotSupportedException e) {
            throw new RuntimeException(e);
        }

    }
}
