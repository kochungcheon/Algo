import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	static Class[] class_lst; // 수업 배열
	static int N, K; // 수업 개수와 학점
	static int ans = 0; 
	static boolean[][] visit = new boolean[5 + 1][10 + 1]; // 방문 체크 배열

	static void choose(int cur, int total) {
		if (total == 0) {
			ans++;
		}
		for (int i=cur; i<N; i++) {
			Class c = class_lst[i];
			int time = c.e - c.s + 1;
			if (c.w == 5) continue;
			if (total - time < 0) continue;
			boolean flag = false;
			for (int h=c.s; h<=c.e; h++) {
				if (visit[c.w][h]) {
					flag = true;
					break;
				}
			}
			if (flag) continue;
			for (int h=c.s; h<=c.e; h++) {
				visit[c.w][h] = true;
			}
			choose(i+1, total-time);
			for (int h=c.s; h<=c.e; h++) {
				visit[c.w][h] = false;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		class_lst = new Class[N];
		for (int i = 0; i < N; i++) {
			class_lst[i] = new Class(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		Arrays.sort(class_lst, Comparator.comparingInt((Class c) -> c.w)
			.thenComparing(c -> c.s));
		choose(0, K);
		System.out.println(ans);
	}


	static class Class {
		int w, s, e;

		public Class(int w, int s, int e) {
			this.w = w;
			this.s = s;
			this.e = e;
		}
	}
}
