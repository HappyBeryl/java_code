package game;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
/**
 * 
 *游戏窗体类
 *
 */

public class GameFrame extends JFrame {
	//构造方法用来做初始化操作
	public GameFrame() {
		//设置窗体尺寸(宽度和高度)
		setSize(432, 644);
		//设置居中显示
		setLocationRelativeTo(null);
		//设置关闭窗体的同时停止程序
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置标题
		setTitle("会飞的东仔");
		//设置logol图标img/0.png
		setIconImage(Tools.getImg("../img/0.png"));
	}
	
	public static void main(String[] args) { //一个程序只有一个入口
		//创建一个窗体对象
		GameFrame frame = new GameFrame();
		//创建一个画板对象
		GamePanel panel = new GamePanel();
		//像窗体类添加一块画板
		frame.add(panel);
		
		//显示窗体
		frame.setVisible(true);
		
		//启动游戏
		//panel.start();
	}
}
