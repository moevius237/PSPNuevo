package UD1.Tarea2;

import java.io.*;

public class Ej5 {
    public static void main(String[] args) {
//en windows cmd, en linux bash
        ProcessBuilder pb = new ProcessBuilder(new String[]{"bash"});
        Process process = null;
        pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        //The only thing i do is erase the BufferedReader and sustitute for the redirectOutput
        try {
            process = pb.start();
            try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()))) {
                bw.write("dir");
                bw.newLine();
                bw.flush();
                bw.write("exit");
                bw.newLine();
                bw.flush();
            }
            System.out.println(process.waitFor());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
