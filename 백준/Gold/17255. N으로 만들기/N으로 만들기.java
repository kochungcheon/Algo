import java.util.*;

public class Main {
	static char[] target;
	static Set<String> set;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		target = scanner.next().toCharArray();
		set = new HashSet<>();

		for (int i=0; i<target.length; i++) {
			choose(i, i, "" + target[i], "" + target[i]);
		}
		System.out.print(set.size());
	}

	private static void choose(int L, int R, String s, String path) {
		if (L==0&&R==target.length-1) {
			set.add(path);
			return;
		}
		if (L - 1 >= 0) {
			choose(L-1, R, target[L-1]+s, path+" "+target[L-1]+s);
		}
		if (R + 1 < target.length) {
			choose(L, R+1, s+target[R+1], path+" "+s+target[R+1]);
		}
	}
}