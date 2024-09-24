package UD1.Tarea2;

import java.io.*;

public class Ej4 {
    //THis code list in your current directory, all the files and directories but the code never ends,
    //The error is hapenning because the pipe is broken , that is because you can't use two times the same BufferedWriter, when the writter ends the first time close himself and that cause error
    public static void main(String[] args) {
//en windows cmd, en linux bash
        ProcessBuilder pb = new ProcessBuilder(new String[]{"bash"});
        Process process = null;
        try {
            process = pb.start();
            try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
                 BufferedReader br = new BufferedReader(new
                         InputStreamReader(process.getInputStream()))) {
                bw.write("dir");
                bw.newLine();
                bw.flush();
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
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
