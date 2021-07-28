package review01;

public class Factorial01 {

	public int FactorialFunc1(int n){ //공간복잡도 1 O(1)
		int fac = 1;
		for(int index=2; index<n+1; index++){
			fac = fac* index;
		}
		return fac;
	}
	
	public int FactorialFunc2(int n){ //재귀함수 , n 입력에 따라 공간이 n개 생김, 공간복잡도 O(n)
		if(n>1){
			return n*FactorialFunc2(n-1);
		}else{
			return 1;
		}
	}
	
	public static void main(String[] args) {
		Factorial01 fObject = new Factorial01();
		System.out.println(fObject.FactorialFunc1(5));
		System.out.println(fObject.FactorialFunc2(5));
	}

}
