import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double[] arr = Arrays.stream(br.readLine().split(" ")).mapToDouble(Integer::parseInt).toArray();
        int a = (int)((arr[0] / arr[1]) * arr[2]);
        int b = (int)((arr[0] * arr[1]) / arr[2]);
        System.out.println(Math.max(a, b));
    }
}