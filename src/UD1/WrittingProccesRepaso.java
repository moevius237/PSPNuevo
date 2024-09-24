package UD1;

import java.io.*;

public class WrittingProccesRepaso {
    public static void main(String[] args) {
        /*
        String cos [] = {"ls","macaco"};
        ProcessBuilder pb = new ProcessBuilder(cos);
        try {
            Process p = pb.start();
             try (BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()))){
                 String linea;
                 while ((linea = br.readLine())!= null){
                     System.out.println(linea);
                 }
             }
            p.waitFor();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

         */
        String cos[] = {"bash"};
        ProcessBuilder pb = new ProcessBuilder(cos);
        pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        pb.redirectInput(ProcessBuilder.Redirect.INHERIT);


        try {
            Process p = pb.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // pb.redirectError(ProcessBuilder.Redirect.INHERIT);

        //pb.inheritIO();
        /*
        try {
            Process p = pb.start();
            try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()))) {
                bw.write("ls");
                bw.newLine();
                bw.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }0
         */
    }
}