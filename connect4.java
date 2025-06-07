import java.util.*;
import java.io.*;
public class connect4
{
	static Scanner input = new Scanner(System.in);
	static char firstChoice;
	static char secondChoice;
	static int rowNumber=6;
	static int colNumber=7;
	static char[][] board = new char [rowNumber][colNumber];
	static int [] height= new int[colNumber];
	static char winner;
	public static void setupBoard(){
		winner='?';
		for(int r = 0; r < rowNumber; r++)
		{
			for(int c = 0; c < colNumber; c++)
			{
				board[r][c]='?';
			}
		}
		for(int i =0; i< colNumber; i++){
			height[i]=0;
		}
	}
	public static void chooseCharacter(){
		System.out.println("Do you want to be Yellow or Red?");
		String line=input.next();
		firstChoice=line.charAt(0);
		secondChoice='r';
		if(firstChoice=='r'){
			secondChoice='y';
		}
	}
	public static void printBoard(){
		for(int r = rowNumber - 1; r >= 0; r--){
			for(int c =0; c < colNumber; c++){
				if(board[r][c]=='?'){
					System.out.print(". ");
				}
				else{
					System.out.print(board[r][c]+" ");	
				}
			}
			System.out.println();
		}
		for(int i=1; i<=colNumber; i++){
			System.out.print(i+" ");
		}
		System.out.println();
	}
	public static boolean verCheck(){
		for(int r=0; r< rowNumber-3; r++){
			for(int c=0; c< colNumber; c++){
				if(board[r][c] != '?' && board[r+1][c]==board[r][c] && board[r+2][c]== board[r][c] && board[r+3][c]==board[r][c]){
					return true;
				}
			}
		}
		return false;
	}
	public static boolean horCheck(){
		for(int r=0; r< rowNumber; r++){
			for( int c=0; c< colNumber-3; c++){
				if(board[r][c] != '?' && board[r][c+1]==board[r][c] && board[r][c+2]== board[r][c] && board [r][c+3]==board [r][c]){
					return true;
				}
			}
		}
		return false;

	} 
	public static boolean diaCheck(){
		for(int r=0; r< rowNumber; r++){
			for(int c=0; c< colNumber; c++){
				if(r + 3 < rowNumber && c+3 < colNumber){
					if(board[r][c] != '?' && board[r+1][c+1]==board[r][c] && board[r+2][c+2]== board[r][c] && board [r+3][c+3]==board [r][c]){
						return true;
					}
				}
				if(r + 3 < rowNumber && c-3 >= 0){
					if(board[r][c] != '?' && board[r+1][c-1]==board[r][c] && board[r+2][c-2]== board[r][c] && board [r+3][c-3]==board [r][c]){
						return true;
					}
				}
			}
		}
		return false;
	}
	public static boolean checkforWinner(){
		if (verCheck()){
			return true;
		}
		if(horCheck()){
			return true;
		}
		return false;
	}
	public static void playGame(){
		for(int turn=0; turn< rowNumber * colNumber; turn++){
			printBoard();
			int column=-1;

			while(true){
				while(true){
					System.out.print("What column do you want to put you piece in? ");
					column=input.nextInt();
					column --;
					if(column>=colNumber|| column < 0){
						System.out.println("Not a valid number.");
					}
					else{
						break;
					}
				}
			
				if(height[column]>=rowNumber){
					System.out.println("That column is filled up: Pick again");
				}
				else{
					break;
				}
			}
			if(turn%2==0)
			{
				board[height[column]][column] = firstChoice;
			}
			else{
				board[height[column]][column] = secondChoice;
			}
			height[column]++;
			if(checkforWinner()){
				printBoard();
				if(turn%2==0){
					winner = firstChoice;
				}
				else{
					winner = secondChoice;
				}
				break;
			}
		}
		if(winner=='?'){
			System.out.println("Nobody won");
		}
		else{
			System.out.println(winner+" won");
		}
	}
	public static void main(String[] args) throws IOException
	{
		setupBoard();
		chooseCharacter();
		playGame();
		/*
		gravity = make sure the piece goes all the way to the ground
		array = length = 7, height 
		check for winner= diagonal, verticle, horrizonatal, needs to have 4 in a row in any direction
		setup board = 6, 7
		user input= piece color, column, error
		*/
	}
}