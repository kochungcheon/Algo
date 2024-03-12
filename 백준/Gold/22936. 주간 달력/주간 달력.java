
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    static class BaseClass {
        public Stream<Object> getFieldStream() {
            return Arrays.stream(this.getClass().getDeclaredFields())
                    .map(field -> {
                        try {
                            return field.get(this);
                        } catch (Exception e)  {
                             return null;
                        }
                    });
        }

        @Override
        public String toString() {
            return getFieldStream()
                    .map(str -> Objects.requireNonNull(str, "null").toString())
                    .collect(Collectors.joining(", ", "{", "}"));
        }

        @Override
        public int hashCode() {
            return Objects.hash(getFieldStream().toArray());
        }
    }

    static class Pair<T, R> extends BaseClass {
        T first;
        R second;
        public static <T, R> Pair<T, R> of (T first, R second) {
            var result = new Pair<T, R>();

            result.first = first;
            result.second = second;

            return result;
        }
    }
    static int N, M;
    static List<Pair> queries = new ArrayList<>();

    static int[] prefix = new int[50010];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        for (var i=0; i<M; i++) {
            int[] query = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            prefix[query[0]]++;
            prefix[query[1]+1]--;
            queries.add(Pair.of(query[0], query[1]));
        }

        for (var i=1; i<=50001; i++) {
            prefix[i] += prefix[i-1];
        }

        for (var i=1; i<=50001; i++) {
            prefix[i] += prefix[i-1];
        }

        int start = 50001;
        int end = -1;
        int tmp = -1;

        for (var i=0; i<50001-N*7; i++) {
            int tmpNow = prefix[i + N*7] - prefix[i];
            if (tmp < tmpNow) {
                start = i+1;
                end = i + N*7;
                tmp = tmpNow;
            }
        }

//        System.out.println(start + " " + end);

        int ans = 0;


        for (Pair<Integer, Integer> pair : queries) {
            int s = pair.first;
            int e = pair.second;
            int t = 0;

            for (var i = start; i <= end; i += 7) {
                // i부터 i+6까지의 구간이 s와 e 구간과 겹치는지 확인
                if (i <= e && (i + 6) >= s) {
                    t++;
                }
            }

            // 각 쿼리에 대한 결과를 ans에 더함
            ans += t;
        }
//        for (var i=0; i<30; i++) {
//            System.out.print(prefix[i] + " ");
//        }
//        System.out.println();

        System.out.println(ans);
    }

    // N * 7 가장 큰 사이즈 찾기
    // 누적합 [X + N*7] - [X-1]
}