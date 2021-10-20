
package Principal;
import Modelo.*;
import Vista.*;
import Controlador.Controlador;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Inicio {
       public static void main(String arf[]){
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(UnsupportedLookAndFeelException e){
        }catch(ClassNotFoundException e){
        }catch(InstantiationException e){
        }catch(IllegalAccessException e){
        }
        Mascota mascota = new Mascota();
        VistaUno vista =new VistaUno();
        VistaDos vistaDos =new VistaDos();
        Controlador controlador = new Controlador(vista, vistaDos, mascota);
        controlador.Iniciar();

    }

       
    
}
