import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Reader {

    public static void main(String[] args) {
        String filename = "numbers.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filename));) {
            String line;
            while ((line = reader.readLine()) != null) {
                String original = line.trim();
                int doubled = Integer.parseInt(original) * 2;
                String output = original + " => " + doubled;
                System.out.println(output);
            }

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}