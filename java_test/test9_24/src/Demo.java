
import java.awt.Color;
import java.awt.Container;

import javax.swing.*;

public class Demo extends JFrame{ //让Demo类也成为窗体
	private static final long serialVersionUID = 1L;
	public Demo() {
		setVisible(true);
		setTitle("窗体标题"); //设置窗体标题
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //关闭窗口立即停止程序
//		setSize(300,200); //设置窗口大小，单位是像素
//		setLocation(200,200); //设置位置坐标，单位是像素
		setBounds(200,200,300,200); //设置窗口大小和坐标位置，单位是像素
		
		Container c = getContentPane(); //获取窗口中的容器
		c.setBackground(Color.WHITE); //设置背景颜色
		JLabel l = new JLabel ("这是一个窗体"); //实例化标签
		c.add(l); //添加组件
//		c.remove(l); //删除组件
		c.validate(); //验证容器中的组件
//		setContentPane(c); //重新载入容器
		
		setResizable(false); //设置窗口是否可以改变大小
		System.out.println("x="+getX()+"y="+getY()); //获取窗体位置
	}
		public static void main(String[] args) {
			new Demo();
			
	}
}
