package lifeGame;

import java.util.List;

public class Test {

	public static void main(String[] args) {
		UI ui=new UI();
		//int [] pst = {35,45,47};
		//ui.update(pst);
		Logic l = new Logic();
		/*
		for(int i=0;i<3;i++) {
			Logic.change();
			print(UI.list);
		}*/
	}
	public static void print(List<Integer> list) {
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}

}
