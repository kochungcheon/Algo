import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	static int N;
	static Deque<Integer> stack = new ArrayDeque<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		for (int i=0; i<N; i++) {
			String[] command = br.readLine().split(" ");
			if (command[0].equals("push")) {
				stack.add(Integer.valueOf(command[1]));
			} else if (command[0].equals("pop")) {
				if (stack.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(stack.pollLast());
				}
			} else if (command[0].equals("size")) {
				System.out.println(stack.size());
			} else if (command[0].equals("empty")) {
				if (stack.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			} else if (command[0].equals("top")) {
				if (stack.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(stack.peekLast());
				}
			}
		}
	}
}