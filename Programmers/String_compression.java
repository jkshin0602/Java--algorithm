package programmers;

public class String_compression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		System.out.println(solution("aabbaccc"));
		System.out.println(solution("ababcdcdababcdcd"));
		System.out.println(solution("abcabcdede"));
		System.out.println(solution("abcabcabcabcdededededede"));
		System.out.println(solution("xababcdcdababcdcd"));
		
		
	}
	
	public static int solution(String s) {
		int answer = s.length(); //답안길이를 문자열 길이로 초기화 
	
		for(int i=1; i<=s.length()/2; i++) { // length/2 까지 탐색 
			int level = 1; // 중복갯수 세줌 
			String str = s.substring(0, i); // 압축문자 
			StringBuilder sb = new StringBuilder(); //압축완료 
			
			for(int j=i; j<=s.length(); j+=i) {
				String next;
				
				//다음 문자 추출 
				if(i+j > s.length()) {//i+j가 넘어가면 문자열의 끝이므로, 문자열 끝까지 잘라줌
					next = s.substring(j, s.length());
				}else { // 아니면 i+j부분까지 잘라줌 
					next = s.substring(j, i+j);
				}
				
				if(str.equals(next)) { //만약 다음 문자가 같다면 
					level++; //레벨 증가 
				}else { //같지 않다면 
					if(level !=1) { //레벨이 1이 아니라면 
						sb.append(level); //레벨 추가 
					}
					sb.append(str); //압축 완료 처리 
					str = next; //저장되어 있는 문자를 압축될 문자로 저장 
					level = 1; // 레벨 1로 초기화 
				}
				
			}
			sb.append(str);
			answer = Math.min(answer, sb.length());
			
		}
		
		return answer;
	}
	


}
