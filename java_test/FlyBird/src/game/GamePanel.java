package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * 画板类
 * 
 *
 */
public class GamePanel extends JPanel{
	//声明一个用于存放背景变量的变量
	BufferedImage bg;
	//声明一个用于存放的地面的变量
	Ground ground;
	//声明一个用于存放柱子的变量
	Column column1;
	//声明用于存放第二个柱子的变量
	Column column2;
	//声明鸟的对象
	Bird bird;
	//游戏准备状态
	boolean start;
	//游戏结束状态
	boolean gameOver;
	//分数
	int score;
	
	//构造方法
	public GamePanel() {
		//设置背景色
		setBackground(Color.RED);
		//设置背景图片
		bg = Tools.getImg("../img/bg.png");
		//初始化地面对象
		ground = new Ground();
		//初始化柱子对象
		column1 = new Column(1); //300
		//初始化第二个柱子对象
		column2 = new Column(2); //545
		//初始化鸟的对象
		bird = new Bird();
		//初始化游戏状态（没有开始为准备状态，若为true则为游戏运行状态）
		start = false;
		//初始化游戏结束状态(游戏没有结束)
		gameOver = false;
		//初始化分数
		score = 0;
		
		//初始化鼠标监听器
		MouseAdapter adapter = new MouseAdapter() {
			//鼠标点击后要做的事情写到方法内部
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				if(start == false) { //运行状态
					//改变游戏状态为运行状态
					start = true;
					//System.out.println("开始运行");
					//启动游戏		
					start();
				}else if(gameOver) {
					start = false;
					gameOver = false;
					//重置游戏中所有对象
					//初始化地面对象
					ground = new Ground();
					//初始化柱子对象
					column1 = new Column(1); //300
					//初始化第二个柱子对象
					column2 = new Column(2); //545
					//初始化鸟的对象
					bird = new Bird();
					//初始化分数
					score = 0;
					repaint();
				}else {
					//小鸟上抛
					bird.moveUp();
					//System.out.println("已经运行");
				}
				
			}
		};
		this.addMouseListener(adapter);
	}
	
	//游戏开始的方法
	public void start() {
		//启动游戏运行的线程
		MyThread mt = new MyThread();
		//将线程所要执行的任务装入到线程对象中
		Thread t = new Thread(mt);
		//将线程纳入线程调度
		t.start();
		
	}
	
	//用来像画板上绘制内容的方法，g相当于画笔
	public void paint(Graphics g) {
		super.paint(g);
		//绘制背景图片(需要绘制的图片，x坐标，y坐标，画满)
		g.drawImage(bg, 0, 0, null);
		//绘制柱子图片
		g.drawImage(column1.img, column1.x, column1.y, column1.w, column1.h, null);
		//绘制第二根柱子图片
		g.drawImage(column2.img, column2.x, column2.y, column2.w, column2.h, null);
		//绘制地面图片
		g.drawImage(ground.img, ground.x, ground.y, null);
		//绘制鸟的图片
		g.drawImage(bird.img, bird.x, bird.y, bird.w, bird.h, null);
		//绘制准备图片
		if(start == false) {
			g.drawImage(Tools.getImg("../img/start.png"), 0, 0, null);
		}
		//绘制结束图片
		if(gameOver == true) {
			g.drawImage(Tools.getImg("../img/gameover.png"), 0, 0, null);
		}
		//创建字体对象
		Font f = new Font("宋体", Font.BOLD, 30);
		g.setFont(f);
		g.setColor(Color.red);
		//绘制字符串
		g.drawString("分数"+score, 20, 40);
	}	
	
	//游戏运行的线程
	class MyThread  implements Runnable {
		public void run() {
		//该线程需要干的事情	
			//让地面移动
			while(true) {
				try {
					//地面移动
				ground.move();
				//第一个柱子移动
				column1.move();
				//第二个柱子移动
				column2.move();
				//小鸟飞
				bird.fly();
				//小鸟下落
				bird.move();
				//检测小鸟是否与顶部或地面发生碰撞
				boolean bool = bird.hit();
				//检测小鸟是否与柱子1发生碰撞
				boolean boo2 = bird.hit(column1);
				//检测小鸟是否与柱子2发生碰撞
	     		boolean boo3 = bird.hit(column2);
				//若发生碰撞，游戏结束
				if(bool || boo2 || boo3) {
				//更改游戏状态
					gameOver = true;
				//窗体内的对象全部静止
					return;
				}
				
				//计算分数
				if(bird.x == column1.x+column1.w || bird.x == column2.x + column2.w ) {
					score++;
				}
			
				//每移动一次休息1秒钟
				Thread.sleep(30);
				//刷新
				repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
				}
			}
		}
	}
	
}
