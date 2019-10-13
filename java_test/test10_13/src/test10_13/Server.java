package test10_13;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(1100); //创建服务器套接字
			System.out.println("服务器启动成功，等待用户接入.....");
			Socket client = server.accept(); //等待用户接入
			System.out.println("有客户端介入，ip为："+client.getInetAddress());  //获取客户端地址
			InputStream in = client.getInputStream();
			byte[] bt = new byte[1024];
			int len = in.read(bt);
			String date = new String(bt,0,len);
			System.out.println("客户端发来消息"+date);
			
			server.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
