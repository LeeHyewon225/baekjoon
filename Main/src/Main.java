import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int map[][];
	static int parent[];
	static PriorityQueue<Edge> q = new PriorityQueue<Edge>();
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		parent = new int[8];
		for (int i = 1; i <= 7; i++)
			parent[i] = i;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		int island = 2;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if (map[i][j] == 1)
					DFS(i, j, island++);
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if (map[i][j] != 0)
					for (int k = 0; k < 4; k++) {
						int x = i + dx[k];
						int y = j + dy[k];
						if (0 <= x && x < N && 0 <= y && y < M && map[x][y] == 0)
							is_Edge(x, y, map[i][j], k);
					}
		int count = 0;
		int sum = 0;
		while (count < island - 2 && !q.isEmpty()) {
			Edge e = q.poll();
			if (find(e.node1) != find(e.node2)) {
				union(e.node1, e.node2);
				sum += e.value;
				count++;
			}
		}
		System.out.println(count == island - 3 ? sum : -1);
	}

	static void is_Edge(int i, int j, int node, int k) {
		int count = 0;
		while (map[i][j] == 0) {
			count++;
			i += dx[k];
			j += dy[k];
			if (0 > i || i >= N || 0 > j || j >= M) {
				count = 0;
				break;
			}
		}
		if (count >= 2)
			q.add(new Edge(node, map[i][j], count));
	}

	static void DFS(int i, int j, int island) {
		map[i][j] = island;
		for (int k = 0; k < 4; k++) {
			int x = i + dx[k];
			int y = j + dy[k];
			if (0 <= x && x < N && 0 <= y && y < M && map[x][y] == 1)
				DFS(x, y, island);
		}
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
