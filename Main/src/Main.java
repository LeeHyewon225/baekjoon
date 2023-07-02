import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int parent[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		parent = new int[V + 1];
		for (int i = 1; i <= V; i++)
			parent[i] = i;
		Edge edge[] = new Edge[E];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			edge[i] = new Edge(a, b, c);
		}
		Arrays.sort(edge);
		int sum = 0;
		int count = 0;
		for (int i = 0; i < E; i++) {
			if (count == V - 1)
				break;
			Edge e = edge[i];
			if (find(e.node1) != find(e.node2)) {
				union(e.node1, e.node2);
				sum += e.value;
				count++;
			}
		}
		System.out.println(sum);
	}

	static void union(int a, int b) {
		parent[find(b)] = find(a);
	}

	static int find(int a) {
		if (a == parent[a])
			return a;
		else
			return parent[a] = find(parent[a]);
	}
}

class Edge implements Comparable<Edge> {
	int node1;
	int node2;
	int value;

	public Edge(int node1, int node2, int value) {
		this.node1 = node1;
		this.node2 = node2;
		this.value = value;
	}

	public int compareTo(Edge e) {
		return this.value - e.value;
	}
}
