package UD1.Tarea2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class EJ6 {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("cmd");
        pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        pb.redirectError(ProcessBuilder.Redirect.INHERIT);
        Scanner sc = new Scanner(System.in);
        try {
             Process process = pb.start();
            try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()))) {
                bw.write("nslookup");
                bw.newLine();
                bw.flush();
                while (true) {
                    System.out.println("Escribe");
                    String escrito = sc.next();
                    bw.write(escrito);
                    bw.newLine();
                    bw.flush();
                    if (escrito.equals("exit")){
                        break;
                    }
                }
            }
            System.out.println(process.waitFor());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
