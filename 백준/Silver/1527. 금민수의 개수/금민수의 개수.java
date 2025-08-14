
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());

		long ans = 0;
		Deque<Long> queue = new ArrayDeque<>();
		queue.add(4L);
		queue.add(7L);

		while (!queue.isEmpty()) {
			long now = queue.poll();
			if (now > B) continue;       
			if (now >= A) ans++;     

			long tmp = now * 10 + 4;
			if (tmp <= B) queue.add(tmp);
			tmp = now * 10 + 7;
			if (tmp <= B) queue.add(tmp);
		}

		System.out.println(ans);
	}
}