import java.io.*;

public class ConverterCaracteres {
    public static void main(String[] args) throws IOException {
        File file = new File("InputOutputFilter/files/texto.txt");
        StringBuilder input = new StringBuilder();
        String temp = "";
        System.out.println("Digite um nome, para sair digite SAIR");

        InputStream is = System.in;
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        while (!s.toString().equals("SAIR")) {
            System.out.println("Digite um nome, para sair digite SAIR");
            temp = s.toUpperCase().replace("I", "1")
                    .replace("Z", "2")
                    .replace("E", "3")
                    .replace("A", "4")
                    .replace("S", "5")
                    .replace("G", "6")
                    .replace("T", "7")
                    .replace("B", "8")
                    .replace("q", "9")
                    .replace("O", "0");
            input.append(temp);
            input.append("\n");
            System.out.println(temp);
            s = br.readLine();
        }
        try {
            FileWriter fw = new FileWriter(file);
            fw.write(input.toString());
            fw.close();
        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }
}
