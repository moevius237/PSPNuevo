package UD1.Tarea2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Ej3 {
    public static void main(String[] args) {
        String [] co = {"bash"};
        ProcessBuilder pb = new ProcessBuilder(co);
        Process p;
        try {
            p = pb.start();
            try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()))){
                bw.write("ls");
                bw.newLine();
                bw.flush();
            } catch (IOException e) {
            throw new RuntimeException(e);
        }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
