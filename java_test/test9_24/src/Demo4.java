import java.awt.Container;

import javax.swing.*;

public class Demo4 extends JFrame {
	private static final long serialVersionUID = 1L;

	public Demo4() {
		setBounds(100, 100, 500, 350);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		JLabel l = new JLabel("����һ��չʾͼƬ�ı�ǩ");
		Icon icon = new ImageIcon("src/java.png"); //�ַ���Ĭ�ϻ�ȡ��Ŀ����·�� ��ȡͼƬ�ļ�
		l.setIcon(icon); //���ͼƬ
		c.add(l);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Demo4();
	}
}
