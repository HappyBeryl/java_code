
import java.awt.Color;
import java.awt.Container;

import javax.swing.*;

public class Demo extends JFrame{ //��Demo��Ҳ��Ϊ����
	private static final long serialVersionUID = 1L;
	public Demo() {
		setVisible(true);
		setTitle("�������"); //���ô������
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //�رմ�������ֹͣ����
//		setSize(300,200); //���ô��ڴ�С����λ������
//		setLocation(200,200); //����λ�����꣬��λ������
		setBounds(200,200,300,200); //���ô��ڴ�С������λ�ã���λ������
		
		Container c = getContentPane(); //��ȡ�����е�����
		c.setBackground(Color.WHITE); //���ñ�����ɫ
		JLabel l = new JLabel ("����һ������"); //ʵ������ǩ
		c.add(l); //������
//		c.remove(l); //ɾ�����
		c.validate(); //��֤�����е����
//		setContentPane(c); //������������
		
		setResizable(false); //���ô����Ƿ���Ըı��С
		System.out.println("x="+getX()+"y="+getY()); //��ȡ����λ��
	}
		public static void main(String[] args) {
			new Demo();
			
	}
}
