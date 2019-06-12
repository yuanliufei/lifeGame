package lifeGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
//import javax.swing.JTextField;

public class UI extends JFrame {

	public static int row=10;
	public static int cloumn=10;
	public static JPanel[] panels=new JPanel[row*cloumn];
	public static List<Integer> list = new ArrayList<>();
	
	
	public UI() {
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
		JButton start=new JButton("start");
		start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				buttonStart();
			}
		});
		JButton stop=new JButton("stop");
		bootonP.add(start);
		bootonP.add(stop);
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
	
	public void update(int[] pst) {
		for(int i:pst) {
			panels[i].setBackground(Color.pink);
		}
	}
	
	public void buttonStart() {
		Logic.change();
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
