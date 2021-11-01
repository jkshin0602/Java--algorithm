package CodeTest;

public class Greedy0301 {

	public static void main(String[] args) {
		int N = 1260;
		int cnt = 0;
		
		// 큰 단위의 화폐부터 차례대로 확인
		int coinType[] = {500, 100, 50, 10};
		
		for(int i=0; i<coinType.length; i++){
			int coin = coinType[i];
			cnt += N / coin;
			N %= coin;
		}
		
		System.out.println(cnt);
		
	}

}
