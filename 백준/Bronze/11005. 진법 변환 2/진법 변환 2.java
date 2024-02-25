import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        List<Integer> arr = new ArrayList<>();
        while (N > 0) {
            arr.add(N%B);
            N /= B;
        }

        StringBuilder sb = new StringBuilder();
        for (int i=arr.size()-1; i>=0; i--) {
            if (arr.get(i) > 9) {
                sb.append((char) (arr.get(i) - 10 + 'A'));
            }
            else {
                sb.append(arr.get(i));
            }
        }
        System.out.println(sb);
    }
}