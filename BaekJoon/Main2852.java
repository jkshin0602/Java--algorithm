
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2852 {


	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); //골 들어간 횟수 N 
		
		int[] win = new int[2];
		int team = 0;
		String str;
		
		int score1 = 0;
		int score2 = 0;
		int before = 0;

		for(int i=0; i<N; i++) {
			str = br.readLine();
			team = str.charAt(0) - '0';
			int min = (str.charAt(2) - '0') * 10 + str.charAt(3) - '0';
			int sec = (str.charAt(5) - '0') * 10 + str.charAt(6) - '0';
			int now = 60 * min + sec;
			
			if(score1 > score2) { //1팀이 이기고있으면 
				win[0] += now - before;
			}else if(score1 < score2){ //2팀이 이기고 있으면 
				 win[1] += now - before;
			}
			
			if(team == 1) {
				score1++;
			}else {
				score2++;
			}
			before = now;
		}
		
		if(score1 > score2) {
			win[0] += 48 * 60 - before;
		}else if(score1 < score2) {
			win[1] += 48 * 60 - before;
		}
		
		print(win[0]);
		print(win[1]);
		
	}
	
	public static void print(int t) {
		if (t > 0) {
			int min = t / 60;
			int sec = t % 60;
			if (min >= 0 && min < 10) {
				if (sec >= 0 && sec < 10) {
					System.out.println("0" + min + ":0" + sec);
				} else {
					System.out.println("0" + min + ":" + sec);
				}
			} else {
				if (sec >= 0 && sec < 10) {
					System.out.println(min + ":0" + sec);
				} else {
					System.out.println(min + ":" + sec);
				}
			}
		} else {
			System.out.println("00:00");
		}
	}
	
	
	
	
	
}
