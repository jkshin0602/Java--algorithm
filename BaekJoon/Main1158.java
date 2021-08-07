import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main1158 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Queue<Integer> queue= new LinkedList<Integer>();
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);

		int N = Integer.parseInt(st.nextToken()); // N명 입력
		int K = Integer.parseInt(st.nextToken()); // K번째 입력
		StringBuilder sb = new StringBuilder();
		
		//출력 규칙 맞추기
		sb.append("<");
		
		//사람 큐에 넣기
		for(int i=1; i<=N; i++){
			queue.add(i);
		}
		
		
		for(int i=0; i<N; i++){ // N번 반복하면 N번의 사람을 뺄 수 있다.
			for(int j=0; j<K-1; j++){//K번째 사람을 구하기 위해 반복 
				//1 . pop-push를 k-1번까지 반복
				queue.add(queue.poll()); 
				
			}
			//2. k번째에는 pop만 하여 제거 
			if(i == N-1){ //마지막 순서일때는 
				sb.append(queue.poll()).append(">");
			}else{
				 sb.append(queue.poll()).append(", ");
			}
		}//for문 종료
		
		bw.write(sb.toString());
		bw.close();
		br.close();

	}

}
