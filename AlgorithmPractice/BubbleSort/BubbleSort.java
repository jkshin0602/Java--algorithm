import java.util.ArrayList;
import java.util.Collections;
public class BubbleSort {
//	정렬(sorting) 이란?
//	정렬(sorting) : 어떤 데이터들이 주어졌을 때 이를 정해진 순서대로 나열하는 것
//	정렬은 프로그램 작성시 빈번하게 필요로 한다.
//	다양한 알고리즘이 고안되었으며, 알고리즘 학습의 필수
//		
//		다양한 정렬 알고리즘 이해를 통해, 동일한 문제에 대해 다양한 알고리즘이 고안될 수 있음을 이해하고,
//		각 알고리즘간 성능 비교를 통해, 알고리즘 성능 분석에 대해서도 이해할 수 있다.
//	
//	버블 정렬(bubble sort)란?
//		두 인접한 데이터를 비교해서, 앞에 있는 데이터가 뒤에 있는 데이터보다 크면, 자리를 바꾸는 정렬 알고리즘
		
//	1. for(int index=0; index <dataList.size()-1; index++) 반복
//	2. swap =false(교환이 되었는지를 확인하는 변수를 두기)
//	3. 반복문 안의 반복문으로 n-1번 반복하며
//	4. 반복문안의 반복문 안에서 if(dataList.get(index2) > dataList.get(index2+1)) 이면
//	5. 데이터를 스왑하고, Collections.swap(dataList, index2, index2+1);
//	6. 스왑했음을 체그하기 위해, swap을 true로 놓고,
//	7. 반복문안의 반복문을 수행 후에도 swap이 false이면, 전체 반복을 멈춤(break)
	public ArrayList<Integer> sort(ArrayList<Integer> dataList){
		for(int index= 0; index <dataList.size()-1; index++){
			boolean swap = false; //로직이 돌때마다 swap을 false로 바꿈
			
			for(int index2= 0; index2 <dataList.size()-1-index;index2++){
				//로직이 1번 돌때마다 마지막인덱스는 자기자리로 정렬이 되므로 dataList.size()-1-index<- 값을 뺴주는 것이다
				if(dataList.get(index2) > dataList.get(index2+1)){
					Collections.swap(dataList, index2, index2+1);
					swap =true; //자리를 바꾸면 swap을 true로 바꿈
				}
			}
			if(swap == false){
				break;
			}
		}
		return dataList;
		
	}
	
	
	
	public static void main(String[] args) {
//		연습해보기 1 
//		데이터가 두 개 일때 버블 정렬 알고리즘 방식으로 정렬
		/*ArrayList<Integer> dataList  = new ArrayList<Integer>();
		dataList.add(4);
		dataList.add(2);
		
		if(dataList.get(0) > dataList.get(1)){
			Collections.swap(dataList, 0, 1);
		}
		System.out.println(dataList); // [2, 4]*/
		
//		연습해보기2
//		데이터가 세 개일 때 버블 정렬 알고리즘 방식으로 정렬
		/*ArrayList<Integer> dataList = new ArrayList<Integer>();
		dataList.add(9);
		dataList.add(2);
		dataList.add(4);
		
		for(int index = 0; index<dataList.size()-1;index++){
			if(dataList.get(index)>dataList.get(index+1)){
				Collections.swap(dataList, index, index+1);
			}
		}
		System.out.println(dataList); //[2, 4, 9]*/
		
//		연습해보기 3
//		데이터가 네 개일 때 버블 정렬 알고리즘 방식으로 정렬하는 방법에 대해 생각하고,
//		데이터 갯수에 상관없이 동작하는 버블 정렬 알고리즘 생각해보기
//		
//		데이터가 네 개 일때(데이터 갯수에 따라 복잡도가 떨어지는것은 아니므로, 네 개로 바로 로직을 이해)
//		예 : data_list = [1,9,3,2]
//			1차 로직 적용
//				1과 9 비교, 자리바꿈 없음 [1,9,3,2]
//				9와 3을 비교, 자리바꿈 [1,3,9,2]
//				9와 2를 비교, 자리바꿈 [1,3,2,9]
//			2차 로직 적용
//				1와 3을 비교, 자리바꿈 없음 [1,3,2,9]
//				3와 2를 비교, 자리바꿈 [1,2,3,9]
//				3와 9를 비교, 자리바꿈없음 [1,2,3,9]
//			3차 로직 적용
//				1과 2를 비교, 자리바꿈 없음 [1,2,3,9]
//				2와 3을 비교, 자리바꿈 없음 [1,2,3,9]
//				3과 9를 비교, 자리바꿈 없음 [1,2,3,9]
		
//		특이점 찾기
//		n개의 리스트가 있는 경우 최대 n-1번의 로직을 적용한다.
//		로직을 1번 적용할 때마다, 가장 큰 숫자가 뒤에서부터 1개씩 결정된다.
//		로직이 경우에 따라 일찍 끝날 수 있다. 따라서 로직을 적용할 때 한번도 데이터가 교환된 적이 없다면,
//		이미 정렬된 상태이므로 더 이상 로직을 반복 적용할 필요가 없다.
		
//		랜덤 숫자 생성하기
//		디폴트로 지원하는 Math패키지의 random()메서드를 통해 0이상 1미만의 부동소숫점 값을 가져올 수 있다.
//		Math.random()
//		이를 기반으로, 정수 타입 변환 등을 통해, 다음 코드처럼 랜덤 값을 가져올 수 있다.
		/*for(int i=0; i<10; i++){
			System.out.println((int)(Math.random()*100));
		}*/
		
//		최종 테스트
		ArrayList<Integer> testData = new ArrayList<Integer>();
		for(int i=0; i<10; i++){
			testData.add((int)(Math.random()*100));
		}
		BubbleSort bSort = new BubbleSort();
		bSort.sort(testData);
		System.out.println(testData);
		
//		알고리즘 분석
//		반복문이 두 개 이므로 O(n^2)
//			최악의 경우, n*(n-1) / 2
//		완전 정렬이 되어 있는 상태라면 최선의 시간복잡도는 O(n)
		
		
		
		
		
		

	}

}
