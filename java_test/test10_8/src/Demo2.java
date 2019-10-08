import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo2 {
	public static void main(String[] args)  {
		File f = new File("word.txt");
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(f,true);//�ļ������true��׷�� ��false���滻
			
			String str = "�ú�ѧϰ����������";
			byte b[] = str.getBytes(); //�ַ���ת��Ϊ�ֽ�����
			out.write(b); //���ֽ������е�����д�뵽�ļ���
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(out != null) {
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		FileInputStream in = null;
		try {
			in = new FileInputStream(f); //�����ļ���
			
			byte b2[] = new byte[1024]; //�൱�ڻ�����
			int len = in.read(b2); //���뻺���������ֽ���
			System.out.println("�ļ��е�����Ϊ�� "+new String(b2,0,len));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}	
	}
}
