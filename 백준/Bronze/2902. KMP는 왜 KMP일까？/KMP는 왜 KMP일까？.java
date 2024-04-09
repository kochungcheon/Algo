import javax.lang.model.type.ArrayType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("-");
        StringBuffer sb = new StringBuffer();
        for (String a : arr) {
            sb.append(a.charAt(0));
        }
        System.out.println(sb);
    }
}