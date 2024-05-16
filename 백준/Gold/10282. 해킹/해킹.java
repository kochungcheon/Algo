import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static int n, d, c;
    static List<Pair>[] adj;
    static class Pair implements Comparable<Pair> {
        int node;
        int s;

        public Pair(int node, int s) {
            this.node = node;
            this.s = s;
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.s, other.s);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            adj = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                adj[i] = new ArrayList<>();
            }

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                adj[b].add(new Pair(a, s));
            }
            dijkstra(c);
        }
    }

    private static void dijkstra(int start) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.add(new Pair(start, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int currentNode = current.node;
            int currentDistance = current.s;

            if (currentDistance > dist[currentNode]) continue;

            for (Pair neighbor : adj[currentNode]) {
                int nextNode = neighbor.node;
                int weight = neighbor.s;
                int newDist = currentDistance + weight;

                if (newDist < dist[nextNode]) {
                    dist[nextNode] = newDist;
                    pq.add(new Pair(nextNode, newDist));
                }
            }
        }

        int count = 0, maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] != Integer.MAX_VALUE) {
                count++;
                maxTime = Math.max(maxTime, dist[i]);
            }
        }
        System.out.println(count + " " + maxTime);
    }
}
