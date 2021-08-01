package review01;

import java.util.ArrayList;
import java.util.Collections;

import javax.sound.sampled.DataLine;

public class InsertSort01 {

	public static ArrayList<Integer> Sort(ArrayList<Integer> dataList){
		for(int index=0; index < dataList.size()-1; index++){
			for(int index2 = index+1; index2>0; index2--){
				if(dataList.get(index2) < dataList.get(index2-1)){
					Collections.swap(dataList, index2, index2-1);
				}
				else{
					break;
				}
			}
		}
		return dataList;
	}
	
	//삽입정렬은 두 번째 인덱스부터 시작
	public static void main(String[] args) {
		
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for(int i=0; i<20; i++){
			testList.add((int)(Math.random()*100));
		}
		System.out.println(testList);
		Sort(testList);
		System.out.println(testList);

	}
	
	//시간복잡도
	//O(N^2)
	// n*(n-1)/2
	//최선의 경우  O(n) : 완전 정렬이 되어있는 상태

}
