package org.iesalandalus.programacion.reservashotel.modelo.negocio;



import javax.naming.OperationNotSupportedException;
import java.org.iesalandalus.programacion.reservashotel.modelo.dominio.Huesped;

public class Huespedes {
    private int capacidad;
    private int tamano;
    private Huesped[] coleccionHuespedes;
    public Huespedes(int capacidad){
        this.capacidad=capacidad;
        this.coleccionHuespedes=new Huesped[capacidad];
        tamano=0;
    }

    public int getTamano() {
        return tamano;
    }

    public int getCapacidad() {
        return capacidad;
    }
    public Huesped[] get(){

        return copiaProfundaHuespedes();
    }
    private Huesped[] copiaProfundaHuespedes(){
        Huesped[] copiaProfunda=new Huesped[capacidad];
        for (int i =0;i<coleccionHuespedes.length;i++){
            copiaProfunda[i]=(coleccionHuespedes[i]);
        }
        return copiaProfunda;
    }
    public void insertar(Huesped huesped) throws OperationNotSupportedException {
        if(huesped==null)
            throw  new NullPointerException("ERROR: No se puede insertar un huesped nulo.");
        if(capacidadSuperada(buscarIndice(huesped)))
            throw new OperationNotSupportedException("ERROR: No se aceptan mas huespedes.");
        if(!tamanoSuperado(buscarIndice(huesped)))
            throw  new OperationNotSupportedException("ERROR: Ya hay un huesped con ese dni.");
        coleccionHuespedes[buscarIndice(huesped)]=new Huesped(huesped);
        tamano++;
        System.out.println("El huesped se añadio correctamente");
    }
    private int buscarIndice(Huesped huesped){
        int indice=-1;
        boolean find=false;
        for (int i=0;i<coleccionHuespedes.length && !find;i++){
            if(coleccionHuespedes[i] != null &&coleccionHuespedes[i].equals(huesped)){
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
    public Huesped buscar(Huesped huesped){
        if(huesped==null){
            throw  new NullPointerException("ERROR: No se puede buscar un huesped nulo.");
        }
        Huesped huesped1= null;
        boolean find=false;
        for(int i=0 ; i< coleccionHuespedes.length && !find ; i++){
            if(coleccionHuespedes[i] != null && coleccionHuespedes[i].equals(huesped)){
                huesped1=coleccionHuespedes[i];
                find= true;
            }
        }
        return huesped1;
    }
    public void borrar(Huesped huesped) throws OperationNotSupportedException {
        if(huesped==null){
            throw new NullPointerException("ERROR: No se puede borrar un huesped nulo.");
        }
        int indice =buscarIndice(huesped);
        if (indice==-1){
            throw new OperationNotSupportedException("ERROR: No existe ningun huesped como el indicado.");
        }
        else {
            desplazarPosicionHaciaIzquierda(indice);
            tamano--;
            System.out.println("El huesped ha sido borrado.");
        }

    }
    private void desplazarPosicionHaciaIzquierda(int indice){
        for(int i=indice;i< coleccionHuespedes.length-1 && coleccionHuespedes[i]!=null;i++){
            coleccionHuespedes[i]=coleccionHuespedes[i+1];
        }
    }
}
