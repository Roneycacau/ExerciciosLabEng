import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Invasao {
    public static void main(String[] args) {
        String msg = "[ATTACK DISABLED]\r\n" +
                "[UNLOCK SYSTEM]";
        for (int i = 1; i < 255; i++) {
            String ip = "172.16.168."+ i;
            System.out.println(ip);
            try {
                Socket s = new Socket(ip, 1110);
                OutputStream out = s.getOutputStream();
                OutputStreamWriter outw = new OutputStreamWriter(out);
                BufferedWriter bfw = new BufferedWriter(outw);
                bfw.write(msg);
                bfw.flush();
                bfw.close();
                s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
