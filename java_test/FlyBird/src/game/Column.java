package game;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

/**
 * ������
 * @author 89713
 *
 */
public class Column {
	//���ӵ�ͼƬ
	BufferedImage img;
	int x; //x����
	int y; //y����
	int w; //���ӵĿ��
	int h; //���ӵĸ߶�
	int distance; //����֮����
	int gap; //��ȫ��϶
	//����һ�����������
	Random ran = new Random();
	
	//���췽����ʼ�����Ӷ���
	public Column(int i) { //i��ʾ�ڼ�������
		// ��ʼ������ͼƬ
	img = Tools.getImg("../img/column.png");
	//��ȡͼƬ�Ŀ��
    w = img.getWidth()/2;
    gap =75;
	//��ȡͼƬ�ĸ߶�
	h = img.getHeight()/2;
	//��ʼ�����Ӽ��
	distance = 245;
	//����x
	x = 300 + 245*(i-1);
	//����y
	y = -ran.nextInt(h+146-644+1); //[0,n)
	
}
	
	//�����ƶ�
	public void move() {
		x--;
		if(x <= -w) {
			x = 300 + distance;
			y = -ran.nextInt(h+146-644+1); //[0,n)
			//��ʼ����ȫ��϶
			gap = 75;
		}
	}
	
}
