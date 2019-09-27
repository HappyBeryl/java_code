
import java.awt.Container;

import javax.swing.*;

public class AbsolutePosition extends JFrame{
	public AbsolutePosition() {
		setBounds(100,100,200,150);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.setLayout(null);  //将容器中的布局设为绝对布局
		JButton b1 = new JButton("按钮1"), b2 = new JButton("按钮2");  //创建两个按钮
		b1.setBounds(10, 30, 80, 30); //设置按钮在容器中的坐标和大小
		b2.setBounds(60, 70 , 100, 20);
		c.add(b1);
		c.add(b2);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new AbsolutePosition();
	} 
}