package bean;

import UI.UI;
import service.MyService;

public class Tumbler {
	public static int [][] array = new int[UI.row][UI.cloumn];

	public static void init() {
		int[][] initial= {{7,7},{7,8},{7,10},{7,11},{8,7},{8,8},{8,10},{8,11},
				{9,8},{9,10},{10,6},{10,8},{10,10},{10,12},{11,6},{11,8},{11,10},{11,12},
				{12,6},{12,7},{12,11},{12,12}};
		for(int i=0;i<initial.length;i++) {
			array[initial[i][0]][initial[i][1]]=1;
			UI.list.add(initial[i][0]*UI.cloumn+initial[i][1]);
		}
	}
	
	public static void setTumbler() {
		MyService.change(array);
	}

}
