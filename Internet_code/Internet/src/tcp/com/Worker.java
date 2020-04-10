package tcp.com;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Worker extends Thread {
    private final Socket socket;

    Worker(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // 一个连接允许有多个请求-响应

        try {
            InputStream is = socket.getInputStream();
            Scanner scanner = new Scanner(new InputStreamReader(is, "UTF-8"));

            OutputStream os = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(os, "UTF-8"));

            // Client 主动关闭连接后，不再循环
            while (scanner.hasNextLine()) {
                String request = scanner.nextLine();

                // 处理请求 -> 响应
                String response = business(request);

                writer.println(response);
                writer.flush();
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String business(String request) {
        return request;
    }
}

