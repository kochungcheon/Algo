
import javax.lang.model.type.ArrayType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i=0; i<N*2; i++) {
            StringBuffer sb = new StringBuffer();
            for (int j=0; j<N; j++) {
                //* *
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        sb.append("*");
                    } else {
                        sb.append(" ");
                    }
                }
                // * *
                else {
                    if (j % 2 == 0) {
                        sb.append(" ");
                    } else {
                        sb.append("*");
                    }
                }
            }
            System.out.println(sb);
            if (N == 1) break;
        }
    }
}