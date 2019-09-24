import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.*;

public class Demo3 extends JFrame {
private static final long serialVersionUID = 1L;
	public Demo3() {
		setBounds(100,100,100,100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = getContentPane();
		setVisible(true);
		
		JLabel l = new JLabel("这是一个标签");
		l.setText("更改标签内容");
		System.out.println(l.getText());
		l.setFont(new Font("楷体",Font.BOLD,15));
		l.setForeground(Color.RED);
		c.add(l);
	}
	public static void main(String[] args) {
		new Demo3();
	}
}
