package UD3.networking.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.nio.file.Files;
import java.nio.file.Path;

public class Hilito implements Runnable{
    private final DatagramSocket dts;
    private final DatagramPacket dp;

    public Hilito(DatagramSocket datagramSocket, DatagramPacket datagramPacket) {
        this.dts = datagramSocket;
        this.dp = datagramPacket;
    }

    @Override
    public void run() {
        String filename = new String(dp.getData(),0, dp.getLength());
        System.out.println(filename);
        if (Files.exists(Path.of(filename))){
            byte[] respuesta = "EL FICHERO EXISTE".getBytes();
            DatagramPacket sentPacket = new DatagramPacket(respuesta, respuesta.length,dp.getAddress(),dp.getPort());
            try {
                dts.send(sentPacket);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    }
