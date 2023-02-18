package programmers;

import java.util.Arrays;

public class 파일명정렬 {

	//파일명에 숫자가 포함된 숫자를 반영한 정렬 기능 구현
	//파일명은 100글자 이내
	//대소문자, 숫자, 공백, 마침표, 빼기 만으로 이루어져 있다.
	//파일명은 영문자로 시작하며, 숫자를 하나 이상 포함하고 있다.
	//파일명은 크게 Head, Number, Tail 로 구성
	//Head는 숫자가 아닌 문자로 이루어져있으며, 최소한 한글자 이상
	//Number은 한 글자에서 최대 5글자의 연속된 숫자로 이루어져있으며 앞쪽에 0이 올 수 있다.
	//Tail은 나머지 부분으로, 숫자가 다시 나타날 수 있으며, 아무글자가 없을 수도 있다.

	//1. 파일명은 Head 기준으로 사전 정렬
	//이때 문자열 비교시 대소문자 구분하지 않음
	//2. Number의 숫자 순으로 정렬
	//숫자 앞에 0은 무시된다.
	//3. 숫자가 같을 경우 원래 입력에 주어진 순서를 유지

	public static String[] solution(String[] files) {
		Arrays.sort(files, (o1, o2) -> {
			//1.
			String[] part1 = modPart(o1);
			String[] part2 = modPart(o2);

			int headComparing = part1[0].compareTo(part2[0]);
			int numberComparing = Integer.parseInt(part1[1]) - Integer.parseInt(part2[1]);

			if (headComparing == 0) {
				if (numberComparing == 0) {
					return 0;
				}
				return numberComparing;
			}
			return headComparing;
		});

		return files;
	}

	/**
	 * head, number, tail을 나눔
	 *
	 * @param s 나눌 문자열
	 * @return String[0] = Head
	 * String[1] = Number
	 * String[2] = Tail
	 */
	private static String[] modPart(String s) {
		String[] part = new String[3];
		boolean state = false;
		int numberStartIdx = -1;

		for (int i = 0; i < s.length(); i++) {
			if (!state && isNumber(s.charAt(i))) {
				part[0] = s.substring(0, i).toLowerCase();
				numberStartIdx = i;
				state = true;
				if (i == s.length() - 1) {
					part[1] = s.substring(numberStartIdx);
				}
			} else if (state && !isNumber(s.charAt(i))) {
				String number = s.substring(numberStartIdx, i);
				if (number.length() > 5) {
					i = i - (number.length() - 5);
				}
				part[1] = s.substring(numberStartIdx, i);
				part[2] = s.substring(i);
				break;
			}
		}
		if (part[1] == null) {
			int i = s.length();
			String number = s.substring(numberStartIdx, i);
			if (number.length() > 5) {
				i = i - (number.length() - 5);
			}
			part[1] = s.substring(numberStartIdx, i);
			part[2] = s.substring(i);
		}

		return part;
	}

	private static boolean isNumber(char c) {
		return c >= '0' && c <= '9';
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(
			solution(new String[] {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"})));
		System.out.println(Arrays.toString(
			solution(
				new String[] {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"})));

		System.out.println(Arrays.toString(modPart("O00321")));
		System.out.println(Arrays.toString(modPart("O49qcGPHuRLR5FEfoO00321")));

	}
}
