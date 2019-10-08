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
			out = new FileOutputStream(f,true);//文件输出流true：追加 ；false：替换
			
			String str = "好好学习，天天向上";
			byte b[] = str.getBytes(); //字符串转换为字节数组
			out.write(b); //将字节数组中的数据写入到文件中
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
			in = new FileInputStream(f); //输入文件流
			
			byte b2[] = new byte[1024]; //相当于缓冲区
			int len = in.read(b2); //读入缓冲区的总字节数
			System.out.println("文件中的内容为： "+new String(b2,0,len));
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
