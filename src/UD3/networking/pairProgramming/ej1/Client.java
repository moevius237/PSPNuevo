package UD3.networking.pairProgramming.ej1;

import java.io.IOException;
import java.net.*;
import java.util.Random;

public class Client {
    private static final int SERVER_PORT = 5001;
    private static final int NUMSENSO = 1;
    public static void main(String[] args) {
        try (DatagramSocket datagramSocket = new DatagramSocket()) {
            Random r = new Random();
            for (int i = 0; i < 12; i++) {
                int temp = r.nextInt(-40, 50);
                String mensaje = NUMSENSO + "#" + temp;
                System.out.println(mensaje);
                byte[] buffer = mensaje.getBytes();
                DatagramPacket dp = new DatagramPacket(buffer, buffer.length, InetAddress.getLocalHost(), SERVER_PORT);
                datagramSocket.send(dp);
            }
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}