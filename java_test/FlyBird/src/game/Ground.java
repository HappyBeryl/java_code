package game;
/**
 * ������
 * @author 89713
 *
 */

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Ground {
	int x; //x����
	int y; //y����
	//�����ͼƬ
	BufferedImage img;
	//����Ŀ��
	int w;
	//����ĸ߶�
	int h;
	//���������������
	public Ground() {
		//�ȳ�ʼ������ͼƬ
	    img = Tools.getImg("../img/ground.png");
		//��ȡͼƬ�ĸ߶�
		h = img.getHeight();
		//��ȡͼƬ�Ŀ��
		w = img.getWidth();
		//��ʼ��x
		x = 0;
		//��ʼ��y
		y = 644 - h;
	}
	
	//�����ƶ��ķ���
	public void move() {
		if(x <= -(w-432)) {
			x = 0;
		}
			x--;
	}
}
