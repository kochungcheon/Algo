import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String[] group = new String[]{"Soongsil", "Korea", "Hanyang"};

        int total = 0;
        int min = 101;
        int idx = -1;
        for (int i=0; i<3; i++) {
            if (min > arr[i]) {
                min = arr[i];
                idx = i;
            }
            total += arr[i];
        }

        if (total >= 100) {
            System.out.println("OK");
        }
        else {
            System.out.println(group[idx]);
        }
    }
}