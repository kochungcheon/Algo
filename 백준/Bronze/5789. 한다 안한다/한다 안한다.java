import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while (n-- >0) {
			String st = sc.next();
			int len = st.length() / 2 - 1;
			StringBuilder ans = new StringBuilder("Do-it");
			if (st.charAt(len) != st.charAt(len+1)) ans.append("-Not");
			System.out.println(ans);
		}
	}
}