package org.iesalandalus.programacion.reservashotel.modelo.negocio;



import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.reservashotel.modelo.dominio.Huesped;

import java.util.ArrayList;
import java.util.List;

public class Huespedes {
    private List<Huesped> coleccionHuespedes;

    public Huespedes() {
        List<Huesped> coleccionHuespedes = new ArrayList<>();
    }

    public int getTamano() {
        return coleccionHuespedes.size();
    }

    public List<Huesped> get() {

        return copiaProfundaHuespedes();
    }

    private List<Huesped> copiaProfundaHuespedes() {
        List<Huesped> copiaColeccion = new ArrayList<>();
        copiaColeccion.addAll(coleccionHuespedes);
        return copiaColeccion;
    }

    public void insertar(Huesped huesped) throws OperationNotSupportedException {
        if (huesped == null)
            throw new NullPointerException("ERROR: No se puede insertar un huesped nulo.");
        if (coleccionHuespedes.contains(huesped))
            throw new OperationNotSupportedException("ERROR: Ya hay un huesped con ese dni.");
        Huesped nuevoHuesped = new Huesped(huesped);
        coleccionHuespedes.add(nuevoHuesped);
        System.out.println("El huesped se añadio correctamente");
    }

    public Huesped buscar(Huesped huesped) throws OperationNotSupportedException {
        if (huesped == null) {
            throw new NullPointerException("ERROR: No se puede buscar un huesped nulo.");
        }
        if (!coleccionHuespedes.contains(huesped)) {
            throw new OperationNotSupportedException("ERROR: No existe ningun huesped con ese dni.");
        }
        int indice = coleccionHuespedes.indexOf(huesped);
        if (indice != -1)
            return coleccionHuespedes.get(indice);
        else
            return null;
    }

    public void borrar(Huesped huesped) throws OperationNotSupportedException {
            if (huesped == null) {
                throw new NullPointerException("ERROR: No se puede borrar un huesped nulo.");
            }

            if (!coleccionHuespedes.contains(huesped)) {
                throw new OperationNotSupportedException("ERROR: No existe ningun huesped como el indicado.");
            }

                coleccionHuespedes.remove(huesped);
                System.out.println("El huesped ha sido borrado.");


        }

    }

