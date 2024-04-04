package org.iesalandalus.programacion.reservashotel.vista;

public enum Opcion {
    SALIR("salir",1),INSERTAR_HUESPED("insertar huesped",2),BUSCAR_HUESPED("buscar huesped",3),BORRAR_HUESPED("borrar huesped",4),
    MOSTRAR_HUESPEDES("mostrar huespedes",5),INSERTAR_HABITACION("insertar habitación",6), BUSCAR_HABITACION("buscar habitación",7),
    BORRAR_HABITACION("borrar habitación",8),MOSTRAR_HABITACIONES("mostrar habitaciones",9), INSERTAR_RESERVA("insertar reserva",10),
    ANULAR_RESERVA("anular reserva",11), MOSTRAR_RESERVAS("mostrar reservas",12),CONSULTAR_DISPONIBILIDAD("consultar disponibilidad",13),
    REALIZAR_CHECKIN("realizar checkin",14),REALIZAR_CHECKOUT("realizar checkout",15);
    private String mensajeAMostrar;
    private int ordinal;
    private Opcion(String mensajeAMostrar,int ordinal){
        this.mensajeAMostrar=mensajeAMostrar;
        this.ordinal=ordinal;
    }
    @Override
    public String toString() {

        return ordinal +".-"+mensajeAMostrar;
    }
}
