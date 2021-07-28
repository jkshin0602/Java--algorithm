package review01;

import java.util.ArrayList;
import java.util.Collections;

public class BubbleSort01 {

	public ArrayList<Integer> Sort(ArrayList<Integer> dataList){
		for(int index=0; index <dataList.size()-1; index++){
			boolean swap = false;
			
			for(int index2 =0; index2 < dataList.size()-1-index;index2++){
				if(dataList.get(index2) > dataList.get(index2+1)){
					Collections.swap(dataList, index2, index2+1);
					swap= true;
				}
			}
			
			if(swap == false){
				break;
			}
		}
		return dataList;
	}
	
	public static void main(String[] args) {
		BubbleSort01 bSort = new BubbleSort01();
		ArrayList<Integer> testData = new  ArrayList<Integer>();
		for(int i=0; i<20; i++){
			testData.add((int)(Math.random()*100));
		}
		System.out.println(bSort.Sort(testData));
		
	}
	//시간복잡도
	//반복문이 두개 이므로 O(N^2)
	//최악의 경우 n*(n-1)/2 
	//최선은 O(n)

}
