import java.awt.*;

import javax.swing.*;

public class GridLayoutPosition extends JFrame {
	public GridLayoutPosition() {
		setBounds(100, 100, 300, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new GridLayout(7, 3, 5, 5)); //设置为7行3列水平垂直间距都为5像素的网格布局
		for(int i = 0; i < 20; i++) {
			c.add(new Button("按钮"+i));
		}
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new GridLayoutPosition();
	}
}
