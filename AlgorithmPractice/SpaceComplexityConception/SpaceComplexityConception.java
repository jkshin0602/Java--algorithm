
public class SpaceComplexityConception {

//	공간 복잡도 
//	알고리즘 계산 복잡도는 다음 두 가지 척도로 표현될 수 있다
//		시간 복잡도 : 얼마나 빠르게 실행되는지
//		공간 복잡도 : 얼마나 많은 저장 공간이 필요한지
//		
//		좋은 알고리즘은 실행 시간도 짧고, 저장 공간도 적게 쓰는 알고리즘
//	
//	통상 둘 다 만족시키기는 어렵다
//		시간과 공간은 반비례적 경향이 있다
//		최근 대용량 시스템이 보편화되면서, 공간 복잡도 보다는 시간 복잡도가 우선
//		그래서 알고리즘은 시간 복잡도가 중심이다.
	
//	공간 복잡도 대략적인 계싼은 필요하다
//	기존 알고리즘 문제는 예전에 공간 복잡도도 고려되어야 할 때 만들어진 경우가 많음
//	그래서 기존 알고리즘 문제에 시간 복잡도뿐만 아니라, 공간 복잡도 제약 사항이 있는 경우가 있음
//	또한, 기존 알고리즘 문제에 영향을 받아서, 면접시에도 공간 복잡도를 묻는 경우가 있다.
	
//	공간 복잡도(Sapce Complexity)
//	프로그램을 실행 및 완료하는데 필요한 저장공간의 양을 뜻함
//	총 필요 저장 공간
//		고정 공간(알고리즘과 무관한 공간) : 코드 저장 공간 ,단순 변수 및 상수
//		가변 공간(알고리즘 실행과 관련있는 공간) : 실행 중 동적으로 필요한 공간
//		S(P) = c + S_p(n)
//		c: 고정공간
//		S_p(n) : 가변공간
//	빅 오 표기법을 생각해 볼떄, 고정공간은 상수이므로 공간 복잡도는 가변 공간에 좌우된다.
	
//	공간 복잡도 계산
//	공간복잡도 계산은 알고리즘에서 실제 사용되는 저장 공간을 계산하면 된다.
//	이를 빅 오 표기법으로 표현할 수 있으면 된다.

//	공간 복잡도 예제1
//	n! 팩토리얼 구하기
//	n의 값에 상관없이 변수n , 변수 fac, 변수 index만 필요함
	public int factorialFunc(int n){ //n이 몇개든 간에 상수공간만 사용하였으므로 공간복잡도는 O(1)
		int fac = 1;
		for(int index =2; index <n+1; index++){
			fac = fac*index;
		}
		return fac;
	}
	
//	공간 복잡도 예제2
//	n! 팩토리얼 구하기
//	재귀 함수를 사용하였으므로, n에 따라 변수 n이 n개 만들어지게 된다
//		fatorial함수를 재귀함수로 1까지 호출하였을 경우, n부터 1까지 스택에 쌓이게 된다.
//	공간 복잡도는  O(n)
	public int factorialFunc2(int n){
		if(n >1 ){
			return n*factorialFunc2(n-1); //n이 지역변수로 쓰이면서 계속 쌓인다
		}else{
			return 1;
		}
	}
	
	public static void main(String[] args) {
		SpaceComplexityConception fOject = new SpaceComplexityConception();
		System.out.println(fOject.factorialFunc(5)); //120
		System.out.println("##########################");
		System.out.println(fOject.factorialFunc2(5));

	}

}
