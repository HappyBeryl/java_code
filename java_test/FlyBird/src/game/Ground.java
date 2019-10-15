package game;
/**
 * 地面类
 * @author 89713
 *
 */

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Ground {
	int x; //x坐标
	int y; //y坐标
	//地面的图片
	BufferedImage img;
	//地面的宽度
	int w;
	//地面的高度
	int h;
	//用来构建地面对象
	public Ground() {
		//先初始化地面图片
	    img = Tools.getImg("../img/ground.png");
		//获取图片的高度
		h = img.getHeight();
		//获取图片的宽度
		w = img.getWidth();
		//初始化x
		x = 0;
		//初始化y
		y = 644 - h;
	}
	
	//地面移动的方法
	public void move() {
		if(x <= -(w-432)) {
			x = 0;
		}
			x--;
	}
}
