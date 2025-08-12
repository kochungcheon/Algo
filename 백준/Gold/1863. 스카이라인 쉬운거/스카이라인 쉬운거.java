import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Deque<Integer> stack = new ArrayDeque<>();
		long ans = 0;

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			while (!stack.isEmpty() && stack.peek() > y) {
				if (stack.peek() > 0) ans++;
				stack.pop();
			}

			if (stack.isEmpty() || stack.peek() < y) {
				stack.push(y);
			}
		}

		while (!stack.isEmpty()) {
			if (stack.peek() > 0) ans++;
			stack.pop();
		}

		System.out.print(ans);
	}
}