import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MergeSort {
//	병합 정렬(merge sort)
//	재귀용법을 활용한 정렬 알고리즘
//	1. 리스트를 절반으로 잘라 비슷한 크기의 두 부분 리스트로 나눈다.
//	2. 각 부분 리스트를 재귀적으로 합병 정렬을 이용해 정렬한다.
//	3. 두 부분 리스트를 다시 하나의 정렬된 리스트로 합병한다.
//	
//	알고리즘 이해
//	데이터가 네 개일떄 두 단계로 분리해서 이해할 수 있다
//		1단계 : 정렬되지 않은 배열을 끝까지 분리하는 단계
//		2단계 : 분리한 데이터를 단계별로 합치는 단계
//	ex) dataList=[1,9,3,2];
//	먼저 [1,9],[3,2]로 나누고
//	다시 앞 부분은 [1],[9]로 나누고 (1단계)
//	다시 정렬해서 합친다.[1,9] (2단계 시작)
//	다음[3,2]는 [3],[2]로 나누고 
//	다시 정렬해서 합친다[2,3]
//	이제 [1,9]와 [2,3]을 합친다
//		두 배열의 맨 앞에 위치한 데이터부터, 각각 비교하며, 정렬된 합쳐진 배열을 작성한다.
//		1<2 이니 [1]
//		9>2 이니 [1,2]
//		9>3 이니 [1,2,3]
//		9밖에 없으니 [1,2,3,9]
	
//	배열을 자르는 코드 작성
	public void splitFunc(ArrayList<Integer> dataList){
		if(dataList.size() <=1){
			return;
		}
		int medium = dataList.size()/2;
		
		ArrayList<Integer> leftArr =new ArrayList<Integer>();
		ArrayList<Integer> rightArr =new ArrayList<Integer>();
		
		// 0 부터 medium - 1 인덱스 번호까지 해당 배열 아이템을 서브 배열로 추출
		leftArr = new ArrayList<Integer>(dataList.subList(0, medium));
		rightArr = new ArrayList<Integer>(dataList.subList(medium, dataList.size()));
		
		System.out.println(leftArr);
		System.out.println(rightArr);
	}
	
//	재귀용법 틀 만들기
//	만약 배열 갯수가 한개이면 해당 값 리턴
//	그렇지 않으면 , 배열을 앞뒤, 두 개로 나누기
//	leftArr =mergeSplitFunc(앞)
//	rightArr =mergeSplitFunc(뒤)
//	return mergeFunc(left, rightArr)라는 합치는 메서드 호출하여 리턴
//			mergerFunc()메서드가 leftArr과 rightArr을 합쳐서 정렬한 배열을 리턴한다고
//			가정한다면,
//			leftArr 과 rightArr은 이미 정렬된 배열임을 알 수 있다.
	public ArrayList<Integer> mergeSplitFunc(ArrayList<Integer> dataList){
		if(dataList.size() <= 1){
			return dataList;
		}
		int medium = dataList.size()/2;
		
		ArrayList<Integer> leftArr = new ArrayList<Integer>();
		ArrayList<Integer> rightArr = new ArrayList<Integer>();
		    
		leftArr = this.mergeSplitFunc(new ArrayList<Integer>(dataList.subList(0, medium)));
		rightArr = this.mergeSplitFunc(new ArrayList<Integer>(dataList.subList(medium, dataList.size())));
		
		return this.mergeFunc(leftArr, rightArr);
	}
	
//	mergeFunc메서드 만들기
//	목표 : leftList와 rightList의 배열 데이터를 정렬하며 합쳐서, mergedList라는 이름으로 return
//		leftList와 rightList는 이미 정렬된 상태 또는 데이터가 하나임
//	
//	ArrayList만들기
//	leftPoint,rightPoint = 0
//	Case1 : leftLst, rightList 둘다 있을 떄
//		while(leftList.size() > leftPoint && rightList.size()>rightPoint)
//			만약 leftPoint나 rightPoint가 이미 leftList또는 rightList배열을 다 순회했다면,
//			그 반대쪽 데이터를 그대로 넣고, 해당 인덱스 증가
//			if(leftList.get(leftPoint) > rightList.get(rightPoint))
//				mergedList.add(rightList.get(rightPoint));
//				rightPoint+=1;
//			else
//				mergedList.add(leftList.get(leftPoint));
//				leftPoint +=1;
//	Case2 : RightList만 없을때, 나머지 LeftList에 있는 데이터를 그대로 mergedList뒤에 넣음
//	Case2 : LeftList만 없을때, 나머지 RightList에 있는 데이터를 그대로 mergedList뒤에 넣음
	public ArrayList<Integer> mergeFunc(ArrayList<Integer> leftList, ArrayList<Integer> rightList){
		ArrayList<Integer> mergedList = new ArrayList<Integer>();
		int leftPoint = 0;
		int rightPoint = 0;
		
		//Case1 : left/right 둘 다 있을 떄
		while(leftList.size()>leftPoint && rightList.size()>rightPoint){
			if(leftList.get(leftPoint)>rightList.get(rightPoint)){
				mergedList.add(rightList.get(rightPoint));
				rightPoint +=1;
			}else{
				mergedList.add(leftList.get(leftPoint));
				leftPoint +=1;
			}
		}
		
		//Case2 : right 데이터가 없을 때 (left 데이터가 남아 있을 때) 
		while(leftList.size() > leftPoint){
			mergedList.add(leftList.get(leftPoint));
			leftPoint +=1;
		}
		
		//Case 3 : left데이터가 없을 때 (right 데이터가 남아 있을 때)
		while(rightList.size() > rightPoint){
			mergedList.add(rightList.get(rightPoint));
			rightPoint +=1;
		}
		return mergedList;
	}
	
				
	public static void main(String[] args) {
		MergeSort sObject = new MergeSort();
	//	sObject.splitFunc(new ArrayList<Integer>(Arrays.asList(4,1,2,3,5,7)));
		ArrayList<Integer> testData = new ArrayList<Integer>();
		for(int index=0; index<20;index++){
			testData.add((int)(Math.random()*100));
		}
		MergeSort mSort = new MergeSort();
		System.out.println(mSort.mergeSplitFunc(testData));
		
//		알고리즘 분석
//		깊이를 depth라고 하고 i로 놓으면 
//		각 단계에 있는 노드 안의 배열의 길이는 n/2^i가 된다.
//		각 단계에는 2^i의 노드가 있다.
//		각 단계에서 노드 안의 배열 데이터는 한번씩 체크되므로 각각 O(n)시간복잡도를 가진다.
//		깊이는 항상 log2 n개만큼 만들어진다, 시간복잡도는 결국 O(log n)이다.
//		따라서 단계별 시간복잡도는 O(n) * O(log n) = O(n log n)이다.
	
	}

}
