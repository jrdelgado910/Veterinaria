
package Modelo;

public class Canino extends Mascota{

    public String getNivelEnt() {
        return nivelEnt;
    }

    public void setNivelEnt(String nivelEnt) {
        this.nivelEnt = nivelEnt;
    }
    private String nivelEnt;
    

    public Canino(String nombre, String raza, String color, int edad, boolean disponibilidad, String nivelEnt) {
        super(nombre, raza, color, edad, disponibilidad);
        this.nivelEnt=nivelEnt;
    }
    
}
