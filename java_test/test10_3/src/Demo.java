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
		
		JRadioButton left = new JRadioButton("������");
		JRadioButton right = new JRadioButton("������");
		c.add(left);
		c.add(right);
		
		ButtonGroup group = new ButtonGroup();  //��ť��
		group.add(left);  //�ѵ�ѡ��ť�ŵ���ť����
		group.add(right);
		
		left.setSelected(true);   //Ĭ��ѡ��
		
		JButton btn = new JButton("��ӡ");
		btn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println(left.getText()+"��ťѡ��״̬�� "+left.isSelected());
				System.out.println(right.getText()+"��ťѡ��״̬�� "+right.isSelected());
				group.clearSelection(); //��ť�����
			}
		});
		
		c.add(btn);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Demo();
	}
}
