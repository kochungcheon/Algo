import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Main {
	static class Problem implements Comparable<Problem>{
		// 문제 번호와 난이도
		int P;
		int L;

		public Problem(int P, int L) {
			this.P = P;
			this.L = L;
		}

		@Override
		public int compareTo(Problem o) {
			if (this.L == o.L) return this.P - o.P;
			return this.L - o.L;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());


		Map<Integer, Integer> pTable = new HashMap<>();
		TreeSet<Problem> set = new TreeSet<>();
		// init
		for (int i=0; i<N; i++) {
			String info = br.readLine();
			String[] tmp = info.split(" ");
			int P = Integer.parseInt(tmp[0]);
			int L = Integer.parseInt(tmp[1]);
			set.add(new Problem(P, L));
			pTable.put(P, L);
		}

		// 사용자 요청 처리
		int M = Integer.parseInt(br.readLine());
		for (int i=0; i<M; i++) {
			String commands = br.readLine();
			String[] tmp = commands.split(" ");
			String command = tmp[0];
			if (command.equals("add")) {
				int P = Integer.parseInt(tmp[1]);
				int L = Integer.parseInt(tmp[2]);
				set.add(new Problem(P, L));
				pTable.put(P, L);
			}

			// 문제 해결 - 지운다
			else if (command.equals("solved")) {
				int P = Integer.parseInt(tmp[1]);
				set.remove(new Problem(P, pTable.get(P)));
				pTable.remove(P);
			}

			// 문제 추천 - +1이면 최대 추천, -1이면 최소 추천
			else if (command.equals("recommend")) {
				int x = Integer.parseInt(tmp[1]);
				if (x == 1) {
					System.out.println(set.last().P);
				}
				else if (x == -1) {
					System.out.println(set.first().P);
				}
			}
		}
	}
}