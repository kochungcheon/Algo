import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.nextLine();
		StringBuilder sb = new StringBuilder();

		for (int i=0; i<n.length(); i++) {
			String bin = Integer.toBinaryString(Integer.parseInt(String.valueOf(n.charAt(i)), 8));
			while(i != 0 && bin.length() < 3) {
				bin = "0" + bin;
			}
			sb.append(bin);
		}

		System.out.println(sb.toString());
	}
}