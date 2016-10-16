package lectoritems;

import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Paulker
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            Lector lector = new Lector("ITEMS2.txt");
            Date inicio = new Date();
            lector.iniciar();
            Date fin = new Date();

            System.out.println("####Se tomo :" + ((fin.getTime() - inicio.getTime()) / 1000.0) + " segundos en terminar");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
