package org.iesalandalus.programacion.reservashotel.vista;


import org.iesalandalus.programacion.utilidades.Entrada;

import java.org.iesalandalus.programacion.reservashotel.modelo.dominio.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Consola {
    private Consola() {

    }
    public static void mostrarMenu(){
        System.out.println("__________________BIENVENIDO__________________");
        System.out.println("___Este es el programa de reservas de hotel___");
        System.out.println("______________________________________________");
        System.out.println("___________________OPCIONES___________________");
        System.out.println("______________________________________________");
        System.out.println("____________1________SALIR____________________");
        System.out.println("____________2___INSERTAR_HUESPED______________");
        System.out.println("____________3___BUSCAR_HUESPED________________");
        System.out.println("____________4___BORRAR_HUESPED________________");
        System.out.println("____________5___MOSTRAR_HUESPEDES_____________");
        System.out.println("____________6___INSERTAR_HABITACION___________");
        System.out.println("____________7___BUSCAR_HABITACION_____________");
        System.out.println("____________8___BORRAR_HABITACION_____________");
        System.out.println("____________9___MOSTRAR_HABITACIONES__________");
        System.out.println("____________10__INSERTAR_RESERVA-_____________");
        System.out.println("____________11__ANULAR_RESERVA________________");
        System.out.println("____________12__MOSTRAR_RESERVAS______________");
        System.out.println("____________13__CONSULTAR_DISPONIBILIDAD______");
        System.out.println("____________14__REALIZAR_CHECKIN______________");
        System.out.println("____________15__REALIZAR_CHECKOUT_____________");
        System.out.println("______________________________________________");

    }
    public static Opcion elegirOpcion(){
        Opcion seleccion=null;
        boolean i =false;
        System.out.println("Elija una opcion:");
        int opcion= Entrada.entero();
        switch (opcion){
            case 1: {
                System.out.println("selecciono salir.");
                seleccion=Opcion.SALIR;
                break;
            }
            case 2: {
                System.out.println("selecciono insertar huesped.");
                seleccion=Opcion.INSERTAR_HUESPED;
                break;
            }
            case 3: {
                System.out.println("selecciono buscar huesped.");
                seleccion=Opcion.BUSCAR_HUESPED;
                break;
            }
            case 4: {
                System.out.println("seleciono borrar huesped.");
                seleccion=Opcion.BORRAR_HUESPED;
                break;
            }
            case 5: {
                System.out.println("selecciono mostrar huespedes.");
                seleccion=Opcion.MOSTRAR_HUESPEDES;
                break;
            }
            case 6: {
                System.out.println("selecciono insertar habitación.");
                seleccion=Opcion.INSERTAR_HABITACION;
                break;
            }
            case 7: {
                System.out.println("selecciono buscar habitación.");
                seleccion=Opcion.BUSCAR_HABITACION;
                break;
            }
            case 8: {
                System.out.println("selecciono borrar habitación.");
                seleccion=Opcion.BORRAR_HABITACION;
                break;
            }
            case 9: {
                System.out.println("selecciono mostrar habitaciones.");
                seleccion=Opcion.MOSTRAR_HABITACIONES;
                break;
            }
            case 10: {
                System.out.println("selecciono insertar reserva.");
                seleccion=Opcion.INSERTAR_RESERVA;
                break;
            }
            case 11: {
                System.out.println("seleeciono anular reserva.");
                seleccion=Opcion.ANULAR_RESERVA;
                break;
            }
            case 12: {
                System.out.println("selecciono mostrar reservas.");
                seleccion=Opcion.MOSTRAR_RESERVAS;
                break;
            }
            case 13: {
                System.out.println("selecciono consultar disponibilidad.");
                seleccion=Opcion.CONSULTAR_DISPONIBILIDAD;
                break;
            }
            case 14: {
                System.out.println("selecciono realizar checkin.");
                seleccion=Opcion.REALIZAR_CHECKIN;
                break;
            }
            case 15: {
                System.out.println("selecciono realizar checkout.");
                seleccion=Opcion.REALIZAR_CHECKOUT;
                break;
            }
        }
        return seleccion;
    }
    public static Huesped leerHuesped(){
        String nombre,dni,correo,telefono;   LocalDate fechaNacimiento;

        System.out.println("");
        System.out.println("introduce los datos del cliente");
        System.out.println("");
        System.out.println("Nombre:");
        nombre = Entrada.cadena();
        System.out.println("Dni:");
        dni = Entrada.cadena();
        System.out.println("Correo:");
        correo = Entrada.cadena();
        System.out.println("telefono:");
        telefono = Entrada.cadena();
        System.out.println("fecha de nacimiento:");
        fechaNacimiento = LocalDate.parse(Entrada.cadena(),Huesped.FORMATO_FECHA);

        Huesped huesped = new Huesped(nombre,dni,correo,telefono,fechaNacimiento);
        return huesped;
    }
    public static Huesped getHuespedPorDni(){
        String dni;
        dni=Entrada.cadena();
        Huesped huespedDni= new Huesped("jose",dni,"jm.daenas@hotmail.com","656659765",LocalDate.of(1988,04,26));
        return huespedDni;
    }
    public static LocalDate leerFecha(String mensaje){
        System.out.println("introduzca la fecha de "+mensaje+" con el formato adecuado.");
        LocalDate fecha= LocalDateTime.parse(Entrada.cadena(),Huesped.FORMATO_FECHA);
        return fecha;
    }
    public static LocalDate leerFecha(String mensaje){
        System.out.println("introduzca la fecha de "+mensaje+" con el formato adecuado.");
        LocalDate fecha=LocalDate.parse(Entrada.cadena(),Huesped.FORMATO_FECHA);
        return fecha;
    }
    public static Habitacion leerHabitacion(){
        Habitacion habitacion = null;
        try {
            System.out.println("introduzca los datos de la habitacion.");
            int planta=0;
            System.out.println("introduzca el numero de planta entre 1 y 3:");
            planta = Entrada.entero();
            while (planta < habitacion.MIN_NUMERO_PLANTA || planta > habitacion.MAX_NUMERO_PLANTA) {
                System.out.println("ese no es un numero de planta valido.");
                System.out.println("introduzca el numero de planta entre 1 y 3:");
                planta = Entrada.entero();
            }
            int puerta =16;
            System.out.println("introduzca el numero de puerta entre 0 y 14:");
            puerta = Entrada.entero();
            while (puerta < habitacion.MIN_NUMERO_PUERTA || puerta > habitacion.MAX_NUMERO_PUERTA) {
                System.out.println("ese no es un numero de puerta valido.");
                System.out.println("introduzca el numero de puerta entre 0 y 14:");
                puerta = Entrada.entero();
            }
            TipoHabitacion tipoHabitacion = leerTipoHabitacion();
            habitacion = new Habitacion(planta, puerta, habitacion.getPrecio(),
                    leerTipoHabitacion(), habitacion.getIndentificador());
        }catch (IllegalArgumentException e){
            System.out.println("ERROR: La habitación no se puede crear con esos parámetros.");
        }        return habitacion;
    }
    public static Habitacion leerHabitacionPorIdentificador() {
        Habitacion habitacion = null;
        int planta = 0;
        int puerta = 16;
        System.out.println("introduzca el numero de planta entre 1 y 3:");
        planta = Entrada.entero();
        while (planta < habitacion.MIN_NUMERO_PLANTA || planta > habitacion.MAX_NUMERO_PLANTA) {
            System.out.println("ese no es un numero de planta valido.");
            System.out.println("introduzca el numero de planta entre 1 y 3:");
            planta = Entrada.entero();
        }

        System.out.println("introduzca el numero de puerta entre 0 y 14:");
        puerta = Entrada.entero();
        while (puerta < habitacion.MIN_NUMERO_PUERTA || puerta > habitacion.MAX_NUMERO_PUERTA) {
            System.out.println("ese no es un numero de puerta valido.");
            System.out.println("introduzca el numero de puerta entre 0 y 14:");
            puerta = Entrada.entero();
        }
        habitacion=new Habitacion(planta,puerta,habitacion.getPrecio(),TipoHabitacion.DOBLE,"301");
        return habitacion;
    }
    public static TipoHabitacion leerTipoHabitacion(){
        TipoHabitacion tipoHabitacion=null;
        int seleccion=0;
        while (seleccion< 1 || seleccion>4) {

            System.out.println("introduzca el tipo de habitacion:");
            System.out.println("1.Suite");
            System.out.println("2.Simple");
            System.out.println("3.Doble");
            System.out.println("4.Triple");
            seleccion = Entrada.entero();
            switch (seleccion) {
                case 1: {
                    tipoHabitacion = TipoHabitacion.SUITE;
                    break;
                }
                case 2: {
                    tipoHabitacion = TipoHabitacion.SIMPLE;
                    break;
                }
                case 3: {
                    tipoHabitacion = TipoHabitacion.DOBLE;
                    break;
                }
                case 4: {
                    tipoHabitacion = TipoHabitacion.TRIPLE;
                    break;
                }
            }
        }
        return tipoHabitacion;

    }
    public static Regimen leerRegimen(){
    Regimen regimen=null;
    int seleccion=0;
        System.out.println("Elija un tipo de regimen.");
        System.out.println("1. Solo alojamiento.");
        System.out.println("2. Alojamiento con desayuno.");
        System.out.println("3. Media pensión");
        System.out.println("4. Pensión completa");
        seleccion=Entrada.entero();

        while (seleccion<1 || seleccion>4) {
            System.out.println("introduzca una opcion entre 1 y 4.");
            seleccion= Entrada.entero();
        }


        switch (seleccion){
            case 1: {
                regimen=Regimen.SOLO_ALOJAMIENTO;
                break;
            }
            case 2: {
                regimen=Regimen.ALOJAMIENTO_DESAYUNO;
                break;
            }
            case 3: {
                regimen=Regimen.MEDIA_PENSION;
                break;
            }
            case 4: {
                regimen=Regimen.PENSION_COMPLETA;
                break;
            }
        }
        return regimen;
    }
    public static Reserva leerReserva(){
        Reserva reserva=null;
        System.out.println("introduzca los datos de la reserva");
        Huesped huesped=leerHuesped();
        Habitacion habitacion=leerHabitacion();
        Regimen regimen=leerRegimen();
        LocalDate fechaInicioRes=leerFecha("inicio de reserva");
        LocalDate fechaFinRes=leerFecha("fin de reserva");
        int numeroPersonas=0;
        System.out.println("introduzca el numero de huespedes");
        numeroPersonas=Entrada.entero();
        while (numeroPersonas<1 ||numeroPersonas>habitacion.getTipoHabitacion().getNumeroMaximoPersonas()){
            System.out.println("introduzca un numero valido minimo 1 maximo "
                    +habitacion.getTipoHabitacion().getNumeroMaximoPersonas()+".");
            numeroPersonas=Entrada.entero();
        }

        return reserva= new Reserva(huesped,habitacion,regimen,fechaInicioRes,fechaFinRes,numeroPersonas);
    }

}
