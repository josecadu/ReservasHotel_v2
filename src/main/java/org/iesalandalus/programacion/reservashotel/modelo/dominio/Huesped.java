package org.iesalandalus.programacion.reservashotel.modelo.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


    public class Huesped {
        private final String ER_TELEFONO = "[967]\\d{8}";
        private final String ER_CORREO = "([A-Za-z0-9_.-]+[@]+[A-Za-z0-9]+[.]+[a-zA-Z]+$)";
        private final String ER_DNI = "([0-9]{8})([A-Za-z]{1})";
        public static final DateTimeFormatter FORMATO_FECHA= DateTimeFormatter.ofPattern("dd/MM/yyyy") ;

        private String nombre;
        private String telefono;
        private String correo;
        private  String dni;
        private LocalDate fechaNacimiento;

        private String formateaNombre(String nombre){
            String[] nombreInsertado = nombre.trim().toLowerCase().split("\\s+");
            String palabra;
            String nombreFormatea = "";
            for (int i =0; i< nombreInsertado.length;i++){
                palabra=nombreInsertado[i].trim();
                String inicial=palabra.toUpperCase().charAt(0)+"";
                String restoNombre=palabra.substring(1,palabra.length());
                String inicialMasRestoNombre= inicial+restoNombre+"";
                nombreFormatea += inicialMasRestoNombre;
                nombre=nombreFormatea;
            }

            return nombre;
        }

        private Boolean comprobarLetraDni(String dni){
            Boolean dniBueno= false;
            Pattern patron;
            Matcher comparador;
            patron = Pattern.compile(ER_DNI);
            comparador = patron.matcher(dni);
            if(comparador.matches()){
                int numDni =Integer.parseInt(comparador.group(1));
                String letraDni= comparador.group(2);
                String[] letra ={"T","R","W","A","G","M","Y","F","P","D","X",
                        "B","N","J","Z","S","Q","V","H","L","C","K","E"};
                if (letraDni.toUpperCase().equals(letra[numDni % 23])){
                    dniBueno=true;
                }
            }
            return dniBueno;
        }
        private String getIniciales(){
            String[] nombreCompleto =nombre.trim().toUpperCase().split("\\s+");
            String palabra;
            String letra;
            String iniciales="";
            for(int i=0;i<nombreCompleto.length;i++){
                palabra= nombreCompleto[i].trim();
                letra=palabra.charAt(0)+"";
                iniciales += letra;
            }
            return  iniciales;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Huesped huesped)) return false;
            return Objects.equals(getDni(), huesped.getDni());
        }

        @Override
        public String toString() {
            return "Huesped{" +
                    "nombre='" + nombre + '\'' +" "+getIniciales()+
                    ", telefono='" + telefono + '\'' +
                    ", correo='" + correo + '\'' +
                    ", dni='" + dni + '\'' +
                    ", fechaNacimiento=" + fechaNacimiento +
                    '}';
        }

        @Override
        public int hashCode() {
            return Objects.hash(getDni());
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            if (nombre==null)
                throw new NullPointerException("ERROR: El nombre no puede ser nulo.");
            if (nombre.trim().isEmpty())
                throw new IllegalArgumentException("ERROR: El nombre no puede estar en blanco.");
            this.nombre = formateaNombre(nombre);
        }

        public String getTelefono() {
            return telefono;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }

        public String getCorreo() {
            return correo;
        }

        public void setCorreo(String correo) {
            if (correo == null)
                throw new NullPointerException("ERROR: El correo de un huesped no puede ser nulo.");
            if (!correo.matches(ER_CORREO))
                throw new IllegalArgumentException("ERROR: El correo del huesped no tiene un formato válido.");
            this.correo = correo;
        }
        public String getDni() {

            return dni;
        }

        private void setDni(String dni) {
            if(dni==null)
                throw new NullPointerException("ERROR: El dni no puede ser nulo.");
            if(!dni.matches(ER_DNI))
                throw new IllegalArgumentException("ERROR: El dni del huesped no tiene un formato valido.");
            if(!comprobarLetraDni(dni.toUpperCase()))
                throw new IllegalArgumentException("ERROR: La letra del dni del cliente no es correcta.");
            this.dni = dni;
        }

        public LocalDate getFechaNacimiento() {
            return fechaNacimiento;
        }

        private void setFechaNacimiento(LocalDate fechaNacimiento) {
            this.fechaNacimiento = fechaNacimiento;
        }

        public  Huesped(String nombre, String dni, String correo, String telefono, LocalDate fechaNacimiento){
            setNombre(nombre);
            setDni(dni);
            setCorreo(correo);
            setTelefono(telefono);
            setFechaNacimiento(fechaNacimiento);
        }
        public  Huesped(Huesped huesped){
            if(huesped == null)
                throw new NullPointerException("ERROR: El huesped no puede ser nulo.");
            setNombre(huesped.getNombre());
            setDni(huesped.getDni());
            setCorreo(huesped.getCorreo());
            setTelefono(huesped.getTelefono());
            setFechaNacimiento(huesped.getFechaNacimiento());

        }

    }



