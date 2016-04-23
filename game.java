package game;

import java.util.*;

public class game {

	public static Scanner reader = new Scanner(System.in);
	
	private static char[][] globalBoard = new char[][]{
		  { 32, 32, 32, 'x' },
		  { 32, 32, 32, 32 },
		  { 32, 'x', 32, 32 },
		  { 'x', 32, 32, 32 }
		};
	
	public static void globalBoardLayout() {
		System.out.printf("---------\n");
		for (int i = 0; i<globalBoard.length; i++) {
			System.out.printf("|");
			for (int h = 0; h<globalBoard[i].length; h++){
				System.out.printf("%c|",globalBoard[i][h]);
			}
			
			System.out.printf("\n---------\n");
		}
		
	}
	//private static char cpu=0;
	
	public static void main(String[] args) {

		boolean game = true;
		char cpu=0;
		char turn=0;
		
		System.out.printf("Would you like to play against the computer? [y/n]\n");
		char temp=goodinput('y','n');
		
		if (temp=='y')
		{	
			System.out.printf("Would you like to be x's or o's? [x/o]\n");
			char player=goodinput('x','o');
			if (player=='o')
				cpu='x';
			else if (player=='x')
				cpu='o';
			
			System.out.printf("Would you like to start? [y/n]\n");
			temp=goodinput('y','n');
			if (temp=='y')
				turn=player;
			else if (temp=='n')
				turn=cpu;
		}
		
		else if(temp=='n')
		{
			turn='x';
		}
		
		while(game==true) // runs the game. once this loop is broken, the game ends
		{	
			turn(turn,cpu); // execute a turn
			
			globalBoardLayout(); // draw the board
				
			game=checkwin(); // check if someone won
			
			if (game==true)
			{
				//turn = turn=='x'?'o':'x';
				if (turn == 'x')
					turn = 'o';
				else if(turn == 'o')
					turn = 'x';
			}
			
		}
		if (cpu==0)
			System.out.printf("Player %c wins!",turn);
		else if(cpu==turn)
			System.out.printf("The computer wins!");
		else
			System.out.printf("The player wins!");
		
		
		
	}
	public static char goodinput(char op1, char op2)
	{
		char temp = reader.next().charAt(0);
		
		while(temp!=op1 && temp!=op2)
		{
			System.out.printf("Please enter an %c or an %c\n", op1, op2);
			temp = reader.next().charAt(0);
		}
		return temp;
	}
	
