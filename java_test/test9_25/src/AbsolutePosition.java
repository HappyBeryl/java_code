
import java.awt.Container;

import javax.swing.*;

public class AbsolutePosition extends JFrame{
	public AbsolutePosition() {
		setBounds(100,100,200,150);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.setLayout(null);  //�������еĲ�����Ϊ���Բ���
		JButton b1 = new JButton("��ť1"), b2 = new JButton("��ť2");  //����������ť
		b1.setBounds(10, 30, 80, 30); //���ð�ť�������е�����ʹ�С
		b2.setBounds(60, 70 , 100, 20);
		c.add(b1);
		c.add(b2);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new AbsolutePosition();
	} 
}