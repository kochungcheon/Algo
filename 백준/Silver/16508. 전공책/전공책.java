import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static String target;
	static int N;
	static class Book {
		Integer value;
		String name;

		public Book(Integer value, String name) {
			this.value = value;
			this.name = name;
		}
	}
	static List<Book> books = new ArrayList<>();
	static List<Integer> arr = new ArrayList<>();
	static int ans = Integer.MAX_VALUE;
	static void choose(int cur) {
		if (!arr.isEmpty() && check()) {
			return;
		}
		for (int i=cur; i<N; i++) {
			arr.add(i);
			choose(i + 1);
			arr.remove(arr.size() - 1);
		}
	}
	static boolean check() {
		int now = 0;
		StringBuilder sb = new StringBuilder();
		for (Integer idx : arr) {
			sb.append(books.get(idx).name);
			now += books.get(idx).value;
		}
		String str = sb.toString();
		int[] count = new int[256];
		for (char c : str.toCharArray()) {
			count[c]++;
		}

		for (char c : target.toCharArray()) {
			if (--count[c] < 0) return false;
		}

		ans = Math.min(now, ans);
		return true;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		target = br.readLine();
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			books.add(new Book(Integer.parseInt(st.nextToken()), st.nextToken()));
		}
		choose(0);
		if (ans == Integer.MAX_VALUE) {
			ans = -1;
		}
		System.out.println(ans);
	}
}
