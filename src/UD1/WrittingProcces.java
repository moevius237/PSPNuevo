package UD1;

import java.io.*;

public class WrittingProcces {
    public static void main(String[] args) {
        ProcessBuilder builder = new ProcessBuilder("dir");
        try {
            Process p = builder.start();
            try(InputStream is = p.getInputStream();
                InputStreamReader ips = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(ips)) {
                String linea;
                while ((linea = br.readLine()) != null){
                    System.out.println(linea);
                }
            }
            try (OutputStream out = p.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(out);
            BufferedWriter bw = new BufferedWriter(osw)) {
                bw.write("dir");
                bw.newLine();
                bw.flush();
            }
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
