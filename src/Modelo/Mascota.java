
package Modelo;

import java.util.ArrayList;

public class Mascota{

    public String getNombre() {
        return nombre;
    }

    public Mascota() {
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    private String nombre;
    private String raza;
    private String color;
    private int edad;
    private boolean disponibilidad;

    public Mascota(String nombre, String raza, String color, int edad, boolean disponibilidad) {
        this.nombre = nombre;
        this.raza = raza;
        this.color = color;
        this.edad = edad;
        this.disponibilidad = disponibilidad;
    }

    public boolean getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    

    public Mascota(String nombre, String raza, String color, int edad) {
        this.nombre = nombre;
        this.raza = raza;
        this.color = color;
        this.edad = edad;
    }
    
    public int numFeli(int feli){
        return feli;
    }
    public int numCaninos(int can){
        return can;
    }
    
    
    
}
