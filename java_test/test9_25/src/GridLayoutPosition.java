import java.awt.*;

import javax.swing.*;

public class GridLayoutPosition extends JFrame {
	public GridLayoutPosition() {
		setBounds(100, 100, 300, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new GridLayout(7, 3, 5, 5)); //����Ϊ7��3��ˮƽ��ֱ��඼Ϊ5���ص����񲼾�
		for(int i = 0; i < 20; i++) {
			c.add(new Button("��ť"+i));
		}
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new GridLayoutPosition();
	}
}
