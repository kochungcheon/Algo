import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		String[] grid = new String[N];
		int y = 0;
		for (int i=0; i<N; i++) {
			grid[i] = br.readLine();
			if (!grid[i].contains("X")) {
				y++;
			}
		}

		int x = 0;
		for (int i=0; i<M; i++) {
			boolean flag = true;
			for (int j=0; j<N; j++) {
				if (grid[j].charAt(i) == 'X') {
					flag = false;
					break;
				}
			}
			if (flag) {
				x++;
			}
		}
		System.out.print(Math.max(x, y));
	}
}
