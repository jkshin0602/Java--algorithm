import java.util.ArrayList;


public class Recursive {

//	재귀 용법(Recursive call, 재귀 호출)
//	함수 안에서 동일한 함수를 호출하는 형태
//	여러 알고리즘 작성시 사용된다.
	
//	예제 : 팩토리얼을 구하는 알고리즘을 Recursive Call을 활용해서 알고리즘 작성
//	예제 분석 
//	간단한 경우부터 생각해보기
//		2! = 1 x 2
//		3! = 1 x 2 x 3
//		4! = 1 x 2 x 3 x 4 = 4 x 3!
//	규칙을 찾는다 : n! = n x (n-1)!
//		1. 함수를 하나 만든다.
//		2. 함수(n)은 n>1이면 return n X 함수(n-1)
//		3. 함수(n)은 n=1이면 return n
//	검증(코드로 검증하지 않고, 직접 간단한 경우부터 대입해서 검증)
//	1. 2!
//		함수 (2)이면 2>1이므로 2 x 함수(1)
//		함수 (1)은 1이므로 return 2 x 1 = 2  맞음
//	2. 3! 
//	  	함수 (3)이면, 3>1이므로 3x함수(2)
//	  	함수(2)는 결국 1번에 의해 2!이므로, return 2x1 = 2
//	  	3 x 함수(2) = 3x2 = 3x2x1=6 맞음
//	3. 4!
//		함수 (4) 이면 , 4>1이므로 4 X 함수(3)
//		함수(3) 은 결국 2번에 의해 3 x 2 x 1 = 6
//		4 x 함수(3) = 4 x 6 = 24 맞다
	
	
	
	public int FactorialFunc(int n){
			if(n>1){
				return n* this.FactorialFunc(n-1);
			}else{
				return 1;
			}
		}
	
//	시간복잡도와 공간복잡도
//	fatorial(n)은 n-1번의 factorial()함수를 호출해서 곱셈을 한다.
//		일종의 n-1번 반복문을 호출한 것과 동일
//		fatorial()함수를 호출할 때마다 , 지역변수 n 이 생성된다.
//	시간복잡도/공간복잡도는 O(n-1)이므로 결국, 둘다 O(n)
	
//	재귀호출의 일반적인 형태 2
//	function(입력) {
//		if(입력 <= 일정값) {
//			return 특정값
//		}
//		return function(입력-1);
//	}
	public int FactorialFunc2(int n){
		if(n<=1){
			return 1;
		}else{
			return n* this.FactorialFunc2(n-1);
		}
	}
	
//	함수는 내부적으로 스택처럼 관리된다.

//	ArrayList의 subList메서드
//	public List<E> subList(int fromIndex, int toIndex)
//	
//	fromIndex : 서브셋이 시작할 인덱스
//	toIndex : 서브셋의 마지막 인덱스
	
	//예제2
	public int FactorialFunc3(int data){
		if(data==1){
			return 1;
		}else if(data ==2){
			return 2;
		}else if(data ==3){
			return 4;
		}
		return this.FactorialFunc3(data-1)+this.FactorialFunc3(data-2)+this.FactorialFunc3(data-3);
	}
	
	public static void main(String[] args) {
		
		Recursive fObject = new Recursive();
		System.out.println(fObject.FactorialFunc(5));
		System.out.println("서브 리스트 테스트 ");
		ArrayList<Integer> testData = new ArrayList<Integer>();
		for(int data= 0; data<10; data++){
			testData.add(data);
		}
		System.out.println(testData);
		System.out.println(testData.subList(1,testData.size()-1)); 
		System.out.println();
		System.out.println(fObject.FactorialFunc3(10));
		
		
	}

}
