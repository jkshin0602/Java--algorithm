import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2520 {
	
	//반죽 1개의 재료
	public static final double MILK = 0.5; //우유 8컵 
	public static final double YOLK = 0.5; //노른자 8개
	public static final double SUGAR = 0.25; //설탕 4스푼
	public static final double SALT = 0.0625; //소금 1스푼
	public static final double FLOUR = 0.5625; //밀가루 9컵
	
	//토핑
	public static final int BANANA = 1; //바나나 1개 
	public static final int STRAWBERRY_JAM = 30; //딸기잼 30그램
	public static final int CHOCHOLATE = 25; //초콜릿 25그램
	public static final int WALNUT = 10; //호두 10개
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //Test case
		
		for(int i=0; i<N; i++){
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine());

			int c =  (int) (Integer.parseInt(st.nextToken())/MILK); //우유
			int y =  (int) (Integer.parseInt(st.nextToken())/YOLK);   //노른자
			int su = (int) (Integer.parseInt(st.nextToken())/SUGAR); //설탕
			int sa = (int) (Integer.parseInt(st.nextToken())/SALT); //소금
			int f =  (int) (Integer.parseInt(st.nextToken())/FLOUR);
			
			int cake = Math.min(c, Math.min(y, Math.min(su, Math.min(sa, f))));

			st = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(st.nextToken())/BANANA; //바나나 개수
			int sg = Integer.parseInt(st.nextToken())/STRAWBERRY_JAM; //딸기잼 그램
			int cg = Integer.parseInt(st.nextToken())/CHOCHOLATE; //초콜릿 그램
			int w = Integer.parseInt(st.nextToken())/WALNUT; //호두 개수
			
			int sum = b + sg + cg + w;
			
			int result = Math.min(cake, sum);

			System.out.println(result);
			
		}
		

	}


}
