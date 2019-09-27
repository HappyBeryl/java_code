
import java.awt.*;
import javax.swing.*;

public class BorderLayoutPosition extends JFrame {
	public BorderLayoutPosition() {
		setBounds(100, 100, 350, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		setLayout(new BorderLayout()); //��Ϊ�߽粼��
		
		JButton b1 = new JButton("��");
		JButton b2 = new JButton("��");
		JButton b3 = new JButton("��");
		JButton b4 = new JButton("��");
		JButton b5 = new JButton("��");
		c.add(b1, BorderLayout.CENTER); //�в���Ӱ�ť
		c.add(b2, BorderLayout.EAST); //������Ӱ�ť
		c.add(b3, BorderLayout.SOUTH); //�ϲ���Ӱ�ť
		c.add(b4, BorderLayout.WEST); //������Ӱ�ť
		c.add(b5, BorderLayout.NORTH); //������Ӱ�ť
		
		c.add(new Button("����"), BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new BorderLayoutPosition();
	}
}

