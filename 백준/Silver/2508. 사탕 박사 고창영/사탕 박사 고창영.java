import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			br.readLine();
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			String[] grid = new  String[r];
			for ( int i=0; i<r; i++ ) {
				grid[i] = br.readLine();
			}
			int cnt = 0;

			for (int i = 0; i < r; i++) {
				for (int j = 0; j + 2 < c; j++) {
					if (grid[i].charAt(j) == '>' &&
						grid[i].charAt(j + 1) == 'o' &&
						grid[i].charAt(j + 2) == '<') {
						cnt++;
					}
				}
			}

			for (int i = 0; i + 2 < r; i++) {
				for (int j = 0; j < c; j++) {
					if (grid[i].charAt(j) == 'v' &&
						grid[i + 1].charAt(j) == 'o' &&
						grid[i + 2].charAt(j) == '^') {
						cnt++;
					}
				}
			}

			System.out.println(cnt);


		}
	}
}
