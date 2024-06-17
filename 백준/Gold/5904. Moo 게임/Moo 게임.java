import java.io.*;
public class Main {
	public static char findMoo(int n) {
		int k = 0;
		long len = 3; 
		
		while (len < n) {
			k++;
			len = 2 * len + (k + 3);
		}
		
		while (k > 0) {
			long prevLength = (len - (k + 3)) / 2;
			if (n <= prevLength) {
				len = prevLength;
			} else if (n > prevLength + (k + 3)) {
				n -= (prevLength + (k + 3));
				len = prevLength;
			} else {
				return n == (prevLength + 1) ? 'm' : 'o';
			}
			k--;
		}
		
		return n == 1 ? 'm' : 'o';
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		System.out.println(findMoo(n));
	}
}