	public static int[] cputurn(char cpu)
	{
		//int x = 5;
		//int y = 5;
		int arr[] = new int[2];
		char player=0;
		
		if(cpu=='x')
		{
			player='o';
		}
		else if (cpu=='o')
		{
			player='x';
		}

		for (int i = 0; i<globalBoard.length; i++)
		{
			if (globalBoard[i][0]==globalBoard[i][1]&&globalBoard[i][0]==globalBoard[i][2]&&globalBoard[i][0]==cpu&&globalBoard[i][3]==32)
			{
				arr[0]=i;
				arr[1]=3;
				return arr;
			}
			else if (globalBoard[i][0]==globalBoard[i][1]&&globalBoard[i][0]==globalBoard[i][3]&&globalBoard[i][0]==cpu&&globalBoard[i][2]==32)
			{
				arr[0]=i;
				arr[1]=2;
				return arr;
			}
			else if (globalBoard[i][0]==globalBoard[i][3]&&globalBoard[i][0]==globalBoard[i][2]&&globalBoard[i][0]==cpu&&globalBoard[i][1]==32)
			{
				arr[0]=i;
				arr[1]=1;
				return arr;
			}
			else if (globalBoard[i][1]==globalBoard[i][3]&&globalBoard[i][1]==globalBoard[i][2]&&globalBoard[i][1]==cpu&&globalBoard[i][0]==32)
			{
				arr[0]=i;
				arr[1]=0;
				return arr;
			}
			else if (globalBoard[0][i]==globalBoard[1][i]&&globalBoard[0][i]==globalBoard[2][i]&&globalBoard[0][i]==cpu&&globalBoard[3][i]==32)
			{
				arr[0]=3;
				arr[1]=i;
				return arr;
			}
			else if (globalBoard[0][i]==globalBoard[3][i]&&globalBoard[0][i]==globalBoard[2][i]&&globalBoard[0][i]==cpu&&globalBoard[1][i]==32)
			{
				arr[0]=1;
				arr[1]=i;
				return arr;
			}
			else if (globalBoard[0][i]==globalBoard[1][i]&&globalBoard[0][i]==globalBoard[3][i]&&globalBoard[0][i]==cpu&&globalBoard[2][i]==32)
			{
				arr[0]=2;
				arr[1]=i;
				return arr;
			}
			else if (globalBoard[1][i]==globalBoard[1][i]&&globalBoard[1][i]==globalBoard[2][i]&&globalBoard[1][i]==cpu&&globalBoard[0][i]==32)
			{
				arr[0]=0;
				arr[1]=i;
				return arr;
			}

		}
		
		if(globalBoard[0][0]==globalBoard[1][1]&&globalBoard[0][0]==globalBoard[2][2]&&globalBoard[0][0]==cpu&&globalBoard[3][3]==32)
		{
			arr[0]=3;
			arr[1]=3;
			return arr;
		}
		else if(globalBoard[3][3]==globalBoard[1][1]&&globalBoard[3][3]==globalBoard[2][2]&&globalBoard[3][3]==cpu&&globalBoard[0][0]==32)
		{
			arr[0]=0;
			arr[1]=0;
			return arr;
		}
		else if(globalBoard[0][0]==globalBoard[3][3]&&globalBoard[0][0]==globalBoard[2][2]&&globalBoard[0][0]==cpu&&globalBoard[1][1]==32)
		{
			arr[0]=1;
			arr[1]=1;
			return arr;
		}
		else if(globalBoard[0][0]==globalBoard[1][1]&&globalBoard[0][0]==globalBoard[3][3]&&globalBoard[0][0]==cpu&&globalBoard[2][2]==32)
		{
			arr[0]=2;
			arr[1]=2;
			return arr;
		}
		else if(globalBoard[0][3]==globalBoard[1][2]&&globalBoard[0][3]==globalBoard[2][1]&&globalBoard[0][3]==cpu&&globalBoard[3][0]==32)
		{
			arr[0]=3;
			arr[1]=0;
			return arr;
		}
		else if(globalBoard[3][0]==globalBoard[1][2]&&globalBoard[3][0]==globalBoard[2][1]&&globalBoard[3][0]==cpu&&globalBoard[0][3]==32)
		{
			arr[0]=0;
			arr[1]=3;
			return arr;
		}
		else if(globalBoard[0][3]==globalBoard[3][0]&&globalBoard[0][3]==globalBoard[2][1]&&globalBoard[0][3]==cpu&&globalBoard[1][2]==32)
		{
			arr[0]=1;
			arr[1]=2;
			return arr;
		}
		else if(globalBoard[0][3]==globalBoard[1][2]&&globalBoard[0][3]==globalBoard[3][0]&&globalBoard[0][3]==cpu&&globalBoard[2][1]==32)
		{
			arr[0]=2;
			arr[1]=1;
			return arr;
		}
		
		for (int i = 0; i<globalBoard.length; i++)
		{
			if (globalBoard[i][0]==globalBoard[i][1]&&globalBoard[i][0]==globalBoard[i][2]&&globalBoard[i][0]==player&&globalBoard[i][3]==32)
			{
				arr[0]=i;
				arr[1]=3;
				return arr;
			}
			else if (globalBoard[i][0]==globalBoard[i][1]&&globalBoard[i][0]==globalBoard[i][3]&&globalBoard[i][0]==player&&globalBoard[i][2]==32)
			{
				arr[0]=i;
				arr[1]=2;
				return arr;
			}
			else if (globalBoard[i][0]==globalBoard[i][3]&&globalBoard[i][0]==globalBoard[i][2]&&globalBoard[i][0]==player&&globalBoard[i][1]==32)
			{
				arr[0]=i;
				arr[1]=1;
				return arr;
			}
			else if (globalBoard[i][1]==globalBoard[i][3]&&globalBoard[i][1]==globalBoard[i][2]&&globalBoard[i][1]==player&&globalBoard[i][0]==32)
			{
				arr[0]=i;
				arr[1]=0;
				return arr;
			}
			else if (globalBoard[0][i]==globalBoard[1][i]&&globalBoard[0][i]==globalBoard[2][i]&&globalBoard[0][i]==player&&globalBoard[3][i]==32)
			{
				arr[0]=3;
				arr[1]=i;
				return arr;
			}
			else if (globalBoard[0][i]==globalBoard[3][i]&&globalBoard[0][i]==globalBoard[2][i]&&globalBoard[0][i]==player&&globalBoard[1][i]==32)
			{
				arr[0]=1;
				arr[1]=i;
				return arr;
			}
			else if (globalBoard[0][i]==globalBoard[1][i]&&globalBoard[0][i]==globalBoard[3][i]&&globalBoard[0][i]==player&&globalBoard[2][i]==32)
			{
				arr[0]=2;
				arr[1]=i;
				return arr;
			}
			else if (globalBoard[1][i]==globalBoard[1][i]&&globalBoard[1][i]==globalBoard[2][i]&&globalBoard[1][i]==player&&globalBoard[0][i]==32)
			{
				arr[0]=0;
				arr[1]=i;
				return arr;
			}

		}
		
		if(globalBoard[0][0]==globalBoard[1][1]&&globalBoard[0][0]==globalBoard[2][2]&&globalBoard[0][0]==player&&globalBoard[3][3]==32)
		{
			arr[0]=3;
			arr[1]=3;
			return arr;
		}
		else if(globalBoard[3][3]==globalBoard[1][1]&&globalBoard[3][3]==globalBoard[2][2]&&globalBoard[3][3]==player&&globalBoard[0][0]==32)
		{
			arr[0]=0;
			arr[1]=0;
			return arr;
		}
		else if(globalBoard[0][0]==globalBoard[3][3]&&globalBoard[0][0]==globalBoard[2][2]&&globalBoard[0][0]==player&&globalBoard[1][1]==32)
		{
			arr[0]=1;
			arr[1]=1;
			return arr;
		}
		else if(globalBoard[0][0]==globalBoard[1][1]&&globalBoard[0][0]==globalBoard[3][3]&&globalBoard[0][0]==player&&globalBoard[2][2]==32)
		{
			arr[0]=2;
			arr[1]=2;
			return arr;
		}
		else if(globalBoard[0][3]==globalBoard[1][2]&&globalBoard[0][3]==globalBoard[2][1]&&globalBoard[0][3]==player&&globalBoard[3][0]==32)
		{
			arr[0]=3;
			arr[1]=0;
			return arr;
		}
		else if(globalBoard[3][0]==globalBoard[1][2]&&globalBoard[3][0]==globalBoard[2][1]&&globalBoard[3][0]==player&&globalBoard[0][3]==32)
		{
			arr[0]=0;
			arr[1]=3;
			return arr;
		}
		else if(globalBoard[0][3]==globalBoard[3][0]&&globalBoard[0][3]==globalBoard[2][1]&&globalBoard[0][3]==player&&globalBoard[1][2]==32)
		{
			arr[0]=1;
			arr[1]=2;
			return arr;
		}
		else if(globalBoard[0][3]==globalBoard[1][2]&&globalBoard[0][3]==globalBoard[3][0]&&globalBoard[0][3]==player&&globalBoard[2][1]==32)
		{
			arr[0]=2;
			arr[1]=1;
			return arr;
		}
		return arr;
		
		
	}
	public static int[] playerturn(char turn)
	{
		int[] arr = new int[2];
		
		while(true) //loop for inputing coords for placing x/o, checks for errors
		{
			System.out.print("X coordinate: ");
			arr[0] = reader.nextInt();
			System.out.println();
			System.out.print("Y coordinate: ");
			arr[1] = reader.nextInt();
			System.out.println();
			
			if (globalBoard[arr[0]][arr[1]] == 32)
			{
				return arr;
			}
			else if(globalBoard[arr[0]][arr[1]] != 32 || arr[0]>globalBoard.length || arr[1]>globalBoard[arr[0]].length)
				System.out.printf("The place you entered is invalid\n");
			
			
		}
	}

