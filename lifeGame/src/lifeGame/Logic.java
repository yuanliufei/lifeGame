package lifeGame;

public class Logic {
	public static int [][] array = new int[UI.row][UI.cloumn];
	
	
	static {
		array[4][4]=1;
		array[4][5]=1;
		array[4][7]=1;
		array[4][6]=1;
		array[5][4]=1;	
	}
	
	public static void change() {
		int [][] copyArray= new int[UI.row][UI.cloumn]; 
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array[i].length;j++) {
				copyArray[i][j] = array[i][j];
			}
		}
		
		
		for(int i=0;i<copyArray.length;i++) {
			for(int j=0;j<copyArray[i].length;j++) {
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
	
	/*
	public static int count2(int i,int j,int[][] array) {
		return array[i-1][j-1]+array[i-1][j]+array[i-1][j+1]+
				array[i][j-1]+array[i][j+1]+array[i+1][j-1]+array[i+1][j]+array[i+1][j+1];
	}*/
	
	public static int count(int i,int j,int[][] array) {
		int count=0;
		if(i==0) {
			if(j==0) {
				count=array[i][j+1]+array[i+1][j]+array[i+1][j+1];
			}else if(j==UI.cloumn-1) {
				count=array[i][j-1]+array[i+1][j]+array[i+1][j-1];
			}else {
				count=array[i][j-1]+array[i+1][j-1]+array[i+1][j]+
				array[i+1][j+1]+array[i][j+1];
			}
		}else if(i==UI.row-1) {
			if(j==0) {
				count=array[i-1][j]+array[i-1][j+1]+array[i][j+1];
			}else if(j==UI.cloumn-1) {
				count=array[i-1][j-1]+array[i-1][j]+array[i][j-1];
			}else {
				count=array[i-1][j-1]+array[i-1][j]+array[i-1][j+1]+
				array[i][j-1]+array[i][j+1];
			}
		}else if(j==0) {
			count=array[i-1][j]+array[i-1][j+1]+array[i][j+1]+
				array[i+1][j+1]+array[i+1][j];
		}else if(j==UI.cloumn-1) {
			count=array[i-1][j]+array[i-1][j-1]+array[i][j-1]+
					array[i+1][j-1]+array[i+1][j];	
		}else {
			count = array[i-1][j-1]+array[i-1][j]+array[i-1][j+1]+
					array[i][j-1]+array[i][j+1]+array[i+1][j-1]+array[i+1][j]+array[i+1][j+1];
		}
		
		return count;
	}
}
