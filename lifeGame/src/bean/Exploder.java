package bean;

import UI.UI;
import service.MyService;

public class Exploder {

	public static int [][] array = new int[UI.row][UI.cloumn];

	public static void init() {
		int[][] initial= {{7,7},{7,9},{7,11},{8,7},{8,11},
				{9,7},{9,11},{10,7},{10,11},{11,7},{11,9},{11,11}};
		for(int i=0;i<initial.length;i++) {
			array[initial[i][0]][initial[i][1]]=1;
			UI.list.add(initial[i][0]*UI.cloumn+initial[i][1]);
		}
	}
	
	public static void setExploder() {
		MyService.change(array);
	}
}
