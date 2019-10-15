package game;

import java.util.List;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * 小鸟类
 * @author 89713
 *
 */
public class Bird {
	//鸟的图片
	BufferedImage img;
	int x; //x坐标
	int y; //y坐标
	int w; //鸟的宽度
	int h; //鸟的高度
	//用来装一组图片的容器
	List<BufferedImage> list;
	//初速度
	double v0;
	//时间间隔（往上移动的时间）
	double t;
	//设置距离
	double s;
	//设置重力
	double g;
	//鸟的构造方法用来创建鸟的对象
	public Bird() {
		//获取鸟的图片
		img = Tools.getImg("../img/0.png");
		x = 100;
		y = 200;
		w = img.getWidth()/2;
		h = img.getHeight()/2;
		//初始化装图片的容器
		list = new ArrayList<BufferedImage>();
		//像容器中添加图片
		for(int i=0; i<8; i++) {
			list.add(Tools.getImg("../img/"+i+".png"));
		}	
		
		//初始化
		v0 = 5;
		t = 0.2;
		s = 0;
		g = 5;
		
	}
	
	//鸟的翅膀动起来
	int index = 0; //标记取下标为几的图片
	public void fly() {
//		if(index >= 8) {
//			index = 0;
//		}
		img = list.get(index%list.size());
		index++;
	}
	
	//小鸟的一个落体运动
	public void move() {
		//计算小鸟上抛的距离
		s = v0*t;
		//得到小鸟上抛到最高点时的y坐标
		y = y - (int)s;
		//计算小鸟到达最高点的速度
		double v2 = v0 - g*t;
		//最高点的速度就是小鸟下落时的初速度
		v0 = v2;
	}
	
	
	//小鸟上抛运动
	public void moveUp() {
		v0 = 10;
	}
	
	//小鸟与顶部或地面发生碰撞
	public boolean hit() {
		
		if(y <= 0 || y >= 644-146-h) {
			return true;
		}
		return false;//没撞到
	}
	
	//小鸟和柱子的碰撞
	public boolean hit(Column column) {
		if(x >= column.x-w && x <= column.x+column.w) {
			if(y > column.h/2+column.y-column.gap/2  && y < column.h/2+column.y+column.gap/2 - h) {
				return false;
			}
			//撞到了
		return true;
	}
	return false; //没撞到
	}
	
}
