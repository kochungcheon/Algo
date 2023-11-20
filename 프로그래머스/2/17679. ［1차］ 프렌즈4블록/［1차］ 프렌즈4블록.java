import java.util.*;
class Solution {
		static boolean canGo(int x, int y, int m, int n) {
			return 0 <= x && x < m && 0 <= y && y < n;
		}
		static char isBlock = 'a';
		public int solution(int m, int n, String[] board) {
			char[][] grid = new char[m][n];
			for (int i=0; i<m;i++) {
				for (int j=0; j<n; j++) {
					grid[i][j] = board[i].charAt(j);
				}
			}
            int aaaa = 0;
			int answer = 0;
			boolean flag = true;
			// 원점, 오, 대각, 왼
			int[] dx = {0, 0, 1, 1};
			int[] dy = {0, 1, 0, 1};

			while (flag) {
				flag = false;
				boolean[][] visit = new boolean[m][n];
				for (int i=0; i<m; i++) {
					for (int j=0; j<n; j++) {
						char A = grid[i][j];
						int cnt = 0;
						for (int h=0; h<4; h++) {
                            int nx = i+dx[h];
                            int ny = j+dy[h];
							if (canGo(nx, ny, m, n)) {
								if (grid[nx][ny] == isBlock) {
									break;
								}
								if (A == grid[nx][ny]) {
									cnt++;
								} else {
									break;
								}
							}
						}

						if (cnt == 4) {
                            System.out.println(aaaa++);
							for (int k = 0; k<4; k++) {
								int nx = i + dx[k];
								int ny = j + dy[k];
								visit[nx][ny] = true;

								// 하나라도 지워질게 있으면 다음 회차도 진행
								flag = true;
							}
						}
					}
				}

				for (int i=0; i<m; i++) {
					for (int j=0; j<n; j++) {
						if (visit[i][j]) {
                            // System.out.println(i + " " + j);
							answer++;
                            if (i == 0) {
                                grid[i][j] = isBlock;
                                continue;
                            }
							int k = i;
							while(k >= 1) {
								grid[k][j] = grid[k-1][j];
								k--;
							}
							grid[0][j] = isBlock;
						}
					}
				}
			}
			return answer;
		}
	}