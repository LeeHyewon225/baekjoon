import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		ArrayList<Node> A[] = new ArrayList[N];
		for (int i = 0; i < N; i++)
			A[i] = new ArrayList<Node>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken());
			A[a].add(new Node(b, v));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken()) - 1;
		int end = Integer.parseInt(st.nextToken()) - 1;
		int distance[] = new int[N];
		int visit[] = new int[N];
		for (int i = 0; i < N; i++)
			distance[i] = Integer.MAX_VALUE;
		distance[start] = 0;
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		queue.add(new Node(start, 0));
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
		System.out.println(distance[end]);
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
