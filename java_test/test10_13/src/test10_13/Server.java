package test10_13;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(1100); //�����������׽���
			System.out.println("�����������ɹ����ȴ��û�����.....");
			Socket client = server.accept(); //�ȴ��û�����
			System.out.println("�пͻ��˽��룬ipΪ��"+client.getInetAddress());  //��ȡ�ͻ��˵�ַ
			InputStream in = client.getInputStream();
			byte[] bt = new byte[1024];
			int len = in.read(bt);
			String date = new String(bt,0,len);
			System.out.println("�ͻ��˷�����Ϣ"+date);
			
			server.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
