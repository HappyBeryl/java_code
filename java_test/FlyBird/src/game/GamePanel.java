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
 * ������
 * 
 *
 */
public class GamePanel extends JPanel{
	//����һ�����ڴ�ű��������ı���
	BufferedImage bg;
	//����һ�����ڴ�ŵĵ���ı���
	Ground ground;
	//����һ�����ڴ�����ӵı���
	Column column1;
	//�������ڴ�ŵڶ������ӵı���
	Column column2;
	//������Ķ���
	Bird bird;
	//��Ϸ׼��״̬
	boolean start;
	//��Ϸ����״̬
	boolean gameOver;
	//����
	int score;
	
	//���췽��
	public GamePanel() {
		//���ñ���ɫ
		setBackground(Color.RED);
		//���ñ���ͼƬ
		bg = Tools.getImg("../img/bg.png");
		//��ʼ���������
		ground = new Ground();
		//��ʼ�����Ӷ���
		column1 = new Column(1); //300
		//��ʼ���ڶ������Ӷ���
		column2 = new Column(2); //545
		//��ʼ����Ķ���
		bird = new Bird();
		//��ʼ����Ϸ״̬��û�п�ʼΪ׼��״̬����Ϊtrue��Ϊ��Ϸ����״̬��
		start = false;
		//��ʼ����Ϸ����״̬(��Ϸû�н���)
		gameOver = false;
		//��ʼ������
		score = 0;
		
		//��ʼ����������
		MouseAdapter adapter = new MouseAdapter() {
			//�������Ҫ��������д�������ڲ�
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				if(start == false) { //����״̬
					//�ı���Ϸ״̬Ϊ����״̬
					start = true;
					//System.out.println("��ʼ����");
					//������Ϸ		
					start();
				}else if(gameOver) {
					start = false;
					gameOver = false;
					//������Ϸ�����ж���
					//��ʼ���������
					ground = new Ground();
					//��ʼ�����Ӷ���
					column1 = new Column(1); //300
					//��ʼ���ڶ������Ӷ���
					column2 = new Column(2); //545
					//��ʼ����Ķ���
					bird = new Bird();
					//��ʼ������
					score = 0;
					repaint();
				}else {
					//С������
					bird.moveUp();
					//System.out.println("�Ѿ�����");
				}
				
			}
		};
		this.addMouseListener(adapter);
	}
	
	//��Ϸ��ʼ�ķ���
	public void start() {
		//������Ϸ���е��߳�
		MyThread mt = new MyThread();
		//���߳���Ҫִ�е�����װ�뵽�̶߳�����
		Thread t = new Thread(mt);
		//���߳������̵߳���
		t.start();
		
	}
	
	//�����񻭰��ϻ������ݵķ�����g�൱�ڻ���
	public void paint(Graphics g) {
		super.paint(g);
		//���Ʊ���ͼƬ(��Ҫ���Ƶ�ͼƬ��x���꣬y���꣬����)
		g.drawImage(bg, 0, 0, null);
		//��������ͼƬ
		g.drawImage(column1.img, column1.x, column1.y, column1.w, column1.h, null);
		//���Ƶڶ�������ͼƬ
		g.drawImage(column2.img, column2.x, column2.y, column2.w, column2.h, null);
		//���Ƶ���ͼƬ
		g.drawImage(ground.img, ground.x, ground.y, null);
		//�������ͼƬ
		g.drawImage(bird.img, bird.x, bird.y, bird.w, bird.h, null);
		//����׼��ͼƬ
		if(start == false) {
			g.drawImage(Tools.getImg("../img/start.png"), 0, 0, null);
		}
		//���ƽ���ͼƬ
		if(gameOver == true) {
			g.drawImage(Tools.getImg("../img/gameover.png"), 0, 0, null);
		}
		//�����������
		Font f = new Font("����", Font.BOLD, 30);
		g.setFont(f);
		g.setColor(Color.red);
		//�����ַ���
		g.drawString("����"+score, 20, 40);
	}	
	
	//��Ϸ���е��߳�
	class MyThread  implements Runnable {
		public void run() {
		//���߳���Ҫ�ɵ�����	
			//�õ����ƶ�
			while(true) {
				try {
					//�����ƶ�
				ground.move();
				//��һ�������ƶ�
				column1.move();
				//�ڶ��������ƶ�
				column2.move();
				//С���
				bird.fly();
				//С������
				bird.move();
				//���С���Ƿ��붥������淢����ײ
				boolean bool = bird.hit();
				//���С���Ƿ�������1������ײ
				boolean boo2 = bird.hit(column1);
				//���С���Ƿ�������2������ײ
	     		boolean boo3 = bird.hit(column2);
				//��������ײ����Ϸ����
				if(bool || boo2 || boo3) {
				//������Ϸ״̬
					gameOver = true;
				//�����ڵĶ���ȫ����ֹ
					return;
				}
				
				//�������
				if(bird.x == column1.x+column1.w || bird.x == column2.x + column2.w ) {
					score++;
				}
			
				//ÿ�ƶ�һ����Ϣ1����
				Thread.sleep(30);
				//ˢ��
				repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
				}
			}
		}
	}
	
}
