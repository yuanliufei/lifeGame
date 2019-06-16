package service;

import UI.UI;

public class MyService {
	
	public static void change(int[][] array) {
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
	public static void cleanArray(int[][] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				arr[i][j]=0;
			}
		}
	}
}
