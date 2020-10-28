import java.io.*;
import java.util.Scanner;

public class ListarNomes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String path = "InputOutputFilter/files";
        File f = new File(path + "/" + "texto.txt");
        try {
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            String nome = "";
            while (!nome.equalsIgnoreCase("sair")) {
                System.out.println("Digite um nome para listar no arquivo ou digite sair para encerrar:");
                nome = sc.nextLine();
                bw.append(nome.toUpperCase().replace("I", "1")
                        .replace("Z", "2")
                        .replace("E", "3")
                        .replace("A", "4")
                        .replace("S", "5")
                        .replace("G", "6")
                        .replace("T", "7")
                        .replace("B", "8")
                        .replace("O", "0") + "\n");
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
