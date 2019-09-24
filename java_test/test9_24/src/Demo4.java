import java.awt.Container;

import javax.swing.*;

public class Demo4 extends JFrame {
	private static final long serialVersionUID = 1L;

	public Demo4() {
		setBounds(100, 100, 500, 350);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		JLabel l = new JLabel("这是一个展示图片的标签");
		Icon icon = new ImageIcon("src/java.png"); //字符串默认获取项目所在路径 获取图片文件
		l.setIcon(icon); //添加图片
		c.add(l);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Demo4();
	}
}