	public static void turn(char turn,char cpu)
	{
		int[] arr = new int[2];
		if (cpu==0)
		{
			System.out.printf("Now its player %c's turn! \nPlease enter where you would like to place your %c: \n",turn, turn);
			arr = playerturn(turn);
		}
		else
		{
			if (cpu==turn)
			{
				System.out.printf("Now its the computer's turn\n");
				arr = cputurn(cpu);
				System.out.printf("The computer places an %c at %d,%d\n",cpu,arr[0],arr[1]);
				
			}
			else
			{
				System.out.printf("Now its the player's turn! \nPlease enter where you would like to place your %c: \n",turn);
				arr = playerturn(turn);
			}
		}
		globalBoard[arr[0]][arr[1]]=turn;
	}
	
	
	public static boolean checkwin()
	{
		boolean game=true;
		for(int i = 0; i < globalBoard.length; i++) //check if a victory occurred
		{
			if(globalBoard[i][0]==globalBoard[i][1]&&globalBoard[i][0]==globalBoard[i][2]&&globalBoard[i][0]==globalBoard[i][3]&&globalBoard[i][0]!=32)
			{
				game=false;
				System.out.printf("Tic Tac Toe on Row %d!\n", i);
			}
			
			if(globalBoard[0][i]==globalBoard[1][i]&&globalBoard[0][i]==globalBoard[2][i]&&globalBoard[0][i]==globalBoard[3][i]&&globalBoard[0][i]!=32)
			{
				game=false;
				System.out.printf("Tic Tac Toe on Column %d!\n", i);
			}
		}
		
		if (globalBoard[0][0]==globalBoard[1][1]&&globalBoard[0][0]==globalBoard[2][2]&&globalBoard[0][0]==globalBoard[3][3]&&globalBoard[0][0]!=32)
		{
			game=false;
			System.out.printf("Tic Tac Toe on diagonal!\n");
		}
		
		if (globalBoard[3][0]==globalBoard[2][1]&&globalBoard[3][0]==globalBoard[1][2]&&globalBoard[3][0]==globalBoard[0][3]&&globalBoard[3][0]!=32)
		{
			game=false;
			System.out.printf("Tic Tac Toe on reverse diagonal!\n");
		}
	
		return game;
	}
	
}