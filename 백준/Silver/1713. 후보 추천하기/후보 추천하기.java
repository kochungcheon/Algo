import java.util.*;
import java.io.*;

public class Main {
	static int N, cnt;
	static int[] arr;
	static List<Frame> frames = new ArrayList<>();

	static class Frame {
		int cnt, idx, value;

		Frame(int idx, int value) {
			this.cnt = 1;
			this.idx = idx;
			this.value = value;
		}

		void vote() {
			cnt++;
		}
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cnt = Integer.parseInt(br.readLine());
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
	}

	public static void main(String[] args) throws IOException {
		input();
		for (int i = 0; i < cnt; i++) {
			frames.sort(Comparator.comparingInt((Frame f) -> f.cnt).thenComparingInt(f -> f.idx));
			boolean found = false;
			for (Frame frame : frames) {
				if (frame.value == arr[i]) {
					frame.vote();
					found = true;
					break;
				}
			}
			if (!found) {
				if (frames.size() == N) frames.remove(0);
				frames.add(new Frame(i, arr[i]));
			}
		}
		frames.sort(Comparator.comparingInt(f -> f.value));
		frames.forEach(f -> System.out.print(f.value + " "));
	}
}