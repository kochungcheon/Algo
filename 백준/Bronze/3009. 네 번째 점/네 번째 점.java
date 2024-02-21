import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        List<Integer> xArr = new ArrayList<>();
        List<Integer> yArr = new ArrayList<>();
        for (int i=0; i<3; i++) {
          st = new StringTokenizer(br.readLine());
          int x = Integer.parseInt(st.nextToken());
          if (xArr.contains(x)) {
              xArr.remove((Integer) x);
          } else {
              xArr.add(x);
          }

          int y = Integer.parseInt(st.nextToken());
          if (yArr.contains(y)) {
              yArr.remove((Integer)y);
          }
          else {
              yArr.add(y);
          }
        }

        System.out.println(xArr.get(0) + " " + yArr.get(0));
    }
}
