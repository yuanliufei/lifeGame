package bean;

import UI.UI;
import service.MyService;

public class LightweightSpaceShip {
	public static int [][] array = new int[UI.row][UI.cloumn];

	public static void init() {
		int[][] initial= {{8,8},{8,9},{8,10},{8,11},
				{9,7},{9,11},{10,11},{11,7},{11,10}};
		MyService.cleanArray(array);
		for(int i=0;i<initial.length;i++) {
			array[initial[i][0]][initial[i][1]]=1;
			UI.list.add(initial[i][0]*UI.cloumn+initial[i][1]);
		}
	}
	
	public static void setLightweightSpaceShip() {
		MyService.change(array);
	}

}
