import javax.lang.model.type.ArrayType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (Arrays.stream(arr).sum() == 0) {
                break;
            }
            Arrays.sort(arr);
            if (arr[2] >= arr[0] + arr[1]) {
                System.out.println("Invalid");
            } else {
                if (arr[2] == arr[1] && arr[1] == arr[0]) {
                    System.out.println("Equilateral");
                } else if (arr[2] == arr[1] || arr[2] == arr[0] || arr[1] == arr[0]) {
                    System.out.println("Isosceles");
                } else {
                    System.out.println("Scalene");
                }
            }
        }
    }
}