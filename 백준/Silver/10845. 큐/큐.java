import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> queue = new ArrayDeque<>();
		StringTokenizer st;
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			if (command.equals("push")) {
				queue.add(Integer.parseInt(st.nextToken()));
			} else if (command.equals("pop")) {
				System.out.println(queue.isEmpty() ? -1 : queue.poll());
			} else if (command.equals("size")) {
				System.out.println(queue.size());
			} else if (command.equals("empty")) {
				System.out.println(queue.isEmpty() ? 1 : 0);
			} else if (command.equals("front")) {
				System.out.println(queue.isEmpty() ? -1 : queue.peek());
			} else if (command.equals("back")) {
				System.out.println(queue.isEmpty() ? -1 : queue.peekLast());
			}
		}
	}
}