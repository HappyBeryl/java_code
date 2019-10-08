import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class Demo {
	public static void main(String[] args) {
		File f1 = new File("D:/word.txt");
		
		System.out.println("�ļ��Ƿ���� : "+f1.exists());
		
		System.out.println("�ļ����� "+f1.getName()); //����ļ���
		System.out.println("�ļ�����·����"+f1.getAbsolutePath()); //����ļ��ľ���·��
		System.out.println("�Ƿ�Ϊ�����ļ��� "+f1.isHidden()); //�Ƿ�Ϊ�����ļ�
		System.out.println("�ļ����ֽ����� "+f1.length()); //�ļ��Ĵ�С��λ���ֽ�
		Date date = new Date(f1.lastModified());  //ͨ������ֵ����������
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		System.out.println("�ļ�����޸�ʱ�䣺 "+sdf.format(date));  //�ļ�����޸�ʱ��
		
		boolean del = f1.delete(); //ɾ���ļ�
		System.out.println("ɾ���ļ��Ƿ�ɹ��� "+del);
		
		try {
			//���ܸ��������ļ�
			boolean create = f1.createNewFile(); //�����µĿյ��ļ�
			System.out.println("�����ļ��Ƿ�ɹ��� "+create);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}
	
}
