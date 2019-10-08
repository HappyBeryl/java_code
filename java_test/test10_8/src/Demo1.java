import java.io.File;

public class Demo1 {	

	public static void main(String[] args) {
	    //File dir = new File("dir/dir2");
		//boolean flag = dir.mkdir(); //创建一个文件夹
		//boolean flag2 = dir.mkdirs(); //创建文件夹及其父文件夹
		//System.out.println(flag2); 
		
		//dir.delete(); //删除文件路径最后一个文件夹
		
		File f = new File("c:/windows"); 
		File files[] = f.listFiles(); //返回文件夹下所有的子文件及子文件夹
		for(File tmp: files) {
			if(tmp.isFile()) {  //判断是否为文件
				System.out.println("文件： "+tmp.getName());	
			}else if(tmp.isDirectory()) {  //判断是否为文件夹
				
				System.out.println("文件夹： "+tmp.getName());	
			}	
		}
	}
}
