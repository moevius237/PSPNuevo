package UD3.networking.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UdpServer {
    private static final int port = 5001;
    private static final int PACKAGE_SIZE = 1024;
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        try (DatagramSocket dts = new DatagramSocket(port)) {
            while (true) {
                byte[] buffer = new byte[PACKAGE_SIZE];
                DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
                dts.receive(dp);
                executorService.execute(new Hilito(dts,dp));
              //  new Thread(new Hilito(dts,dp)).start();
            }
            } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}