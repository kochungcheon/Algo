import java.util.*;
class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        List<List<Node>> adj = new ArrayList<>();
        int[] dist = new int[N+1];
        
        for (int i=0; i<=N; i++) {
            dist[i] = Integer.MAX_VALUE;
            adj.add(new ArrayList<>());
        }
        
        for (int[] r: road) {
            adj.get(r[0]).add(new Node(r[1], r[2]));
            adj.get(r[1]).add(new Node(r[0], r[2]));
        }
        
        dijkstra(dist, adj);
        
        for (int d : dist) {
            if (d <= K) answer++;
        }

        return answer;
    }
    
    public void dijkstra(int[] dist, List<List<Node>> adj) {
        PriorityQueue<Node> heap = new PriorityQueue<>();
        heap.offer(new Node(1, 0));
        dist[1] = 0;
        
        while (!heap.isEmpty()) {
            Node now = heap.poll();
            
            if (dist[now.vertex] < now.cost) continue;
            
            for (Node node : adj.get(now.vertex)) {
                if (dist[now.vertex] + node.cost < dist[node.vertex]) {
                    dist[node.vertex] = dist[now.vertex] + node.cost;
                    heap.offer(new Node(node.vertex, dist[node.vertex]));
                }
            }
        }
    }
    
    class Node implements Comparable<Node> {
        int vertex;
        int cost;
        
        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}