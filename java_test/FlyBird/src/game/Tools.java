package game;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Tools {
	/**
	 * ������������ͼƬ·����ȡͼƬ�ķ���
	 * ������
	 *
	 */
	public static BufferedImage getImg(String path) {
		//����һ��ͼƬ
		BufferedImage img = null; 
		try {
		    img = ImageIO.read(Tools.class.getResource(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return img;
	}
	
}
