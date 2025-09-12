import java.util.*;

class Solution {
    // 스테이지 개수, 사용자가 멈춰있는 스테이지 번호
    // 실패율 높은 스테이지 부터 내림 차순
    public static class Stage {
        int level;
        float fail;
        public Stage(int level, float fail) {
            this.level = level;
            this.fail = fail;
        }
        
        public int getLevel() {
            return this.level;
        }
        public float getFail() {
            return this.fail;
        }
    }
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int usersCnt = stages.length;
        int[] visit = new int[N + 2];
        int[] failVisit = new int[N + 2];
        for (int stage : stages) {
            for (int i=1; i<=Math.min(stage, N); i++) {
                visit[i]++;
            }
            if (stage <= N) {
                failVisit[stage]++;   
            }
        }
        // for (int i=1; i<=N; i++) {
        //     System.out.print(visit[i] + " ");
        // }
        System.out.println();
        
        PriorityQueue<Stage> pq = new PriorityQueue<>(
            Comparator.comparing(Stage::getFail).reversed()
                .thenComparing(Stage::getLevel)
        );
        
        for (int i=1; i<=N; i++) {
            float failRate = visit[i] == 0 ? 0f : ((float) failVisit[i] / (float) visit[i]);
            pq.add(new Stage(i, failRate));
        }
        
        int idx = 0;
        while (!pq.isEmpty()) {
            answer[idx++] = pq.poll().getLevel();
        }
        
        
        return answer;
    }
}
// 스테이지 도달 했으나 클리어 못한 플에이어 수 / 스테이지 도달한 플레이어 수
// 스테이지 N + 1 이하 -> N + 1 은 마지막 라운드 클리어 유저
// 실패율이 같으면 작은 번호가 앞으로 
// 스테이지 도달한 유저 없으면 해당 스테이지 실패율 0