package lifeGame;

import java.util.List;

public class Test {
	private static UI ui=null;
	public static void main(String[] args) {
		Logic l = new Logic();
		Logic.init();
		ui=new UI();
		//int [] pst = {35,45,47};
		//ui.update(pst);
		
		/*
		for(int i=0;i<3;i++) {
			Logic.change();
			print(UI.list);
		}*/
		//int count=Logic.count(7, 9, Logic.array);
		//System.out.println(count);
	}
	public static void print(List<Integer> list) {
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}
	public static UI getUI() {
		return ui;
	}
}
