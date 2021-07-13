import java.util.Scanner;


public class Main2675 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		String[] S = new String[T];
		String[] P = new String[T];
		
		for(int i=0; i<T; i++)
			P[i] = "";
		
		Loop1 : for(int i=0; i<T; i++){
			int R = s.nextInt();
			S[i] = s.next();
			for(int j=0; j<S[i].length(); j++){
				if(!isQRCode(S[i].charAt(j)))
					break Loop1;
			}
			for(int j=0; j<S[i].length(); j++){
				for(int k=0; k<R; k++){
					P[i] = P[i]+ S[i].charAt(j);
				}
			}
		}
		
		for(int i=0; i<T; i++){
			System.out.println(P[i]);
		}
		

		
	}

	public static boolean isQRCode(char c){
		return (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9') || (c == '\\')
				||(c== '$') || (c == '%') || (c == '*') || (c== '+') || (c == '-')
				||(c == '.') || (c == '/')|| (c == ':');
	}
}
