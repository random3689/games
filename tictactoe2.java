import java.util.*;
import java.io.*;
public class tictactoe2{
	static Scanner input = new Scanner(System.in);
	static char firstChoice;
	static char secondChoice;
	static char[][] board = new char [3][3];
	static char winner;
	public static void setupBoard(){
		winner='?';
		for(int r = 0; r < 3; r++)
		{
			for(int c = 0; c < 3 ; c++)
			{
				board[r][c]='?';
			}
		}
	}
	public static void chooseCharacter(){
		System.out.println("Do you want to be x or o?");
		String line=input.next();
		firstChoice=line.charAt(0);//What if they dont choose x or o?
		secondChoice='x';
		if(firstChoice=='x'){
			secondChoice='o';
		}
	}
	static boolean checkDiagonals()
	{
		if(board [0] [0]!= '?'&& board[0][0] == board[1][1] && board[1][1] == board[2][2]){
			return true;
		}
		if( board [0] [2]!= '?'&& board[0][2] == board[1][1] && board[1][1] == board[2][0]){
			return true;
		}
		return false;
	}
	static boolean checkRow(int row){
		if(board [row] [0]!= '?'&& board[row][0] == board[row][1] && board[row][0] == board[row][2]){
			return true;
		}
		return false;	
	}
	static boolean checkCol(int col){
		if(board [0] [col]!= '?'&& board[0][col] == board[1][col] && board[0][col] == board[2][col]){
			return true;
		}
		return false;	
	}
	public static boolean checkforWinner(){
		if(checkDiagonals()){
			return true;
		}
		for(int r = 0;r < 3;r++){
			if(checkRow(r)){
				return true;
			}
		}
		for(int c =0; c<3;c++){
			if(checkCol(c)){
				return true;
			}
		}
		return false;
	} 
	public static void playGame()
	{
		for(int turn=0; turn<9; turn++)
		{
			for(int r = 0; r < 3; r++)
			{
				for(int c = 0; c < 3; c++)
				{
					System.out.print(board[r][c]);
				}
				System.out.println();
			}
			int row=-1;
			int column=-1;

			while(true){
				while(true){
					System.out.print("What row do you want to put your piece? ");
					row=input.nextInt();// what if they dont put in a number 0-2
					if(row>2){
						System.out.println("Not a valid number.");
					}
					else{
						break;
					}
				}
				while(true){
					System.out.print("What column do you want to put you piece in? ");
					column=input.nextInt();	
					if(column>2){
						System.out.println("Not a valid number.");
					}
					else{
						break;
					}
				}
			
				if(board[row][column]!='?'){
					System.out.println("There is a piece already there. Pick again");
				}
				else{
					break;
				}
			}
			if(turn%2==0){
				board[row][column] = firstChoice;
			}
			else{
				board[row][column] = secondChoice;
			}
			if (checkforWinner()){
				if(turn%2==0){
					winner = firstChoice;
				}
				else{
					winner=secondChoice;
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
	public static void main(String[] args) throws IOException{
		while(true){
			setupBoard();
			chooseCharacter();
			playGame();
			System.out.println("Wanna play again? (Yes or No)");
			String playAgain=input.next().toLowerCase();
			if(playAgain.equals("no")){
				break;
			}
		}
	}
}


