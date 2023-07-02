import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	static int parent[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char computer[][] = new char[N][N];
		PriorityQueue<Edge> q = new PriorityQueue<Edge>();
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++)
			parent[i] = i;
		int all = 0;
		for (int i = 0; i < N; i++) {
			computer[i] = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) 
				if (computer[i][j] != '0') {
					int value;
					if (computer[i][j] >= 'a')
						value = computer[i][j] - 'a' + 1;
					else
						value = computer[i][j] - 'A' + 27;
					all += value;
					if (i != j)
						q.add(new Edge(i, j, value));
				}
		}
		int sum = 0;
		int count = 0;
		while (count < N - 1 && !q.isEmpty()) {
			Edge e = q.poll();
			if (find(e.node1) != find(e.node2)) {
				union(e.node1, e.node2);
				sum += e.value;
				count++;
			}
		}
		System.out.println(count == N - 1 ? all - sum : -1);
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
