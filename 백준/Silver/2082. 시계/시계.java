import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String[] arr = new String[5];
	static final String[] NUM = {
		"####.##.##.####",
		"..#..#..#..#..#",
		"###..#####..###",
		"###..####..####",
		"#.##.####..#..#",
		"####..###..####",
		"####..####.####",
		"###..#..#..#..#",
		"####.#####.####",
		"####.####..####"
	};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 5; i++) {
			arr[i] = br.readLine();
		}

		int[] limit = {2, 9, 5, 9};

		for (int x = 0; x < 4; x++) {
			for (int y = 0; y <= limit[x]; y++) {
				if (isValid(4 * x, y)) {
					System.out.print(y);
					break;
				}
			}
			if (x == 1) System.out.print(':');
		}
	}

	private static boolean isValid(int x, int n) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 3; j++) {
				if (arr[i].charAt(x + j) == '#') {
                    if (NUM[n].charAt(i * 3 + j) == '.') return false;
                }
			}
		}
		return true;
	}
}