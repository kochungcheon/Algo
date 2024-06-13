

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Long> absHq = new PriorityQueue<>();
		HashMap<Long, Integer> numCounter = new HashMap<>();
		while (N-- > 0) {
			long now = Long.parseLong(br.readLine());
			if (now == 0) {
				if (absHq.isEmpty()) {
					System.out.println(0);
				} else {
					long abs = absHq.poll();
					if (numCounter.getOrDefault(-abs, 0) > 0) {
						numCounter.put(-abs, numCounter.getOrDefault(-abs, 0)-1);
						System.out.println(-abs);
					} else {
						System.out.println(abs);
						numCounter.put(abs, numCounter.getOrDefault(abs, 0)-1);
					}
				}
			} else {
				numCounter.put(now, numCounter.getOrDefault(now, 0) + 1);
				absHq.add(Math.abs(now));
			}
		}
	}
}
