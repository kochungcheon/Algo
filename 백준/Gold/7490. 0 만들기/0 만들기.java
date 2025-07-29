import java.io.*;
import java.util.*;

public class Main {
	static int T;
	static int[] arr;
	static List<Integer> list;
	static void recur(int cnt, int N) {
		if (cnt == N-1) {
			cal(N);
			return;
		}
		for (int i=0; i<3; i++) {
			list.add(i);
			recur(cnt+1, N);
			list.remove(list.size()-1);
		}
	}
	private static void cal(int N) {
		int sum = 0;
		int tmp = 1;
		for (int i=2; i<=N; i++) {
			int cmd = list.get(i-2);
			if (cmd == 0) {
				if (tmp > 0) {
					tmp = tmp * 10 + i;
				} else {
					tmp = tmp * 10 - i;
				}
			} else {
				sum += tmp;
				tmp = cmd == 1 ? i : -i;
			}
		}
		sum += tmp;

		StringBuilder sb = new StringBuilder("1");
		if (sum == 0) {
			for (int i=2; i<=N; i++) {
				int cmd = list.get(i-2);
				if (cmd == 0) {
					sb.append(" ");
				} else if (cmd == 1){
					sb.append("+");
				} else {
					sb.append("-");
				}
				sb.append(i);
			}
			System.out.println(sb);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			list = new ArrayList<>();
			recur(0, N);
			System.out.println();
		}
	}
}
