import javax.lang.model.type.ArrayType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        for (int i=0; i<9; i++) {
            total -= Integer.parseInt(br.readLine());
        }
        System.out.println(total);
    }
}