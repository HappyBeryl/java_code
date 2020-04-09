package udp.com;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Scanner;

public class Client1 {
    private static final String severIP = "127.0.0.1";

    public static void main(String[] args) throws IOException {
        try (DatagramSocket clientSocket =  new DatagramSocket()){
            Scanner sc = new Scanner(System.in);

            byte[] receiveBuffer = new byte[8192];
            System.out.println("输入请求》");
            while (sc.hasNext()) {
                String request = sc.nextLine();
                byte[] requestBytes = request.getBytes(Server.CHARSET);

                DatagramPacket packetFromServe = new DatagramPacket(
                        receiveBuffer, 0, receiveBuffer.length
                );
                clientSocket.receive(packetFromServe);

                String response = new String(receiveBuffer, 0, packetFromServe.getLength(), Server.CHARSET);
                System.out.println("服务器应答: " + response);

                System.out.print("请输入请求> ");
            }
        }
    }
}
