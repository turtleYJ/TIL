import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 최소 스패닝 트리
// 최소 신장 트리
// 크루스칼 알고리즘
public class Main {
    private static int[] parent;

    private static class Edge implements Comparable<Edge> {
        int node1;
        int node2;
        int weight;

        public Edge(int node1, int node2, int weight) {
            this.node1 = node1;
            this.node2 = node2;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        parent = new int[V + 1];
        Edge[] edges = new Edge[E];

        // 각각의 노드들이 자신을 바라보도록 설정한다.
        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }

        // Edge들을 배열에 넣어준다.
        for (int i = 0; i < edges.length; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(node1, node2, weight);
        }

        // 클래스를 comparable인터페이스로 정렬기준을 오버라이딩 해놨기 때문에 가중치 기준으로 오름차순 정렬된다.
        Arrays.sort(edges);

        int res = 0;
        for (int i = 0; i < edges.length; i++) {
            Edge edge = edges[i];
            int node1 = edge.node1;
            int node2 = edge.node2;
            int weight = edge.weight;

            if (find(node1) != find(node2)) {
                union(node1, node2);
                res += weight;
            }
        }

        System.out.println(res);
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    private static void union(int a, int b) {
        int root1 = find(a);
        int root2 = find(b);

        if (root1 > root2) {
            parent[root1] = root2;
        } else {
            parent[root2] = root1;
        }
    }
}