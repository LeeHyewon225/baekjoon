import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine()) - 1;
		ArrayList<Node> A[] = new ArrayList[V];
		for (int i = 0; i < V; i++)
			A[i] = new ArrayList<Node>();
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());
			A[u].add(new Node(v, w));
		}
		int distance[] = new int[V];
		int visit[] = new int[V];
		for (int i = 0; i < V; i++)
			distance[i] = Integer.MAX_VALUE;
		distance[K] = 0;
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		queue.add(new Node(K, 0));
		while (!queue.isEmpty()) {
			Node now = queue.poll();
			if (visit[now.node] == 1)
				continue;
			visit[now.node] = 1;
			for (Node node : A[now.node])
				if (distance[node.node] > distance[now.node] + node.value) {
					distance[node.node] = distance[now.node] + node.value;
					queue.add(new Node(node.node, distance[node.node]));
				}
		}
		for (int i = 0; i < V; i++)
			System.out.println(distance[i] == Integer.MAX_VALUE ? "INF" : distance[i]);
	}

	static class Node implements Comparable<Node> {
		public int node;
		public int value;

		public Node(int node, int value) {
			this.node = node;
			this.value = value;
		}

		@Override
		public int compareTo(Node o) {
			return this.value - o.value;
		}
	}
}
