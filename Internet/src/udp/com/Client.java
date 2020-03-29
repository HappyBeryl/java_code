package udp.com;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    // 这里使用 127.0.0.1 代表本机
    private static final String serverIP = "127.0.0.1";

    public static void main(String[] args) throws IOException {

        try (DatagramSocket clientSocket = new DatagramSocket()) {

            // 1准备好请求，同时，传输的必须是字符格式
            String request = "你好";
            byte[] requestBytes = request.getBytes(Server.CHARSET);

            // 发送请求
            DatagramPacket packetToServer = new DatagramPacket(
                    requestBytes, 0, requestBytes.length,     // 要发送的数据
                    InetAddress.getByName(serverIP), Server.PORT    // 要发送到互联网的哪个进程上
            );

            clientSocket.send(packetToServer);
        }
    }
}