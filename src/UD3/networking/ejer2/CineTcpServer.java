package UD3.networking.ejer2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
Diseña un sistema de gestion de reservas del cine . El sistema involucra la comunicacion
entre la venta de tickets(cliente) y un servidor central

Los clientes simularan solicitudes de reservas de asientos. El cine tiene 30 asientos
ya que es un cine de lujo. En la reserva se debe guardar un id del cliente que ha hecho esa reserva y el asiento reservado
EL servidor procesara las reservas de forma simultanea y tendra que garantizar la reserva de asiento
Si se consigue reservas el servidor enviara el codigo 200 de confirmacion si no se hace la reserva
porque esta ocupado el asiento enviara codigo 303 solo cuando el cliente reciba el codigo 200 finalizara
si no seguira intentando reservar otro asiento
 */
public class CineTcpServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {

            Socket socket = serverSocket.accept();
            Sala sala = new Sala();
            System.out.println("Cliente conectado");
            new Thread(new HilitoCine(socket, sala)).start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
