import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anantoni
 */
public class Generator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Invalid usage: pass number of lines as command line param");
            System.exit(-1);
        }
        int lines = Integer.parseInt(args[0]);
        Random  rand= new Random();
        PrintWriter writer;
        try {
            writer = new PrintWriter("mock-data.txt", "UTF-8");
            while (lines > 0) {
                writer.println(rand.nextInt() + "|" + rand.nextInt());
                lines--;
            }
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(Generator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
