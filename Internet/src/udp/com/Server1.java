package udp.com;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server1 {
    static final int PORT = 9527;
    static final String CHARSET = "UTF-8";

    public static void main(String[] args) throws IOException {
        //1. 接收请求
        try(DatagramSocket serveSocket = new DatagramSocket()) {
            byte[] recieveBuffer = new byte[8192];
            while (true) {
                DatagramPacket packageFromClient = new DatagramPacket(
                        recieveBuffer, 0, recieveBuffer.length
                );
                serveSocket.receive(packageFromClient); //字节 还需要转为字符
                String request = new String(recieveBuffer, 0,
                        packageFromClient.getLength(), CHARSET);
                System.out.println("DEBUG: 收到的请求是: " + request);
                //2. 业务处理
                String respons = request;

                //3. 发送响应
                //获取客户端的ip和端口
                InetAddress clientAddress = packageFromClient.getAddress();
                int clientPort = packageFromClient.getPort();

                byte[] responsBytes = respons.getBytes(Server.CHARSET);

                DatagramPacket packetToClient = new DatagramPacket(
                        responsBytes, 0, responsBytes.length, //要发送的数据
                        clientAddress, clientPort
                );
                serveSocket.send(packetToClient);


            }

        }


    }
}
