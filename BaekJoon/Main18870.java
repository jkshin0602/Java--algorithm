package Cho.week_3;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main18870 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringBuilder sb = new StringBuilder();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++){ //두개 배열에 저장 
			int a = Integer.parseInt(st.nextToken());
			arr[i] = a; 
		}
		int[] tmp = arr.clone();
		Arrays.sort(tmp); //한개 배열을 정렬 
		
		HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
		int idx = 0; // 인덱스 저장
		for(int i : tmp){
			if(!m.containsKey(i)){ //tmp 값이 없다면
				m.put(i, idx++);
			}
		}
		//map : -10, -9, 2, 4 
		//arr : 2 4 -10 4 -9
		for(int i : arr){
			sb.append(m.get(i)).append(' ');
		}
		//m.get(2)의 value idx = 2 (2번째 인덱스) (3번째로 작다)
		//answer : 2 
		//m.get(4)의 value idx = 3 (3번째 인덱스) (4번째로 작다)
		//answer : 2 3 
		// ...
		//m.get(-9) -> idx = 1 
		// answer : 2 3 0 3 1
		bw.write(sb.toString());
		bw.close();
		br.close();
		
		//get(key) -> return value; //키의 값으로 value를 얻어옴
		
		//2단 반복문으로 단순히 할 경우 시간 초과로 실패 
		// -> HashMap을 사용해서 시간초과방지
	}

}
