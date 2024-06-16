

import java.util.Scanner;

public class Main {
	private static final int tf = 24 * 60 * 60;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] pre = sc.next().split(":");
		Integer pTime = Integer.parseInt(pre[0]) * 60 * 60 + Integer.parseInt(pre[1]) * 60 + Integer.parseInt(pre[2]);
		String[] next = sc.next().split(":");
		Integer nTime = Integer.parseInt(next[0]) * 60 * 60 + Integer.parseInt(next[1]) * 60 + Integer.parseInt(next[2]);
		Integer now = nTime - pTime;
		if (now <= 0) {
			now += tf;
		}
		String ans = "";
		String hour = String.valueOf(now / 3600);
		if (hour.length() < 2) {
			ans += "0";
		}
		ans += hour;
		ans += ":";
		now %= 3600;
		String min = String.valueOf(now / 60);
		if (min.length() < 2) {
			ans += "0";
		}
		ans += now / 60;
		ans += ":";
		now %= 60;
		if (now < 10) {
			ans += "0";
		}
		ans += now;
		System.out.print(ans);
	}
}
