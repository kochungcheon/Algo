import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    static int N, M;
    static List<Five> friends = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        for (var i = 0; i < N; i++) {
            // 이름, 최장 스트릭, 최장 스트릭 내 스트릭 프리즈, 날짜 이른, 스트릭 달성 실패 날짜 (F),
            String username = br.readLine();

            // 입력
            String[] streak = new String[7];
            for (var j=0; j<7; j++) {
                streak[j] = br.readLine();
            }

            int maxStreak = 0;
            int freezeInMaxStreak = Integer.MAX_VALUE;
            int startDay = 0;
            int fail = 0;

            // 지금 스트릭 동적으로 계산
            int tmpStartDay = 0;
            int tmpStreak = 0;
            int tmpFreeze = 0;
            int sideFreeze = 0;


            // 조건에 맞게 읽는 다
            for (var j=0; j<M; j++) {
                for (var h=0; h<7; h++) {
                    char now = streak[h].charAt(j);

                    // 시작
                    if (tmpStreak == 0 && now == 'O') {
                        tmpStartDay = 7*j + h;
                    }

                    if (now == 'X') {
                        fail++;
                        // 갱신 할 수 있는 지 확인
                        if (maxStreak == tmpStreak) {
                            if (freezeInMaxStreak > tmpFreeze) {
                                startDay = tmpStartDay;
                                freezeInMaxStreak = tmpFreeze;
                            }
                        } else if (maxStreak < tmpStreak) {
                            startDay = tmpStartDay;
                            freezeInMaxStreak = tmpFreeze;
                            maxStreak = tmpStreak;
                        }
                        tmpStreak = 0;
                        tmpFreeze = 0;
                        sideFreeze = 0;
                    }

                    else if (now == 'O') {
                        tmpStreak++;
                        // 사이 tmpfreeze 도 더해준다
                        tmpFreeze += sideFreeze;
                        sideFreeze = 0;
                    }

                    else if (now == 'F' && tmpStreak != 0) {
                        sideFreeze++;
                    }

                    if (j == M-1 && h == 6) {
                        if (maxStreak == tmpStreak) {
                            if (freezeInMaxStreak > tmpFreeze) {
                                startDay = tmpStartDay;
                                freezeInMaxStreak = tmpFreeze;
                            }
                        } else if (maxStreak < tmpStreak) {
                            startDay = tmpStartDay;
                            freezeInMaxStreak = tmpFreeze;
                            maxStreak = tmpStreak;
                        }
                    }


                }
            }

            friends.add(Five.of(username, maxStreak, freezeInMaxStreak, startDay, fail));
//            System.out.println(friends.get(i));
        }

        // win 배열 만들고 처리
        int[] win = new int[N];

        for (var i=0; i<N-1; i++) {
            for (var j=i+1; j<N; j++) {
                // 규칙에 따라 비교
                // 이름, 최장 스트릭, 최장 스트릭 내 스트릭 프리즈, 날짜 이른, 스트릭 달성 실패 날짜 (F),
                Five<String, Integer, Integer, Integer, Integer> one = friends.get(i);
                Five<String, Integer, Integer, Integer, Integer> two = friends.get(j);

                // 가장 긴 최장 스트릭
                if ( one.sec > two.sec) {
                    win[i]++;
                } else if (one.sec < two.sec ) {
                    win[j]++;
                }

                // 최장 스트릭 내의 더 적은 개수의 스트릭 프리즈
                else if (one.third < two.third) {
                    win[i]++;
                } else if (one.third > two.third) {
                    win[j]++;
                }

                // 최장 스트릭을 시작한 날짜가 더 이른 친구
                else if (one.forth < two.forth) {
                    win[i]++;
                } else if (one.forth > two.forth) {
                    win[j]++;
                }

                // 스트릭 프리즈 사용한 날짜를 제외하고 스트릭 달성에 실패한 날짜 수가 적은 친구
                else if (one.fifth < two.fifth) {
                    win[i]++;
                } else if (one.fifth > two.fifth) {
                    win[j]++;
                }

// 최장 스트릭 내의 더 적은 개수의 스트릭 프리즈

// 최장 스트릭을 시작한 날짜가 더 이른 친구

// 스트릭 프리즈 사용한 날짜를 제외하고 스트릭 달성에 실패한 날짜가 적은 친구

// 단, 최장 스트릭은 스트릭 프리즈로 시작하거나 끝날 수 없다.

// 그래도 같으면 순위는 같게 하고 닉네임의 사전 순으로 출력

            }
        }

        // win 배열 가공
        boolean[] www = new boolean[210];


        for (int w : win) {
            www[w] = true;
        }

        int ranking = 1;

        for (var j=205; j>=0; j--) {

            // 해당 윈이 있다면
            if (www[j]) {
                // 중복있으면 확 올리는
//                int tmp = 0;

                List<String> arr = new ArrayList<>();
                // win 배열을 탐색
                for (var h=0; h<N; h++) {
                    if (win[h] == j) {
                        arr.add((String) friends.get(h).fir);
//                        tmp++;
                    }
                }

                Collections.sort(arr);
                for (String a : arr) {
                    System.out.println(ranking + ". " + a);
                }
                ranking += 1;
            }
        }

    }


    static class BaseClass {
        public Stream<Object> getFieldStream() {
            return Arrays.stream(this.getClass().getDeclaredFields())
                    .map(field -> {
                        try {
                            return field.get(this);
                        } catch (Exception e) {
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

    static class Five<Q, W, E, R, T> extends BaseClass {
        Q fir;
        W sec;
        E third;
        R forth;
        T fifth;


        public static <Q, W, E, R, T> Five<Q, W, E, R, T> of(Q fir, W sec, E third, R forth, T fifth) {
            var res = new Five<Q, W, E, R, T>();
            res.fir = fir;
            res.sec = sec;
            res.third = third;
            res.forth = forth;
            res.fifth = fifth;

            return res;
        }
    }
}