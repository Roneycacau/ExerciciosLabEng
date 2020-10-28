import java.io.*;

public class TransformacaoDeArquivo {
    public static void main(String[] args) {
        File in = fillFile();
        File out = new File("InputOutputFilter/files/b.csv");

        try {
            FileReader fr = new FileReader(in);
            FileWriter fw = new FileWriter(out);
            BufferedReader br = new BufferedReader(fr);
            BufferedWriter bw = new BufferedWriter(fw);
            while(br.ready()) {
                bw.append(converteNota(br.readLine()+"\n"));
            }
            bw.flush();
            br.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static File fillFile() {
        File in =  new File("InputOutputFilter/files/a.csv");
        String originData = "Antonio Rodrigues; 6,5" +
                "\nKatia Toledo; 7,4" +
                "\nGuilherme Prado; 4,6";

        try {
            FileWriter fw = new FileWriter(in);
            fw.write(originData);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return in;
    }

    static String converteNota (String a) {
        String nota = a.substring(a.indexOf(';')+1);
        double notaConvertida = Double.parseDouble(nota.replace(',', '.'));
        if (notaConvertida >= 9.0) {
            a = a.replace(nota, " 10,0\n");
        } else {
            notaConvertida += 1.0;
            a = a.replace(nota, " "+notaConvertida+"\n").replace('.', ',');
        }
        return a;
    }
}
