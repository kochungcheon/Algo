import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int[] arr = Arrays.stream(br.readLine().split("/")).mapToInt(Integer::parseInt).toArray();
        if (arr[0] + arr[2] < arr[1] || arr[1] == 0) {
            System.out.println("hasu");
        } else {
            System.out.println("gosu");
        }
    }
}