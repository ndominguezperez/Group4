package utilities;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Utilities {
    public static String read() {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String read = "ERROR";
        try {
            read = console.readLine();
        } catch (IOException ex) {
            System.out.println("ERROR");
        }
        return read;
    }

}
