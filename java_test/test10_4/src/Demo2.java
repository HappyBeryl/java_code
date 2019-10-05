
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.plaf.basic.DefaultMenuLayout;
public class Demo2 extends JFrame {
	public Demo2() {
		setBounds(100, 100, 300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(null);
		
		String items[] = {"Ԫ��1", "Ԫ��2", "Ԫ��3", "Ԫ��4", "Ԫ��5", "Ԫ��6", "Ԫ��7"};	
	//	JList<String> j1 = new JList<>(items);
		
		DefaultListModel<String> model = new DefaultListModel<>(); //�б�������ģ��
		for(String tmp: items) {
			model.addElement(tmp);  //������ģ�����Ԫ��
		}
		JList<String> j1 = new JList<>();
		model.addElement("���Ԫ��");  //����ģ�������Ԫ��
		j1.setModel(model);  //�б���������ģ��
//		j1.setBounds(10, 10, 100, 100); // ��������ʹ�С
		//c.add(j1);
		
        /*
         *MULTIPLE_INTERVAL_SELECTION ���ѡ
         *SINGLE_INTERVAL_SELECTION ֻ������ѡ������Ԫ��
         *SINGLE_SELECTION  ��ѡ
         */
		j1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JScrollPane js = new JScrollPane(j1); //Ϊ�б����ӹ�����
		js.setBounds(10, 10, 100, 100); // ���ù���������ʹ�С
		c.add(js);
		
		JButton btn = new JButton("ȷ��");
		btn.setBounds(120, 90, 70, 25);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				j1.getSelectedValuesList();
				//��ȡ�б�������Ԫ��
				List<String> values = j1.getSelectedValuesList();
				for(String tmp: values) {
					System.out.println(tmp);
				}
				System.out.println("---------end--------");
			}
		});
		c.add(btn);
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		new Demo2();
	}
}