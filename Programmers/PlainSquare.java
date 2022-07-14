package programmers;

import java.math.BigInteger;

public class PlainSquare {

	public static long solution(int w, int h) {
		int gcd = BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).intValue();
		return ((long)w * (long)h) - ((((long)w / gcd) + ((long)h / gcd) - 1) * gcd);
	}

}