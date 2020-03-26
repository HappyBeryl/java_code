package uesFile.com;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamDemo {
    public static void main(String[] args) throws IOException {
        try(OutputStream os = new FileOutputStream("D:\\文档\\File类练习\\输出内容.txt")){
          /*  os.write('S');
            os.write('e');
            os.write('c');
            os.write('o');
            os.write('n');
            os.write('d');
            os.write('\r');
            os.write('\n');
            */
            byte[] buf = new byte[1024];
            buf[0] = (byte)'T';
            buf[1] = (byte)'h';
            buf[2] = (byte)'i';
            buf[3] = (byte)'r';
            buf[4] = (byte)'d';
            buf[5] = (byte)'\r';
            buf[6] = (byte)'\n';
            os.write(buf, 0, 7);
            os.flush(); // 保证把所有缓冲的数据全部写入硬盘中

            String s = "Hello World\r\n";
            byte[] bytes = s.getBytes();
            os.write(bytes);
        }
    }
}
