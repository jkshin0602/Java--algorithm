import java.util.ArrayList;
import java.util.Collections;
public class InsertionSort {

//	삽입 정렬(Insertion sort)란?
//	삽입 정렬은 두번째 인덱스부터 시작
//	해당 인덱스 (key값) 앞에 있는 데이터(B)부터 비교해서 key값이 더 작으면, B값을 뒤 인덱스로 복사
//	이를 key값이 더 큰데이터를 만날 때 까지 반복, 그리고 큰데이터를 만난위치 바로 뒤에 key값을 이동
//	
//	연습
//	데이터가 네 개 일때
//	예 : dataList=[9,3,2,5]
//		처음 한번 실행하면, key값은 9, 인덱스(0)-1은 0보다 작으므로 끝 :[9,3,2,5]
//		두 번째 실행하면, key값은 3, 9보다 3이 작으므로 자리 바꾸고 끝 : [3,9,2,5]
//		세 번째 실행하면, key값은 2, 9보다 2가 작으므로 자리 바꾸고, 다시 3보다 2가 작으므로 끝 : [2,3,9,5]	
//		네 번째 실행하면, key값은 5, 9보다 5가 작으므로 자리 바꾸고, 3보다는 5가 크므로 끝 : [2,3,5,9]
//	
//	알고리즘 구현
//	1. for(int index =0; index <dataList.size()-1; index++)로 반복
//	2. 반복문 안에서 for(int index2 = index+1; index2>0 ; index2--)으로 반복
//		내부 반복문 안에서 if(dataList.get(index2) < dataList.get(index2-1))이면 스왑
	public ArrayList<Integer> sort (ArrayList<Integer> dataList){
		for(int index=0; index <dataList.size()-1; index++){
			for(int index2= index+1; index2>0; index2--){
				if(dataList.get(index2) < dataList.get(index2-1)){
					Collections.swap(dataList, index2, index2-1);
				}else{
					break;
				}
			}
		}
		return dataList;
	}
		
	public static void main(String[] args) {
		ArrayList<Integer> testData = new ArrayList<Integer>();

		for (int index = 0; index < 10; index++) {
		    testData.add((int)(Math.random() * 100));
		}

		InsertionSort iSort = new InsertionSort();
		System.out.println(iSort.sort(testData));
		
		//시간 복잡도
//		반복문이 두 개 O(n^2)
//		최악의 경우 , n*(n-1)/2
//		완전 정렬이 되어 있는 상태라면 최선은 O(n)
	}

}
