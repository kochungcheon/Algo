import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
        String a = br.readLine();
        String b = br.readLine();
        String c = br.readLine();

        int A = IntStream.range(0, arr.length)
                .filter(i -> a.equals(arr[i]))
                .findFirst()
                .orElse(-1) * 10;
        int B = IntStream.range(0, arr.length)
                .filter(i -> b.equals(arr[i]))
                .findFirst()
                .orElse(-1);
        int C = IntStream.range(0, arr.length)
                .filter(i -> c.equals(arr[i]))
                .findFirst()
                .orElse(-1);

        System.out.println((A+B)*(long)Math.pow(10, C));
    }
}