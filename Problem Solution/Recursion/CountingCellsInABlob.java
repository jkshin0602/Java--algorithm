package CodeTest;

public class CountingCellsInABlob {
	
	private static int BACKGROUND_COLOR = 0;
	private static int IMAGE_COLOR = 1;
	private static int ALREADY_COUNTED = 2;
	
	private static int N = 8;
	private static int[][] grid = {
		{1,0,0,0,0,0,0,1},
		{0,1,1,0,0,1,0,0},
		{0,1,0,0,1,0,1,0},
		{0,0,0,0,0,1,0,0},
		{0,1,0,1,0,1,0,0},
		{0,1,0,1,0,1,0,0},
		{1,0,0,0,1,0,0,1},
		{0,1,1,0,0,1,1,1},
	};
	
	
	public static int countCells(int x, int y){
		if(x<0 || x>=N || y<0 || y>=N)
			return 0;
		else if(grid[x][y] != IMAGE_COLOR)
			return 0;
		else {
			grid[x][y] = ALREADY_COUNTED;
			return 1 + countCells(x-1, y+1) + countCells(x, y+1)
					 + countCells(x+1, y+1) + countCells(x-1, y) 
					 + countCells(x+1, y) + countCells(x-1, y-1)
					 + countCells(x, y-1) + countCells(x+1, y-1);  
		}
	}
	
	public static void printCell(){
		
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		printCell();
		System.out.println();
		System.out.println("좌표에 속한 Blob의 크기 :  "+countCells(5, 3));
		System.out.println();
		printCell();

	}

}
