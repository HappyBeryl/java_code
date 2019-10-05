import java.awt.*;
import javax.swing.*;

public class Demo extends JFrame {
	public Demo() {
		setBounds(100, 100, 300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(null);
		
//		JComboBox<String> comboBox = new JComboBox<>();
//		comboBox.addItem("身份证");
//		comboBox.addItem("学生证");
//		comboBox.addItem("工作证");  //下拉列表添加数据

//		String items[] = {"元素1", "元素2", "元素3"};  //使用string数组添加下拉列表元素
//		JComboBox<String> comboBox = new JComboBox<>(items);
		
		JComboBox<String> comboBox = new JComboBox<>();
		String items[] = {"元素1", "元素2", "元素3"};
		ComboBoxModel cm = new DefaultComboBoxModel<>(items); // 创建下拉列表模型
		comboBox.setModel(cm);  //向列表中添加数据模型
		
		JButton btn = new JButton("打印");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("选中的索引： "+comboBox.getSelectedIndex()); //获取选中的索引
				System.out.println("选中的值： "+comboBox.getSelectedItem());  //获取选中的值
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
