import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.*;

public class FlowLayoutPosition extends JFrame {
	public FlowLayoutPosition() {
		setBounds(100, 100, 300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		 //给程序设定流布局,左对齐 水平间隔和垂直间隔
		c.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20)); 
		
		for(int i = 0; i < 10; i++) {
			c.add(new JButton("按钮"+i)); //循环添加按钮组件
		}
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new FlowLayoutPosition();
	}
}
