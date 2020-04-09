package udp.com;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

// Server 必须公开出 port，否则客户端找不到我
// 端口(port) 可以在 0 - 65535 之间随便选
// 但是不能使用已经被其他进程使用的端口 —— 端口只能属于唯一的一个进程
public class Server {
    static final int PORT = 9527;
    static final String CHARSET = "UTF-8";

    public static void main(String[] args) throws IOException{
        try(DatagramSocket serverSocket = new DatagramSocket(PORT)) {
            System.out.printf("%d端口的服务器开启", PORT);
            // 提前准备好一个字节数组，用来存放接收到的数据（请求）
            byte[] receiveBuffer = new byte[8192];
            //一次循环就是一次请求响应的过程
            while (true) {
                //接收对方发送来的请求（数据）
                // 必须先创建 DatagramPacket 数据报文对象
                DatagramPacket packetFromClient = new DatagramPacket(
                        receiveBuffer, 0, receiveBuffer.length
                );
                //接收数据 不是立即返回 等待客户端发送数据
                serverSocket.receive(packetFromClient);
                // 我们收到的是字节格式的数据，要把数据节码成字符格式的
                //     利用 String 的一个构造方法，把字节数组的数据解码成字符格式的
                String request = new String(receiveBuffer, 0,
                        packetFromClient.getLength(), CHARSET);
                System.out.println("收到的请求是：" + request);
            }
        }
    }


}