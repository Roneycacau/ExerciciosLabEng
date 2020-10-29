import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LeituraOrdenacaoEscrita {
    public static void main(String[] args) {
        File entrada = new File("InputOutputFilter/files/WindowsUpdate.log");
        File saida = new File("InputOutputFilter/files/Ordenado.txt");
        List<String> lista = new ArrayList<String>();

        try {
            FileReader fr = new FileReader(entrada);
            FileWriter fw = new FileWriter(saida);
            BufferedReader br = new BufferedReader(fr);
            BufferedWriter bw = new BufferedWriter(fw);
            while (br.ready()) {
                lista.add(br.readLine());
            }
            ordenaLog(lista);

            for (String i : lista) {
                bw.append(i + "\n");
            }

            bw.flush();
            br.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void ordenaLog(List<String> lista) {

        lista.sort((o1, o2) -> {
            DateTimeFormatter dtf = new DateTimeFormatterBuilder().
                    appendPattern("yyyy/MM/dd[ [HH][:mm][:ss][.SSSSSSS]]").
                    parseDefaulting(ChronoField.HOUR_OF_DAY, 0).
                    parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0).
                    parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
                    .toFormatter();
            LocalDateTime dt1 = LocalDateTime.parse(o1.substring(0, 27), dtf);
            LocalDateTime dt2 = LocalDateTime.parse(o2.substring(0, 27), dtf);

            return dt1.isAfter(dt2) ? -1 : (dt1.isBefore(dt2) ? +1 : 0);
        });


    }
}

