import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		Arrays.sort(A);
		Arrays.sort(B);

		int[] sortArr = new int[N+M];
		int idx = 0;

		int a = 0;
		int b = 0;
		while (idx < N + M) {
			if (a == N) {
				while (b < M) {
					sortArr[idx++] = B[b++];
				}
			} else if (b == M) {
				while (a < N) {
					sortArr[idx++] = A[a++];
				}
			} else if (A[a] == B[b]) {
				sortArr[idx++] = A[a++];
				sortArr[idx++] = B[b++];
			} else if (A[a] < B[b]) {
				sortArr[idx++] = A[a++];
			} else if (A[a] > B[b]) {
				sortArr[idx++] = B[b++];
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int num : sortArr) {
			sb.append(num).append(" ");
		}
		System.out.print(sb);
	}
}