import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Demo2 extends JDialog{
	private static final long serialVersionUID = 1L;

	public Demo2(JFrame frame) {
		//��һ������ ���������
		//�ڶ������� �Ի������
		//���������� �Ƿ�����������
		super(frame, "�Ի������", true); 
		Container c = getContentPane() ;//��ȡ��������
		JLabel l = new JLabel("����һ���Ի���");
		c.add(l);
		setBounds(100,100,100,100);
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame("������");
		f.setBounds(50, 50, 300, 300);
		Container c = f.getContentPane(); //��ȡ����
		JButton btn = new JButton("�����Ի���"); //���ð�ť
		c.setLayout(new FlowLayout());  //���ò���ʹ��������
		c.add(btn);
		f.setVisible(true);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Demo2 d = new Demo2(f);
				d.setVisible(true);
			}
		}); //��Ӷ�������
	}
}
