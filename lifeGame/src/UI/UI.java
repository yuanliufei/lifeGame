package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import bean.Exploder;
import bean.Glider;
import bean.LightweightSpaceShip;
import bean.SmallExploder;
import bean.TenCellRow;
import bean.Tumbler;

public class UI extends JFrame {

	public static int row=30;
	public static int cloumn=30;
	
	public static String modual=null;
	public static int speed;
	public static volatile int flag=0;
	
	public static JPanel[] panels=new JPanel[row*cloumn];
	
	public static List<Integer> list = new ArrayList<>();
	
	JButton next = null;
	JButton start=null;
	
	public UI() {
		setTitle("LiFe Game");
		
		Container con=getContentPane();
		JPanel centerP=new JPanel(new GridLayout(row, cloumn,1,1));
		centerP.setBackground(Color.BLACK);
		creatPanle();
		for(int i=0;i<panels.length;i++) {
			centerP.add(panels[i]);
		}
		
		JPanel bootonP=new JPanel();
		
		String[] listModual = {"Clear","Glider","Small Exploder","Exploder"
				,"10 Cell Row","Lightweight spaceship","Tumbler"};
		JComboBox<String> comboBox = new JComboBox<String>(listModual);
		selectModual(comboBox);
		
		next=new JButton("Next");
		
		next.addActionListener(new ActionListener() {
   			
   			@Override
   			public void actionPerformed(ActionEvent e) {
   				buttonNext(modual);
   			}
   		});
		
		start=new JButton("start");
	    
        start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				System.out.println(flag);
				if(flag==0) {
					t.start();
					start.setText("stop");
					flag=1;
				}
				else if(flag==1) {
					System.out.println("1 to 2");
					flag=2;
					start.setText("start");
				}else if(flag==2) {
					System.out.println("2 to 1");
					flag=1;
					start.setText("stop");
				}
			}
		});
		JLabel jlSpeed=new JLabel("speed");
		JSlider jsSpeed=new JSlider(JSlider.HORIZONTAL, 0, 100, 1);		
		jsSpeed.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO 自动生成的方法存根
				JSlider s=(JSlider) e.getSource();
				speed=s.getValue();
			}
		});
		
		bootonP.add(comboBox);	
		bootonP.add(next);
		bootonP.add(start);
		bootonP.add(jlSpeed);
		bootonP.add(jsSpeed);
		
		con.add(centerP, BorderLayout.CENTER);
		con.add(bootonP, BorderLayout.SOUTH);
		
		setSize(1000, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void creatPanle() {
		for(int i=0;i<panels.length;i++) {
			panels[i] = new JPanel();
			panels[i].setBackground(Color.WHITE);
		}
	}
	
	public void setPanle() {
		for(int i=0;i<panels.length;i++) {
			panels[i].setBackground(Color.WHITE);
		}
	}
	
	public void buttonNext(String modual) {
		if(modual!=null) {
		switch(modual) {
		case "Clear":
			setPanle();
			break;
		case "Glider":
			Glider.setGlider();
			break;
		case "Small Exploder":
			SmallExploder.setSmallExploder();
			break;
		case "Exploder":
			Exploder.setExploder();
			break;
		case "10 Cell Row":
			TenCellRow.setTenCellRow();
			break;
		case "Lightweight spaceship":
			LightweightSpaceShip.setLightweightSpaceShip();
			break;
		case "Tumbler":
			Tumbler.setTumbler();
			break;
		}
		for(int i=0;i<list.size();i++) {
			if(panels[list.get(i)].getBackground().equals(Color.white)) {
				panels[list.get(i)].setBackground(Color.PINK);
			}else {
				panels[list.get(i)].setBackground(Color.WHITE);
			}
		}
		list.clear();
		}
	}
	
	Thread t=new Thread(new Runnable() {
		
		@Override
		public void run() {
			// TODO 自动生成的方法存根
			while(true) {
				if(flag==1) {
					try {
						buttonNext(modual);
						Thread.sleep(1000-speed*10);
					} catch (InterruptedException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				}
				
			}
		}
	});
	
	public void selectModual(JComboBox<String> comboBox) {
        // 添加条目选中状态改变的监听器
        comboBox.addItemListener(new ItemListener() {
        	//String modual = null;
            @Override
            public void itemStateChanged(ItemEvent e) {
                // 只处理选中的状态
                if (e.getStateChange() == ItemEvent.SELECTED) {
                	modual = (String) comboBox.getSelectedItem();
                	changeModual(modual);  
                }
            }
        });
	}
	
	public void changeModual(Object modualName) {
		switch((String)modualName) {
		case "Clear":
			setPanle();
			list.clear();
			break;
		case "Glider":
			setPanle();
			Glider.init();
			initPaneModual();
			break;
		case "Small Exploder":
			setPanle();
			SmallExploder.init();
			initPaneModual();
			break;
		case "Exploder":
			setPanle();
			Exploder.init();
			initPaneModual();
			break;
		case "10 Cell Row":
			setPanle();
			TenCellRow.init();
			initPaneModual();
			break;
		case "Lightweight spaceship":
			setPanle();
			LightweightSpaceShip.init();
			initPaneModual();
			break;
		case "Tumbler":
			setPanle();
			Tumbler.init();
			initPaneModual();
			break;
		}
	}
	
	public void initPaneModual() {
		for(int i=0;i<list.size();i++) {
			panels[list.get(i)].setBackground(Color.pink);
		}
		list.clear();
	}
}

