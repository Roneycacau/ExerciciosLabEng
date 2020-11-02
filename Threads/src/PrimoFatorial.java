import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class PrimoFatorial implements Runnable {
    private int id;
    private int num;

    public PrimoFatorial(int id, int num) {
        this.id = id;
        this.num = num;
    }

    public static void main(String[] args) {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a quantidade de números (inteiros) que deseja calcular se é primo e o fatorial: ");
        int qtd = r.ints(1, 50).findFirst().getAsInt();
        System.out.println(qtd      );
//        int qtd = sc.nextInt();

        int[] numeros = new int[qtd];
        for (int i = 0; i < qtd; i++) {
            System.out.println("Digite o " + (i + 1) + "º número que deseja calcular (entre 0 e 200):");
            numeros[i] = r.ints(1, 300).findFirst().getAsInt();
//            numeros[i] = sc.nextInt();
        }
        sc.close();
        for (int i = 0; i < qtd; i++) {
            for (int j = 0; j < 2; j++) {
                PrimoFatorial t = new PrimoFatorial(j, numeros[i]);
                Thread thread = new Thread(t);
                thread.start();
            }
        }

    }

    @Override
    public void run() {
        if (id == 0) {
            if (ehPrimo(num)) {
                System.out.println("O número " + num + " é primo");
            } else {
                System.out.println("O número " + num + " não é primo");
            }
        } else {
            System.out.println("O fatorial do número " + num + " é igual a " + fatorial(num));
        }

    }

    private boolean ehPrimo(int n) {
        for (int j = 2; j < n; j++) {
            if (n % j == 0)
                return false;
        }
        return true;
    }

    private BigInteger fatorial(int n) {
        if (n == 0) return BigInteger.ONE;
        BigInteger fat = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            BigInteger indice = BigInteger.valueOf(i);
            fat = fat.multiply(indice);
        }
        return fat;
    }

}
