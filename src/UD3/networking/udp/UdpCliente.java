package UD3.networking.udp;

import java.io.IOException;
import java.net.*;

public class UdpCliente {
    private static final int SERVER_PORT = 5001;
    private static final int PACKAGE_SIZE = 1024;
    public static void main(String[] args) {
        try (DatagramSocket datagramSocket = new DatagramSocket()){
            String filename = "file/fichero1.txt";
            byte[] buffer = filename.getBytes();
            DatagramPacket dp = new DatagramPacket(buffer,buffer.length, InetAddress.getLocalHost(),SERVER_PORT);
            datagramSocket.send(dp);

            byte [] bufferReceive = new byte[PACKAGE_SIZE];
            DatagramPacket packet = new DatagramPacket(bufferReceive,bufferReceive.length);
            datagramSocket.receive(packet);
            String response = new String(packet.getData(),0, packet.getLength());
            System.out.println(response);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
