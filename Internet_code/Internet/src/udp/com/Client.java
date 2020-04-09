package udp.com;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    private static final String serverIP = "127.0.0.1";
    public static void main(String[] args) throws IOException {
       try(DatagramSocket clientSocket = new DatagramSocket()){
            String request = "hello";
            //必须以字符格式进行传输
            byte[] requesBytes = request.getBytes(Server.CHARSET);
            // 发送请求
            //  先准备 DatagramPacket 需要指定服务器的 ip + port
            DatagramPacket packetToServe = new DatagramPacket(
                    requesBytes, 0, requesBytes.length, //要发送的数据
                    InetAddress.getByName(serverIP), Server.PORT //要发送到互联网的哪个进程
            );
          clientSocket.send(packetToServe);
        }
    }
}