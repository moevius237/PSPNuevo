package UD3.networking.pairProgramming.ej1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private static final int port = 5001;
    private static final int PACKAGE_SIZE = 1024;
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        try (DatagramSocket dts = new DatagramSocket(port)) {
            while (true) {
                byte[] message = new byte[PACKAGE_SIZE];
                DatagramPacket dp = new DatagramPacket(message, message.length);
                dts.receive(dp);
                executorService.execute(new Thread1(dp));
            }
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
