import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LerArquivo {
    public static void main(String[] args) {
        File file = new File("InputOutputFilter/files/nome.txt");
        try (FileReader fr = new FileReader(file)){
            int i = 0;
            while ((i = fr.read() )!= -1){
                System.out.println((char)i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
