// A simple program to demonstrate 
// Tic-Tac-Toe Game. 
import java.util.*; 

public class TicToe { 
	
	static String[] board; 
	static String turn; 
	
	private String checkWinner(String[] board,int n) 
	{
		int j = n * n;
		String Xwon = "X";
		String Owon = "O";
		for(int i=1;i<n;i++) {
			Xwon += "X";
			Owon += "O";			
		}
		for(int i=n;i<=j;i+=n) {
			String line = "";
			for(int k=i-n+1;k<=i;k++) {			
				line += board[k-1];
			}
			if (line.equals(Xwon)) { 
				return "X"; 
			} 
			else if (line.equals(Owon)) { 
				return "O"; 
			} 			
		}
		for(int i=1;i<=n;i++) {
			String line = "";
			for(int h=i;h<=j;h+=n) {
				line += board[h-1];
			}					
			if (line.equals(Xwon)) { 
				return "X"; 
			} 
			else if (line.equals(Owon)) { 
				return "O"; 
			} 			
		}
		String line = "";
		for(int i=1;i<=j;i+=(n+1)) {
			line += board[i-1];		
		}
		if (line.equals(Xwon)) { 
			return "X"; 
		} 
		else if (line.equals(Owon)) { 
			return "O"; 
		}
		line = "";
		for(int i=n;i<j;i+=n-1) {
			line += board[i-1];		
		}
		if (line.equals(Xwon)) { 
			return "X"; 
		} 
		else if (line.equals(Owon)) { 
			return "O"; 
		}
		for (int a = 0; a < j; a++) { 
			if (Arrays.asList(board).contains( 
					String.valueOf(a + 1))) { 
				break; 
			} 
			else if (a == j-1) { 
				return "draw"; 
			} 
		} 

	// To enter the X Or O at the exact place on board. 
		System.out.println( 
			turn + "'s turn; enter a slot number to place "
			+ turn + " in:"); 
		return null; 
	} 
	
	// To print out the board. 
 /* |---|---|---| 
	| 1 | 2 | 3 | 
	|-----------| 
	| 4 | 5 | 6 | 
	|-----------| 
	| 7 | 8 | 9 | 
	|---|---|---|*/
	
	private void printBoard(String[] board,int generateNumber) 
	{ 
/*
		System.out.println("|---|---|---|"); 
		System.out.println("| " + board[0] + " | "
						+ board[1] + " | " + board[2] 
						+ " |"); 
		System.out.println("|-----------|"); 
		System.out.println("| " + board[3] + " | "
						+ board[4] + " | " + board[5] 
						+ " |"); 
		System.out.println("|-----------|"); 
		System.out.println("| " + board[6] + " | "
						+ board[7] + " | " + board[8] 
						+ " |"); 
		System.out.println("|---|---|---|"); 
*/		
		int n = generateNumber;
		int j = n * n;
		int length_this = String.valueOf(j).length();
		/*
		System.out.print(" |");
		for(int i=1;i<=n;i++) {
			System.out.print("---|");		
		}
		System.out.println(" ");
		*/			
		for(int i=n;i<=j;i+=n) {
			System.out.print(" | ");
			for(int k=i-n+1;k<=i;k++) {
				int x = length_this - board[k-1].length();
				String b = "";
				for(int a=0;a<x;a++) {
					b+=" ";
				}
				System.out.print(board[k-1]+b+" | ");				
			}
			System.out.println(" ");
			/*if(i<j) {
				System.out.print(" |");
				for(int k=i-n+1;k<=i;k++) {			
					int x = length_this;
					String b = "";
					for(int a=0;a<x;a++) {
						b+="-";
					}
					System.out.print(b);				
				}				
				System.out.println("| ");							
			}*/
		}
		/*
		System.out.print(" |");
		for(int i=1;i<=n;i++) {
			System.out.print("---|");		
		}		
		System.out.println(" "); 
		*/					
		
	} 

	public static void main(String[] args) 
	{ 
		turn = "X"; 
		String winner = null; 
		System.out.println("Welcome to Tic Tac Toe."); 
		System.out.println("Please input a number to generate board for example: 3, 4. it will be 3x3, 4x4 board : "); 
		Scanner in = new Scanner(System.in); 
		int generateNumber = in.nextInt();
		int j = generateNumber * generateNumber;
		board = new String[j]; 		
		for (int a = 1; a <= j; a++) { 
			board[a-1] = String.valueOf(a);
		} 
		TicToe ticToc = new TicToe();
		ticToc.printBoard(board,generateNumber); 
		System.out.println( 
			"X will play first. Enter a slot number to place X in:"); 
		while (winner == null) { 
			int numInput; 
			try { 
				numInput = in.nextInt(); 
				if (!(numInput > 0 && numInput <= j)) { 
					System.out.println( 
						"Invalid input; re-enter slot number:"); 
					continue; 
				} 
			} 
			catch (InputMismatchException e) { 
				System.out.println( 
					"Invalid input; re-enter slot number:"); 
				continue; 
			} 
			
			// This game has two player x and O. 
			// Here is the logic to decide the turn. 
			if (board[numInput-1].equals( 
					String.valueOf(numInput))) { 
				board[numInput-1] = turn; 

				if (turn.equals("X")) { 
					turn = "O"; 
				} 
				else { 
					turn = "X"; 
				} 

				ticToc.printBoard(board,generateNumber); 
				winner = ticToc.checkWinner(board,generateNumber); 
			} 
			else { 
				System.out.println( 
					"Slot already taken; re-enter slot number:"); 
			} 
		} 
		
		// If no one win or lose from both player x and O. 
		// then here is the logic to print "draw". 
		if (winner.equalsIgnoreCase("draw")) { 
			System.out.println( 
				"It's a draw! Thanks for playing."); 
		} 
		
		// For winner -to display Congratulations! message. 
		else { 
			System.out.println( 
				"Congratulations! " + winner 
				+ "'s have won! Thanks for playing."); 
		} 
	} 
}
