package bean;

import UI.UI;
import service.MyService;

public class TenCellRow {

	public static int [][] array = new int[UI.row][UI.cloumn];

	public static void init() {
		int[][] initial= {{9,4},{9,5},{9,6},{9,7},{9,8},
				{9,9},{9,10},{9,11},{9,12},{9,13}};
		MyService.cleanArray(array);
		for(int i=0;i<initial.length;i++) {
			array[initial[i][0]][initial[i][1]]=1;
			UI.list.add(initial[i][0]*UI.cloumn+initial[i][1]);
		}
	}
	
	public static void setTenCellRow() {
		MyService.change(array);
	}
}
