import java.awt.*;
import javax.swing.*;

public class Demo extends JFrame {
	public Demo() {
		setBounds(100, 100, 300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(null);
		
//		JComboBox<String> comboBox = new JComboBox<>();
//		comboBox.addItem("���֤");
//		comboBox.addItem("ѧ��֤");
//		comboBox.addItem("����֤");  //�����б��������

//		String items[] = {"Ԫ��1", "Ԫ��2", "Ԫ��3"};  //ʹ��string������������б�Ԫ��
//		JComboBox<String> comboBox = new JComboBox<>(items);
		
		JComboBox<String> comboBox = new JComboBox<>();
		String items[] = {"Ԫ��1", "Ԫ��2", "Ԫ��3"};
		ComboBoxModel cm = new DefaultComboBoxModel<>(items); // ���������б�ģ��
		comboBox.setModel(cm);  //���б����������ģ��
		
		JButton btn = new JButton("��ӡ");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("ѡ�е������� "+comboBox.getSelectedIndex()); //��ȡѡ�е�����
				System.out.println("ѡ�е�ֵ�� "+comboBox.getSelectedItem());  //��ȡѡ�е�ֵ
			}
		});
		btn.setBounds(100, 10, 60, 20);
		c.add(btn);
		
		comboBox.setEditable(true);
		comboBox.setBounds(10, 10, 81, 21);
		c.add(comboBox);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Demo();
	}
}
