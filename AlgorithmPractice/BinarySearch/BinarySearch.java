import java.util.ArrayList;
import java.util.Collections;


public class BinarySearch {

//	이진 탐색(Binary Search)
//	탐색할 자료를 둘로 나누어 해당 데이터가 있을만한 곳을 탐색하는 방법
//	이진 탐색은 데이터가 정렬되어 있는 상태에서 사용이 가능하다.
	
//	분할 정복 알고리즘(Divide and Conquer)
//	Divide : 문제를 하나 또는 둘 이상으로 나눈다.
//	Conquer : 나눠진 문제가 충분히 작고, 해결이 가능하다면 해결하고, 그렇지 않다면 다시 나눈다.
//	
//	이진 탐색 
//	Divide : 리스트를 두 개의 서브리스트로 나눈다.
//	Conquer : 
//		검색할 숫자 (search)> 중간값 이면, 뒷 부분의 서브리스트에서 검색할 숫자를 찾는다.
//		검색할 숫자 (search)< 중간값 이면, 앞 부분의 서브리스트에서 검색할 숫자를 찾는다.
		
//	코드로 만들기
//	이진 탐색은 데이터가 정렬되어있는 상태에서 진행
//	데이터가 {2,3,8,12,20}일 때,
//	searchFunc(data_list, find_data)함수를 만들고
//		searchItem : 찾는 숫자
//		dataList : 데이터 배열
//		dataList의 중간에 위치한 값을 searchItem과 비교해서
//			searchItem < dataList 중간값 이라면
//				맨 앞부터 data_list의 중간까지 에서 다시 searchItem 찾기
//			dataList의 중간값 < searchItem 이라면
//				dataList의 중간부터 맨 끝까지에서 다시 searchItem 찾기
//			그렇지 않다면, data_list의 중간값은 searchItem인 경우로, return dataList 중간에 위치
	 public boolean searchFunc(ArrayList<Integer> dataList, Integer searchItem) {
	        if (dataList.size() == 1 && searchItem == dataList.get(0)) {
	            return true;
	        } 
	        if (dataList.size() == 1 && searchItem != dataList.get(0)) {
	            return false;
	        }
	        if (dataList.size() == 0) {
	            return false;
	        }
	        
	        int medium = dataList.size() / 2; 
	        
	        if (searchItem == dataList.get(medium)) {
	            return true;
	        } else {
	            if (searchItem < dataList.get(medium)) {
	                return this.searchFunc(new ArrayList<Integer>(dataList.subList(0, medium)), searchItem);
	            } else {
	                 return this.searchFunc(new ArrayList<Integer>(dataList.subList(medium, dataList.size())), searchItem);
	            }
	        }
	    }
	
	public static void main(String[] args) {
		BinarySearch bSearch = new BinarySearch();
		ArrayList<Integer> testData = new ArrayList<Integer>();
		
		for(int i=0; i<20; i++){
			testData.add((int)(Math.random()*100));
		}
		Collections.sort(testData);
		System.out.println(testData);
		System.out.println(bSearch.searchFunc(testData, 2));

//		알고리즙 분석
//		n개의 리스트를 매번 2로 나누어 1이 될때까지 비교 연산을 k회 진행
//		n x 1/2 x 1/2 x 1/2 ... = 1
//		n x (1/2)^k =  1
//		n = 2^k=log2n = log2^k
//		log n =k
//		빅 오 표기법으로 k+1이 결국 최종 시간 복잡도임 (1이 되었을 때도 , 비교연산을 한번 수행)
//			결국 O(log2n +1 )이고, 상수는 삭제되므로 O(log n)이다.
		
	}

}
