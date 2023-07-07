package book.nadongbin.문제.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 병사_배치하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> powers = new ArrayList<>();
		int[] D = new int[2001];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			powers.add(Integer.parseInt(st.nextToken()));
			D[i] = 1;
		}

		//수열을 뒤집어 가장 긴 감소하는 부분 수열로 변경
		Collections.reverse(powers);

		//N명의 병사난 특정한 전투력을 보유
		//병사를 배치할 때는 전투력이 높은 병사가 앞쪽에 오도록 내림차순 배치
		//앞쪽에 있는 병사의 전투력이 항상 뒤에 있는 병사 보다 높아야 한다.
		//배치 과정에서 특정한 위치에 있는 병사를 열외시키는 방법 이용
		//남아 있는 병사의 수가 최대
		//D[i] = array[i]를 마지막 원솔 가지는 부분 수열의 최대 길이
		//LTS(가장 긴 증가하는 부분 수열) 방식
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (powers.get(j) < powers.get(i)) {
					D[i] = Math.max(D[i], D[j] + 1);
				}
			}
		}

		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(D[i], max);
		}

		System.out.println(N - max);

	}
}
