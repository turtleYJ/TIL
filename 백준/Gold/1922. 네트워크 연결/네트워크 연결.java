import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    int node1;
    int node2;
    int cost;

    public Edge(int node1, int node2, int cost) {
        this.node1 = node1;
        this.node2 = node2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return cost - o.cost;
    }
}

public class Main {
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        Edge[] edges = new Edge[M];

        for (int i = 0; i < edges.length; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(edges);

        parent = new int[N + 1];
        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }

        int res = 0;
        for (Edge edge : edges) {
            int node1 = edge.node1;
            int node2 = edge.node2;

            if (find(node1) != find(node2)) {
                union(node1, node2);

                res += edge.cost;
            }
        }

        System.out.println(res);
    }

    private static void union(int a, int b) {
        int x = find(a);
        int y = find(b);

        if (x > y) parent[x] = y;
        else parent[y] = x;
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
}