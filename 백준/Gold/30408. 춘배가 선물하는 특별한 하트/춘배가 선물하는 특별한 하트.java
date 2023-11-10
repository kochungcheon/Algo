import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		long M = sc.nextLong();
		Deque<Long> q = new ArrayDeque<>();
		HashSet<Long> visit = new HashSet<>();
		q.add(N);
		String ans = "NO";
		while (!q.isEmpty()) {
			long now = q.pollFirst();
			if (now == M) {
				ans = "YES";
				break;
			}
			if (now % 2 == 0) {
				long one = now / 2;
				if (!visit.contains(one)) {
					visit.add(one);
					q.add(one);
				}
			} else {
				long one = now / 2;
				long two = now / 2 + 1;
				if (!visit.contains(one)) {
					visit.add(one);
					q.add(one);
				}
				if (!visit.contains(two)) {
					visit.add(two);
					q.add(two);
				}
			}
		}
		System.out.println(ans);
	}
}
