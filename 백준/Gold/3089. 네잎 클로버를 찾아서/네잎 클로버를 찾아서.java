import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static Map<Integer, List<Integer>> xHash = new HashMap<>();
    static Map<Integer, List<Integer>> yHash = new HashMap<>();

    static Integer findRight(int x, List<Integer> arr) {
        int s = 0;
        int e = arr.size()-1;

        int find = -1;
        while (s <= e) {
            int mid = (s + e) / 2;
            int arrMid =  arr.get(mid);

            // 크면 기록 하고 넘어가
            if (arrMid > x) {
                e = mid - 1;
                find = arrMid;
            }

            else if (arrMid <= x) {
                s = mid + 1;
            }
        }

        return find;
    }

    static Integer findLeft(int x, List<Integer> arr) {
        int s = 0;
        int e = arr.size() - 1;

        int find = -1;
        while (s <= e) {
            int mid = (s + e) / 2;
            int arrMid = arr.get(mid);

            if (arrMid < x) {
                s = mid + 1;
                find = arrMid;
            } else if (arrMid >= x) {
                e = mid - 1;
            }
        }

        return find;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (var i=0; i<N; i++) {
            int[] com = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            xHash.putIfAbsent(com[0], new ArrayList<>());
            xHash.get(com[0]).add(com[1]);

            yHash.putIfAbsent(com[1], new ArrayList<>());
            yHash.get(com[1]).add(com[0]);
        }

        for (List<Integer> arr : yHash.values()) {
            Collections.sort(arr);
        }

        for (List<Integer> arr : xHash.values()) {
            Collections.sort(arr);
        }





        int x = 0;
        int y = 0;

        String com = br.readLine();

        for (var i=0; i<M; i++) {
            char now = com.charAt(i);
            // y ++
            if (now == 'U') {
                List<Integer> yList = xHash.get(x);
                y = findRight(y, yList);
            }

            // y --
            else if (now == 'D') {
                List<Integer> yList = xHash.get(x);
                y = findLeft(y, yList);
            }

            // x--
            else if (now == 'L') {
                List<Integer> xList = yHash.get(y);
                x = findLeft(x, xList);
            }

            // x++
            else if (now == 'R') {
                List<Integer> xList = yHash.get(y);
                x = findRight(x, xList);
            }

        }

        System.out.println(x + " " + y);
    }
}