import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		tri[] tris = new tri[N];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int power = Integer.parseInt(st.nextToken());
			int dex = Integer.parseInt(st.nextToken());
			int intel = Integer.parseInt(st.nextToken());
			tris[i] = new tri(power, dex, intel);
		}

		int minStat = Integer.MAX_VALUE;

		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				for (int h=0; h<N; h++) {
					int winCnt = 0;
					for (int idx=0; idx<N; idx++) {
						if (tris[i].x >= tris[idx].x && tris[j].y >= tris[idx].y && tris[h].z >= tris[idx].z) {
							winCnt++;
						}
					}
					if (winCnt >= K) {
						minStat = Math.min(minStat, tris[i].x + tris[j].y + tris[h].z);
					}
				}
			}
		}

		System.out.print(minStat);
	}

	static class tri {
		int x;
		int y;
		int z;

		public tri(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
}
/*
완탐 1 :
100 명 중 K 명을 뽑아서 최소 스탯 포인트를 찾자

완탐 2 :
힘 * 민첩 * 지능 경우의 수 싹 만들어서
100명 중 K 명 이상 되는 거 중 최소 스탯 포인트 찾자

1000000 * 1000000 * 1000000 * 100

완탐 3 :
모든 힘 민첩 지능 조합으로 경우의 수 싹 만들어서
100명 중 K 명 이상 되는 거 최소 스탯 포인트 찾자

100 * 100 * 100 * 100

*/
