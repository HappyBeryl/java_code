package tcp.com;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

// 有连接的
public class Server {
    public static void main(String[] args) throws IOException {
        //  创建 TCP 的 Server Socket
        try (ServerSocket serverSocket = new ServerSocket(9527)) {
            while (true) {
                // 不断的接待客户
                // 和 UDP 不同，不是以请求为单位接待，而是以连接为单位
                try (Socket connectionSocket = serverSocket.accept()) {

                    // TCP 是面向字节流的
                    InputStream is = connectionSocket.getInputStream();
                    OutputStream os = connectionSocket.getOutputStream();

                    // TCP 字节流的特性
                    // 把字节流封装成字符流
                    InputStreamReader isReader = new InputStreamReader(is, "UTF-8");
                    OutputStreamWriter osWriter = new OutputStreamWriter(os, "UTF-8");

                    PrintWriter osPrintWriter = new PrintWriter(osWriter);

                    // 一个连接中只会发送一个请求
                    char[] receiveBuffer = new char[8192];  
                    int len = isReader.read(receiveBuffer);
                    System.out.println(isReader.read());

                    String request = new String(receiveBuffer, 0, len);
                    System.out.println("%" + request + "%");
                }
            }
        }
    }
}
