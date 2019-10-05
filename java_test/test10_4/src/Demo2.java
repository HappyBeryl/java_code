
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
		
		String items[] = {"元素1", "元素2", "元素3", "元素4", "元素5", "元素6", "元素7"};	
	//	JList<String> j1 = new JList<>(items);
		
		DefaultListModel<String> model = new DefaultListModel<>(); //列表框的数据模型
		for(String tmp: items) {
			model.addElement(tmp);  //向数据模型添加元素
		}
		JList<String> j1 = new JList<>();
		model.addElement("添加元素");  //数据模型添加新元素
		j1.setModel(model);  //列表载入数据模型
//		j1.setBounds(10, 10, 100, 100); // 设置坐标和大小
		//c.add(j1);
		
        /*
         *MULTIPLE_INTERVAL_SELECTION 随便选
         *SINGLE_INTERVAL_SELECTION 只能连续选择相邻元素
         *SINGLE_SELECTION  单选
         */
		j1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JScrollPane js = new JScrollPane(j1); //为列表框添加滚动条
		js.setBounds(10, 10, 100, 100); // 设置滚动条坐标和大小
		c.add(js);
		
		JButton btn = new JButton("确认");
		btn.setBounds(120, 90, 70, 25);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				j1.getSelectedValuesList();
				//获取列表中所有元素
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