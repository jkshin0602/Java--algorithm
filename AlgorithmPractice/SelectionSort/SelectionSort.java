import java.util.ArrayList;
import java.util.Collections;
public class SelectionSort {

//	선택 정렬(Selection sort)
//	선택정렬 이란 ?
//		다음과 같은 순서를 반복하며 정렬하는 알고리즘
//		1. 주어진 데이터 중, 최소값을 찾음
//		2. 해당 최소값을 데이터 맨 앞에 위치한 값과 교체함
//		3. 맨 앞의 위치를 뺀 나머지 데이터를 동일한 방법으로 반복함
		
//	데이터가 두 개일때
//	dataList =[9,1]
//		dataList[0] > dataList[1] 이므로 dataList[0]값과 dataList[1] 값을 교환
//	데이터가 세 개일때
//	dataList=[9,1,7]
//		처음 한번 실행하면 1,9,7이 됨
//		두번째 실행하면 1,7,9가됨
//	데이터가 네 개일때
//	dataList=[9,3,2,1]
//		처음 한번 실행하면 1,3,2,9가 됨
//		두 번째 실행하면  1,2,3,9가 됨
//		세 번째 실행하면, 변화 없음
	
//	1. for(int stand= 0; stand < dataList.size()-1; stand++)로 반복
//	2. lowest = stand로 놓고
//	3. for(int index = stand+1; index <dataList.size();index++)로 stand이후부터 반복
//		내부 반복문 안에서 dataList[lowest] > dataList[index]이면 
//			lowest =num;
//	4. dataList[lowest]와 dataList[index] 스왑
	public ArrayList<Integer> sort(ArrayList<Integer> dataList){
		int lowest;
		for(int stand=0; stand<dataList.size()-1; stand++){
			lowest =stand;
			for(int index=stand+1; index<dataList.size();index++){  //가장 작은 값을 찾기 위한 반복문
				if(dataList.get(lowest) > dataList.get(index)){  
					lowest = index;
				}
			}
			Collections.swap(dataList, lowest, stand);
		}
		return dataList;
	}
	
		
	public static void main(String[] args) {
		
		//테스트
		ArrayList<Integer> testData = new ArrayList<Integer>();
		for(int i=0; i<10; i++){
			testData.add((int)(Math.random()*100));
		}
		SelectionSort sSort = new SelectionSort();
		sSort.sort(testData);
		System.out.println(testData);
		
		//시간복잡도
//		반복문이 두 개이므로 O(n^2)
//			상세히 계산시 : n*(n-1) / 2
		

	}

}
