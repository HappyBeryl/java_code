package uesFile.com;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamDemo {
    public static void main(String[] args) throws IOException {
        try (InputStream is = new FileInputStream("D:\\文档\\File类练习\\文件1.txt")) {
            byte[] buf = new byte[8192];

            int len;
            while ((len = is.read(buf)) != -1) {
                //buf[0,len]
                for (int i = 0; i < len; i++) {
             //       System.out.println(buf[i]);
                    char c = (char)buf[i];
                    System.out.print(c);
                }
            }
        }
    }
}
