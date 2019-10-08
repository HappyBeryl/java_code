import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class Demo {
	public static void main(String[] args) {
		File f1 = new File("D:/word.txt");
		
		System.out.println("文件是否存在 : "+f1.exists());
		
		System.out.println("文件名： "+f1.getName()); //输出文件名
		System.out.println("文件绝对路径："+f1.getAbsolutePath()); //输出文件的绝对路径
		System.out.println("是否为隐藏文件： "+f1.isHidden()); //是否为隐藏文件
		System.out.println("文件的字节数： "+f1.length()); //文件的大小单位是字节
		Date date = new Date(f1.lastModified());  //通过毫秒值创建日期类
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		System.out.println("文件最后修改时间： "+sdf.format(date));  //文件最后修改时间
		
		boolean del = f1.delete(); //删除文件
		System.out.println("删除文件是否成功： "+del);
		
		try {
			//不能覆盖已有文件
			boolean create = f1.createNewFile(); //创建新的空的文件
			System.out.println("创建文件是否成功： "+create);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}
	
}
