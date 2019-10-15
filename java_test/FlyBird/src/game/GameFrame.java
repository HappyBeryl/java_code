package game;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
/**
 * 
 *��Ϸ������
 *
 */

public class GameFrame extends JFrame {
	//���췽����������ʼ������
	public GameFrame() {
		//���ô���ߴ�(��Ⱥ͸߶�)
		setSize(432, 644);
		//���þ�����ʾ
		setLocationRelativeTo(null);
		//���ùرմ����ͬʱֹͣ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//���ñ���
		setTitle("��ɵĶ���");
		//����logolͼ��img/0.png
		setIconImage(Tools.getImg("../img/0.png"));
	}
	
	public static void main(String[] args) { //һ������ֻ��һ�����
		//����һ���������
		GameFrame frame = new GameFrame();
		//����һ���������
		GamePanel panel = new GamePanel();
		//���������һ�黭��
		frame.add(panel);
		
		//��ʾ����
		frame.setVisible(true);
		
		//������Ϸ
		//panel.start();
	}
}
