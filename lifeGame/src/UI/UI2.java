package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import bean.Exploder;
import bean.Glider;
import bean.LightweightSpaceShip;
import bean.SmallExploder;
import bean.TenCellRow;
import bean.Tumbler;


//import javax.swing.JTextField;

public class UI2 extends JFrame {

	public static int row=20;
	public static int cloumn=20;
	public static JPanel[] panels=new JPanel[row*cloumn];
	public static List<Integer> list = new ArrayList<>();
	private static Thread t;
	private static int interval=0;
	private static int flag=0;
	
	public UI2() {
		// TODO Auto-generated constructor stub
		setTitle("LiFe Game");
		Container con=getContentPane();
		JPanel centerP=new JPanel(new GridLayout(row, cloumn,1,1));
		centerP.setBackground(Color.BLACK);
		creatPanle();
		for(int i=0;i<panels.length;i++) {
			centerP.add(panels[i]);
		}
		JPanel bootonP=new JPanel();
		
		JComboBox<String> jc=new JComboBox<>(new MyComboBox());	//new
		JLabel jlSpeed=new JLabel("speed");
		JSlider jsSpeed=new JSlider(JSlider.HORIZONTAL, 0, 100, 1);		
		JLabel jlSize=new JLabel("size");
		JSlider jsSize=new JSlider(JSlider.HORIZONTAL, 0, 100, 1);		
		JTextField jtf=new JTextField(1);
		JButton jbInfo=new JButton("help");
		jbInfo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				new MyJDialog().setVisible(true);
			}
		});
		JButton reset=new JButton("reset");
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				//Logic.init();
				update(list);				//待修改
			}
		});
		update(list);
		JButton next=new JButton("Next");
		next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				buttonStart();
			}
		});
		t=new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO 自动生成的方法存根
				while(true) {
					if(flag==2) {
						buttonStart();
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						}
					}else {
						continue;
					}
				}
			}
		});
		JButton stop=new JButton("start");
		stop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if(flag==0) {
					t.start();
					flag=2;
					stop.setText("stop");
				}
				else if(flag==1) {
					flag=2;
					stop.setText("stop");
					
				}else{				//需要调试
					flag=1;
					stop.setText("start");
					
				}
				
			}
		});
		bootonP.add(jc);	//new
		
		bootonP.add(next);
		bootonP.add(stop);
		
		bootonP.add(reset);//new
		bootonP.add(jtf);	
		bootonP.add(jlSpeed);
		bootonP.add(jsSpeed);		
		bootonP.add(jlSize);		
		bootonP.add(jsSize);
		bootonP.add(jbInfo);
		
		con.add(centerP, BorderLayout.CENTER);
		con.add(bootonP, BorderLayout.SOUTH);
		setSize(500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void creatPanle() {
		for(int i=0;i<panels.length;i++) {
			panels[i] = new JPanel();
			panels[i].setBackground(Color.WHITE);
		}
	}
	
	public void update(List<Integer> list) {
		for(int i=0;i<list.size();i++){
			panels[list.get(i)].setBackground(Color.pink);
		}
		list.clear();
	}
	
	public void buttonStart() {
		//Logic.change();
		//Glider.setGlider();
		//SmallExploder.setGlider();
		//Exploder.setGlider();
		//TenCellRow.setTenCellRow();
		//Tumbler.setTumbler();
		LightweightSpaceShip.setLightweightSpaceShip();
		for(int i=0;i<list.size();i++) {
			if(panels[list.get(i)].getBackground().equals(Color.white)) {
				panels[list.get(i)].setBackground(Color.PINK);
			}else {
				panels[list.get(i)].setBackground(Color.WHITE);
			}
		}
		list.clear();
	}
	
	public void updateList() {
		//for(int i)
	}
}
class MyComboBox extends AbstractListModel<String> implements ComboBoxModel<String>{
	String selecteditem=null;
	String[] test= {"aaaa","b","c","d"};
	@Override
	public int getSize() {
		// TODO 自动生成的方法存根
		return test.length;
	}

	@Override
	public String getElementAt(int index) {
		// TODO 自动生成的方法存根
		return test[index];
	}

	@Override
	public void setSelectedItem(Object anItem) {
		// TODO 自动生成的方法存根
		selecteditem=(String) anItem;
	}

	@Override
	public Object getSelectedItem() {
		// TODO 自动生成的方法存根
		return selecteditem;
	}
	
}
class MyJDialog extends JDialog{
	public MyJDialog() {
		//super(Test.getUI(), "info", true);
		Container con=getContentPane();
		JTextArea jta=new JTextArea("info");
		con.add(jta);
		setBounds(200, 100, 200, 200);
	}
}