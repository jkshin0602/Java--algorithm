import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2154 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder str = new StringBuilder();
		//String을 쓰면 메모리가 낭비된다.
		// -> str + "aaaa" 이런식으로 추가할 경우 계속 새로운 공간을 할당한다.
		//StringBuilder의 append()를 통해서 메모리 소비를 줄인다.
		for(int i=1; i<=N; i++){
			str.append(i);
		}
		String answer = N+""; 
		for(int i=0; i<str.length(); i++){
			if(str.substring(i,answer.length()+i).equals(answer)){
				//substring으로 str을 잘러 answer의 길이랑 똑같이 만들어 비교한다.
				System.out.println(i+1);
				break;
			}else if(str.length()-answer.length() == 0){
				//str 길이 - answer 길이 == 0이되는경우 찾지못한경우이다.
				//마지막에는 무조건 answer이 있다.
				System.out.println(i+1);
				break;
			}
		}
		br.close();
	}

}
