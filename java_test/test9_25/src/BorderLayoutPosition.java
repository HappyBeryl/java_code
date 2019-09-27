
import java.awt.*;
import javax.swing.*;

public class BorderLayoutPosition extends JFrame {
	public BorderLayoutPosition() {
		setBounds(100, 100, 350, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		setLayout(new BorderLayout()); //设为边界布局
		
		JButton b1 = new JButton("中");
		JButton b2 = new JButton("东");
		JButton b3 = new JButton("南");
		JButton b4 = new JButton("西");
		JButton b5 = new JButton("北");
		c.add(b1, BorderLayout.CENTER); //中部添加按钮
		c.add(b2, BorderLayout.EAST); //东部添加按钮
		c.add(b3, BorderLayout.SOUTH); //南部添加按钮
		c.add(b4, BorderLayout.WEST); //西部添加按钮
		c.add(b5, BorderLayout.NORTH); //北部添加按钮
		
		c.add(new Button("覆盖"), BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new BorderLayoutPosition();
	}
}

