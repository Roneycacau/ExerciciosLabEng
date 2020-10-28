import java.io.*;
import java.util.Scanner;

public class CopiarArquivoTexto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String path = "InputOutputFilter/files";
        File file;

        do {
            System.out.println("Digite o nome e extensão do arquivo do diretório "
                    + path + " que deseja copiar (Exemplo: Nome.txt)");
            String nome = sc.nextLine();
            file = new File(path + "/" + nome);
            if (!file.exists() || !file.isFile()) {
                String[] opcoes = {"Digitar", "Sair"};
                System.out.println("O arquivo digitado não existe ou não é um arquivo válido! Digite novamente o nome do arquivo com a extensão ou SAIR ?");
                String opc = sc.nextLine();
                if (opc.equalsIgnoreCase("SAIR")) {
                    System.exit(0);
                }
            }
        } while (!file.exists() || !file.isFile());
        System.out.println("Digite o nome e extensão do arquivo com a extensão que deseja gravar");
        String nome2 = sc.nextLine();
        File file2 = new File(path + "/" + nome2);

        try {
            FileReader fr = new FileReader(file);
            FileWriter fw = new FileWriter(file2);
            BufferedReader br = new BufferedReader(fr);
            BufferedWriter bw = new BufferedWriter(fw);
            while (br.ready()) {

                bw.append(br.readLine().toUpperCase().replace("I", "1")
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
            br.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
