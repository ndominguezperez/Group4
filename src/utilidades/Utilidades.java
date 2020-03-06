package utilidades;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Utilidades {
    public static String leer() {

        BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));
        String leido = "ERROR";
        try {
            leido = consola.readLine();
        } catch (IOException ex) {
            System.out.println("Hay un error");
        }
        return leido;
    }

}
