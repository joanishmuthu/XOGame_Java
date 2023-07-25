package com.placement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class XOGame {
	public static void main(String[] args) throws IOException {
		char[][] c=new char[3][3];
		for(int i=0;i<c.length;i++) {
			for(int j=0;j<c[0].length;j++) {
				c[i][j]=' ';
			}
		}
		PlayXO(c);
	}
	static String res="";
	private static void PlayXO(char[][] c) throws IOException {
		// TODO Auto-generated method stub
		while(Playable(c)) {
			Scanner s=new Scanner(System.in);
			System.out.println("player 1 move");
			System.out.println("Enter the position of X");
			BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
			int jo=0;
			while(jo==0) {
				String[] k=bf.readLine().split(" ");
				int i_pos=Integer.parseInt(k[0]);
				int j_pos=Integer.parseInt(k[1]);
				jo=PlaceValue(i_pos,j_pos,c,'X');
			}
			BoardVisualizer(c);
			if(res.equals("won")) {
				break;
			}
			System.out.println("player 2 move");
			System.out.println("Enter the position of O");
			int po=0;
			while(po==0) {
				String[] k1=bf.readLine().split(" ");
				int i_pos1=Integer.parseInt(k1[0]);
				int j_pos1=Integer.parseInt(k1[1]);
				po=PlaceValue(i_pos1,j_pos1,c,'O');
			}
			BoardVisualizer(c);
			if(res.equals("won")) {
				break;
			}
		}
	}

	private static void BoardVisualizer(char[][] c) {
		// TODO Auto-generated method stub
		for(int i=0;i<c.length;i++) {
			for(int j=0;j<c[0].length;j++) {
				System.out.print(c[i][j]+" ");
			}
			System.out.println();
		}
	}

	private static int PlaceValue(int i_pos, int j_pos, char[][] c, char d) {
		// TODO Auto-generated method stub
		if(i_pos<3 && j_pos<3 && i_pos>=0 && j_pos>=0) {
			if(c[i_pos][j_pos]!=' ') {
				System.out.println("Invalid move");
				return 0;
			}
			else {
				c[i_pos][j_pos]=d;
				if(d=='X') {
					CheckWinningX(c);
				}
				else if(d=='O') {
					CheckWinningY(c);
				}
				return 1;
			}
		}
		else {
			System.out.println("invalid position");
			return 0;
		}
		
	}

	private static void CheckWinningX(char[][] c) {
		// TODO Auto-generated method stub
		for(int i=0;i<c.length;i++) {
			for(int j=0;j<c[0].length;j++) {
				int k=i;
				int l=j;
				int count=0;
				while(k<c.length && l<c[0].length) {
					if(c[k][l]=='X') {
						count++;
					}
					k++;
				}
				if(count==3) {
					System.out.println("X Won");
					res="won";
					break;
				}
				k=i;
				l=j;
				count=0;
				while(k<c.length && l<c[0].length) {
					if(c[k][l]=='X') {
						count++;
					}
					k++;
					l++;
				}
				if(count==3) {
					System.out.println("X Won");
					res="won";
					break;
				}
				k=i;
				l=j;
				count=0;
				while(k<c.length && l<c[0].length) {
					if(c[k][l]=='X') {
						count++;
					}
					l++;
				}
				if(count==3) {
					System.out.println("X Won");
					res="won";
					break;
				}
			}
		}
	}

	private static void CheckWinningY(char[][] c) {
		// TODO Auto-generated method stub
		for(int i=0;i<c.length;i++) {
			for(int j=0;j<c[0].length;j++) {
				int k=i;
				int l=j;
				int count=0;
				while(k<c.length && l<c[0].length) {
					if(c[k][l]=='O') {
						count++;
					}
					k++;
				}
				if(count==3) {
					System.out.println("Y Won");
					res="won";
					break;
				}
				k=i;
				l=j;
				count=0;
				while(k<c.length && l<c[0].length) {
					if(c[k][l]=='O') {
						count++;
					}
					k++;
					l++;
				}
				if(count==3) {
					System.out.println("Y Won");
					res="won";
					break;
				}
				k=i;
				l=j;
				count=0;
				while(k<c.length && l<c[0].length) {
					if(c[k][l]=='O') {
						count++;
					}
					l++;
				}
				if(count==3) {
					System.out.println("Y Won");
					res="won";
					break;
				}
			}
		}
	}


	private static boolean Playable(char[][] c) {
		// TODO Auto-generated method stub
		boolean flag=false;
		for(int i=0;i<c.length;i++) {
			for(int j=0;j<c[0].length;j++) {
				if(c[i][j]==' ') {
					flag=true;
					break;
				}
			}
		}
		return flag;
	}
}
