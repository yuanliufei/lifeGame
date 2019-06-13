package lifeGame;

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

public class UI extends JFrame {

	public static int row=20;
	public static int cloumn=20;
	public static JPanel[] panels=new JPanel[row*cloumn];
	public static List<Integer> list = new ArrayList<>();
	JButton next = null;
	
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
		//comboBox.
		selectModual(comboBox);
		/*
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
		
		selectModual(comboBox);
		
		JButton reset=new JButton("reset");
		reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				Logic.init();
				update(list);				//待修改
			}
		});
		*/
		
		/*JButton */next=new JButton("Next");
		/*
		next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				buttonNext(modual);
			}
		});*/
		
		JButton stop=new JButton("start");
		
		bootonP.add(comboBox);	//new
		
		bootonP.add(next);
		bootonP.add(stop);
		
		/*
		bootonP.add(reset);//new
		bootonP.add(jtf);	
		bootonP.add(jlSpeed);
		bootonP.add(jsSpeed);		
		bootonP.add(jlSize);		
		bootonP.add(jsSize);
		bootonP.add(jbInfo);*/
		
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
	
	public void setPanle() {
		for(int i=0;i<panels.length;i++) {
			panels[i].setBackground(Color.WHITE);
		}
	}
	
	public void buttonNext(String modual) {
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
	
	public void selectModual(JComboBox<String> comboBox) {
        // 添加条目选中状态改变的监听器
        comboBox.addItemListener(new ItemListener() {
        	String modual = null;
            @Override
            public void itemStateChanged(ItemEvent e) {
                // 只处理选中的状态
                if (e.getStateChange() == ItemEvent.SELECTED) {
                   changeModual(comboBox.getSelectedItem());  
                   modual = (String) comboBox.getSelectedItem();
                   next.addActionListener(new ActionListener() {
           			
           			@Override
           			public void actionPerformed(ActionEvent e) {
           				buttonNext(modual);
           			}
           		});
                }
            }
        });
	}
	
	public void changeModual(Object modualName) {
		switch((String)modualName) {
		case "Clear":
			setPanle();
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

