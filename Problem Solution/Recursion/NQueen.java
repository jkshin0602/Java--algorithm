package Algorithm2;

public class NQueen {
	
	public static int N = 4;
	public static int[] cols = new int[N+1]; //정답을 저장
	
	public static boolean queens(int level){
		if(!promising(level)) //같은열 , 대각선 검사
			return false;
		else if(level == N) { //최대 크기인 N에 위치한다면 검사는 종료 
			print();
			return true;
		}
		for(int i=1; i<=N; i++){
			cols[level+1] = i;
			if(queens(level+1)) //자식 노드 검사
				return true;
		}
		return false;
	}
	
	public static boolean promising(int level){
		for(int i=1; i<level; i++){
			if(cols[i] == cols[level] || level-i == Math.abs(cols[level]-cols[i])){
				return false; //같은열 || 대각선 검사
				//행의 차와 열의 차가 같으면 대각선에 위치
			}
		}
		return true;
	}
	
	public static void print(){
		for(int i=1; i<=N; i++){
			System.out.print(cols[i] + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		queens(0);

	}

}
