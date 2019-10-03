import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Demo extends JFrame {
	public Demo() {
		setBounds(200, 200, 400, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JRadioButton left = new JRadioButton("向左走");
		JRadioButton right = new JRadioButton("向右走");
		c.add(left);
		c.add(right);
		
		ButtonGroup group = new ButtonGroup();  //按钮组
		group.add(left);  //把单选按钮放到按钮组中
		group.add(right);
		
		left.setSelected(true);   //默认选中
		
		JButton btn = new JButton("打印");
		btn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println(left.getText()+"按钮选中状态： "+left.isSelected());
				System.out.println(right.getText()+"按钮选中状态： "+right.isSelected());
				group.clearSelection(); //按钮组清空
			}
		});
		
		c.add(btn);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Demo();
	}
}
