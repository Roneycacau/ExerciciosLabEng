import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GravaNome {
    public static void main(String[] args) {
        File dir = new File("InputOutputFilter/files");
        String nome = "Roney Cacau";
        if(!dir.exists()){
            dir.mkdirs();
        }
        File file = new File(dir,"nome.txt");
        try {
            FileWriter fw = new FileWriter(file);
            fw.write(nome);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
