
package Modelo;

public class Felino extends Mascota{

    public boolean getTaxo() {
        return taxo;
    }

    public void setTaxo(boolean taxo) {
        this.taxo = taxo;
    }
    private boolean taxo;
    
      public Felino(String nombre, String raza, String color, int edad, boolean disponibilidad, int nivelEnt, boolean taxo) {
        super(nombre, raza, color, edad, disponibilidad);
        this.taxo=taxo;
    }
    
}
