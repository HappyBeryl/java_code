package game;

import java.util.List;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * С����
 * @author 89713
 *
 */
public class Bird {
	//���ͼƬ
	BufferedImage img;
	int x; //x����
	int y; //y����
	int w; //��Ŀ��
	int h; //��ĸ߶�
	//����װһ��ͼƬ������
	List<BufferedImage> list;
	//���ٶ�
	double v0;
	//ʱ�����������ƶ���ʱ�䣩
	double t;
	//���þ���
	double s;
	//��������
	double g;
	//��Ĺ��췽������������Ķ���
	public Bird() {
		//��ȡ���ͼƬ
		img = Tools.getImg("../img/0.png");
		x = 100;
		y = 200;
		w = img.getWidth()/2;
		h = img.getHeight()/2;
		//��ʼ��װͼƬ������
		list = new ArrayList<BufferedImage>();
		//�����������ͼƬ
		for(int i=0; i<8; i++) {
			list.add(Tools.getImg("../img/"+i+".png"));
		}	
		
		//��ʼ��
		v0 = 5;
		t = 0.2;
		s = 0;
		g = 5;
		
	}
	
	//��ĳ������
	int index = 0; //���ȡ�±�Ϊ����ͼƬ
	public void fly() {
//		if(index >= 8) {
//			index = 0;
//		}
		img = list.get(index%list.size());
		index++;
	}
	
	//С���һ�������˶�
	public void move() {
		//����С�����׵ľ���
		s = v0*t;
		//�õ�С�����׵���ߵ�ʱ��y����
		y = y - (int)s;
		//����С�񵽴���ߵ���ٶ�
		double v2 = v0 - g*t;
		//��ߵ���ٶȾ���С������ʱ�ĳ��ٶ�
		v0 = v2;
	}
	
	
	//С�������˶�
	public void moveUp() {
		v0 = 10;
	}
	
	//С���붥������淢����ײ
	public boolean hit() {
		
		if(y <= 0 || y >= 644-146-h) {
			return true;
		}
		return false;//ûײ��
	}
	
	//С������ӵ���ײ
	public boolean hit(Column column) {
		if(x >= column.x-w && x <= column.x+column.w) {
			if(y > column.h/2+column.y-column.gap/2  && y < column.h/2+column.y+column.gap/2 - h) {
				return false;
			}
			//ײ����
		return true;
	}
	return false; //ûײ��
	}
	
}
