import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int target = Integer.parseInt(br.readLine());
		boolean[] notPrime = new boolean[target+1];

		notPrime[0] = notPrime[1] = true;
		for (int i=2; i * i <= target; i++) {
			if (!notPrime[i]) {
				for (int j= i * i; j <= target; j += i) {
					notPrime[j] = true;
				}
			}
		}

		List<Integer> prime = new ArrayList<>();
		for (int i=2; i<=target; i++) {
			if (!notPrime[i]) prime.add(i);
		}

		int s = 0;
		int e = 0;

		int sum = 0;
		int ans = 0;
		while (e < prime.size()) {
			sum += prime.get(e++);
			if (sum == target) {
				++ans;
			}
			while (target < sum) {
				sum -= prime.get(s++);
				if (sum == target) {
					++ans;
				}
			}
		}
		System.out.print(ans);
	}
}