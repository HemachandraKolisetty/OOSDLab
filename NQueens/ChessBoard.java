package nqueens;

import java.util.*;

public class ChessBoard
{
	private int[][] board;
	private ArrayList<int[][]> allBoards = new ArrayList<>();
	private int size;

	// Constructor
	public ChessBoard(int size){
		board=new int[size][size];
		this.size=size;
	}
        
        public ArrayList<int[][]> getAllBoards(){
            return allBoards;
        }

	void printBoard(int[][] board1){
		for(int i=0; i<size; i++)
		{
			for(int j=0;j<size;j++)
				System.out.print(board1[i][j]+" ");
			System.out.print("\n");
		}

	}

	boolean onAttack(int[][] board1,int row, int col){
		for (int i=0; i<col; i++)
			if (board1[row][i]==1){
				return true;
			}
		for (int i=row-1, j=col-1; i>=0 && j>=0; i--, j--)
			if (board1[i][j]==1){
				return true;
			}
		for (int i=row+1, j=col-1;i<size && j>=0; i++, j--){
			if (board1[i][j]==1){

				return true;
			}
		}
		return false;

	}

	void placeQueen(int[][] board1, int column){
		for (int i=column; i<size; i++)
		{
			for (int j=0; j<size; j++)
			{
				board1[j][i]=1;
				if (!(this.onAttack(board1, j, i)))
				{
					this.placeQueen(board1, column+1);
				}
				board1[j][i]=0;

			}
			return;
		}
		this.printBoard(board1);
                int[][] b = new int[size][size];
                for(int i=0;i<size;i++)
                    for(int j=0;j<size;j++)
                        b[i][j]=board1[i][j];
		allBoards.add(b);
		System.out.println("\n");
	}

	public void solveNQ()
        {
		placeQueen(board, 0);
	}
}