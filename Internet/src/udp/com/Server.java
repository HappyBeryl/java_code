package udp.com;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

// Server 必须公开出 port
public class Server {
    static final int PORT = 9527;
    static final String CHARSET = "UTF-8";

    public static void main(String[] args) throws IOException {
        // 创建套接字
        // DatagramSocket 是 UDP 协议专用的 套接字
        //
        try (DatagramSocket serverSocket = new DatagramSocket(PORT)) {
            System.out.printf("DEBUG: 在 %d 这个端口上%n", PORT);

            // 提前准备好一个字节数组，用来存放接收到的数据（请求）
            // 一次最多可以接收 8192 个字节
            byte[] receiveBuffer = new byte[8192];

            while (true) {
                // 一次循环就是 一次 请求-响应 的处理过程

                // 1. 接收对方发送来的请求（数据）
                // 必须先创建 DatagramPacket 数据报文对象
                DatagramPacket packetFromClient = new DatagramPacket(
                        receiveBuffer, 0, receiveBuffer.length
                );
                // 接收数据
                serverSocket.receive(packetFromClient); // 这个方法不是立即返回的，和 scanner.nextLine();
                String request = new String(
                        receiveBuffer, 0, packetFromClient.getLength(),
                        CHARSET
                );

                System.out.println("DEBUG: 收到的请求是: " + request);
            }
        }
    }
}
