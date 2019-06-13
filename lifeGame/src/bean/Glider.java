package bean;

import UI.UI;
import service.MyService;

public class Glider {
	public static int [][] array = new int[UI.row][UI.cloumn];

	public static void init() {
		int[][] initial= {{7,9},{8,10},{9,8},{9,9},{9,10}};
		for(int i=0;i<initial.length;i++) {
			array[initial[i][0]][initial[i][1]]=1;
			UI.list.add(initial[i][0]*UI.cloumn+initial[i][1]);
		}
	}
	
	public static void setGlider() {
		MyService.change(array);
	}
	
}
