import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Demo2 extends JFrame {
	public Demo2() {
		setBounds(200, 200, 400, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JCheckBox c1 = new JCheckBox("1");
		JCheckBox c2 = new JCheckBox("2");
		JCheckBox c3 = new JCheckBox("3");
		
		c.add(c1);
		c.add(c2);
		c.add(c3);
		
		c1.setSelected(true);
		
		JButton btn = new JButton("打印");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(c1.getText()+"按钮选中状态： "+c1.isSelected());
				System.out.println(c2.getText()+"按钮选中状态： "+c2.isSelected());
				System.out.println(c3.getText()+"按钮选中状态： "+c3.isSelected());
			}
		});
		c.add(btn);
		
		setVisible(true);
	}
	
   public static void main(String[] args) {
	new Demo2();
}
}
