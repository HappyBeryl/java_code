import java.io.File;

public class Demo1 {	

	public static void main(String[] args) {
	    //File dir = new File("dir/dir2");
		//boolean flag = dir.mkdir(); //����һ���ļ���
		//boolean flag2 = dir.mkdirs(); //�����ļ��м��丸�ļ���
		//System.out.println(flag2); 
		
		//dir.delete(); //ɾ���ļ�·�����һ���ļ���
		
		File f = new File("c:/windows"); 
		File files[] = f.listFiles(); //�����ļ��������е����ļ������ļ���
		for(File tmp: files) {
			if(tmp.isFile()) {  //�ж��Ƿ�Ϊ�ļ�
				System.out.println("�ļ��� "+tmp.getName());	
			}else if(tmp.isDirectory()) {  //�ж��Ƿ�Ϊ�ļ���
				
				System.out.println("�ļ��У� "+tmp.getName());	
			}	
		}
	}
}
