

import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = 9;
		int[] arr = new int[num];
		int total = 0;
		for (int i=0; i<num; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			total += arr[i];
		}

		Arrays.sort(arr);



		boolean flag = false;

		for (int i=0; i<num-1; i++) {
			if (flag) {
				break;
			}
			for (int j=i+1; j<num; j++) {
				if (flag) {
					break;
				}
				if (total - arr[i] - arr[j] == 100) {
					flag = true;
					for (int ans=0; ans < num; ans++) {
						if (ans != i && ans != j) {
							System.out.println(arr[ans]);
						}
					}
				}
			}
		}
	}
}
