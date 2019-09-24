import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Demo2 extends JDialog{
	private static final long serialVersionUID = 1L;

	public Demo2(JFrame frame) {
		//第一个参数 父窗体对象
		//第二个参数 对话框标题
		//第三个参数 是否阻塞父标题
		super(frame, "对话框标题", true); 
		Container c = getContentPane() ;//获取窗口容器
		JLabel l = new JLabel("这是一个对话框");
		c.add(l);
		setBounds(100,100,100,100);
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame("父窗体");
		f.setBounds(50, 50, 300, 300);
		Container c = f.getContentPane(); //获取容器
		JButton btn = new JButton("弹出对话框"); //设置按钮
		c.setLayout(new FlowLayout());  //设置布局使用流布局
		c.add(btn);
		f.setVisible(true);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Demo2 d = new Demo2(f);
				d.setVisible(true);
			}
		}); //添加动作监听
	}
}
