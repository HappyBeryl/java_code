package uesFile.com;

// package uesFile.com;

import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) throws IOException {
        /*
        {
            // File 对象的实际文件不存在
            String path = "D:\\文档\\File类练习\\test.txt";
            File file = new File(path);
            System.out.println(file);
        }

     // 传入一个父路径
        {
            String parent = "D:\\文档\\File类练习";
            String path = "test.txt";
            File file = new File(parent, path);
            System.out.println(file);
          // 获取常见的属性
            System.out.println(file.exists()); //文件是否存在
            System.out.println(file.getAbsolutePath()); //返回绝对路径
            System.out.println(file.getName());  //返回文件名
            System.out.println(file.getParent()); //返回父路径
            System.out.println(file.isAbsolute()); //是否为绝对路径
            System.out.println(file.isDirectory()); //是否是目录
            System.out.println(file.isFile()); //是否是文件
            System.out.println(file.isHidden()); //是否是隐藏的
            System.out.println(file.canRead()); //是否可读
            System.out.println(file.canWrite()); //是否可写
            System.out.println(file.canExecute()); //是否可执行
        }*/

        /*{
            //普通文件的创建
            String parent = "D:\\文档";
            String fileName = "演示创建文件的文件.txt";

            File file = new File(parent, fileName);
            System.out.println(file.exists());
            boolean success = file.createNewFile();
            if (success) {
                System.out.println(fileName + "被创建成功");
            } else {
                System.out.println(fileName + "已经存在");
            }
        }*/

        /*
        {
            // 文件夹的创建过程
            String parent = "D:\\文档";
            String filename = "一个事先不存在的文件夹\\一个新的文件夹";

            File file = new File(parent, filename);
            System.out.println(file.exists());

            // mkdirs: 会把需要创建的中间文件夹一并创建出来
            boolean success = file.mkdirs();
            if (success) {
                System.out.println(filename + " 文件夹创建成功");
            } else {
                System.out.println(filename + " 文件夹原来就存在");
            }
        }
*/

        /*
        {
            String parent = "D:\\文档";
            String filename = "一个文件.txt";
            File file = new File(parent, filename);
            System.out.println(file.exists());
            file.deleteOnExit();
            Scanner scanner = new Scanner(System.in);
            System.out.println("只要我不按回车，就不会删除");
            scanner.nextLine();
            // 只能删除一个空的文件夹
            boolean delete = file.delete();
            if (delete) {
                System.out.println("删除了");
            } else {
                System.out.println("就不存在，没删");
            }
        }
        */

        /*
        {
            String path = "D:\\文档";
            File dir = new File(path);

            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    System.out.println(file.getName());
                }
            }
        }
*/
    }
}

