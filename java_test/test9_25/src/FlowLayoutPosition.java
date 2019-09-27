import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.*;

public class FlowLayoutPosition extends JFrame {
	public FlowLayoutPosition() {
		setBounds(100, 100, 300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		 //�������趨������,����� ˮƽ����ʹ�ֱ���
		c.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20)); 
		
		for(int i = 0; i < 10; i++) {
			c.add(new JButton("��ť"+i)); //ѭ����Ӱ�ť���
		}
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new FlowLayoutPosition();
	}
}
