package programmers;

import java.util.*;

class Solution01 {
    public int[] solution(int[] lottos, int[] win_nums) {
        //로또의 최고 순위와 최저 순위
    	
        int zerocnt = 0;
        int matched = 0;
       
        for(int i =0; i<6; i++) {
            for(int j =0; j<6; j++) {
                if(lottos[i] == win_nums[j]) matched++;
            }
            if(lottos[i]==0) zerocnt++;
        }
        
        int max= matched+zerocnt;
        int min = matched;
        
        int[] answer = {Math.min(7-max,6), Math.min(7-min,6)};
        return answer;
                
    }
}