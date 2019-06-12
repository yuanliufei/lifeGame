package lifeGame;

public class Logic {
	public static int [][] array = new int[UI.row][UI.cloumn];
	
	
	static {
		array[4][4]=1;
		array[4][5]=1;
		array[4][7]=1;
		array[4][6]=1;
		array[5][4]=1;
		//等会要改的
		//UI.list.add(0*10+);
	}
	
	public static void change() {
		int [][] copyArray= new int[UI.row][UI.cloumn]; 
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array[i].length;j++) {
				copyArray[i][j] = array[i][j];
			}
		}
		for(int i=1;i<copyArray.length-1;i++) {
			for(int j=1;j<copyArray[i].length-1;j++) {
				if(copyArray[i][j]==1 && (count(i,j,copyArray)==2 ||count(i,j,copyArray)==3 ))
					array[i][j] = 1;
				else if(copyArray[i][j]==0 && count(i,j,copyArray)==3) {
					array[i][j] = 1;
					UI.list.add(i*UI.cloumn+j);
				}else {
					if(copyArray[i][j]==1) {
						array[i][j]=0;
						UI.list.add(i*UI.cloumn+j);
					}
				}
			}
		}
	}
	
	public static int count(int i,int j,int[][] array) {
		return array[i-1][j-1]+array[i-1][j]+array[i-1][j+1]+
				array[i][j-1]+array[i][j+1]+array[i+1][j-1]+array[i+1][j]+array[i+1][j+1];
	}
}
