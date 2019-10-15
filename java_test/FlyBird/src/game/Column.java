package game;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

/**
 * 柱子类
 * @author 89713
 *
 */
public class Column {
	//柱子的图片
	BufferedImage img;
	int x; //x坐标
	int y; //y坐标
	int w; //柱子的宽度
	int h; //柱子的高度
	int distance; //柱子之间间距
	int gap; //安全间隙
	//声明一个随机数对象
	Random ran = new Random();
	
	//构造方法初始化柱子对象
	public Column(int i) { //i表示第几根柱子
		// 初始化柱子图片
	img = Tools.getImg("../img/column.png");
	//获取图片的宽度
    w = img.getWidth()/2;
    gap =75;
	//获取图片的高度
	h = img.getHeight()/2;
	//初始化柱子间距
	distance = 245;
	//设置x
	x = 300 + 245*(i-1);
	//设置y
	y = -ran.nextInt(h+146-644+1); //[0,n)
	
}
	
	//柱子移动
	public void move() {
		x--;
		if(x <= -w) {
			x = 300 + distance;
			y = -ran.nextInt(h+146-644+1); //[0,n)
			//初始化安全间隙
			gap = 75;
		}
	}
	
}
