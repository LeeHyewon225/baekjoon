import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		ArrayList<Node> A[] = new ArrayList[n];
		PriorityQueue<Integer> distance[] = new PriorityQueue[n];
		for (int i = 0; i < n; i++) {
			A[i] = new ArrayList<Node>();
			distance[i] = new PriorityQueue<Integer>(k, Collections.reverseOrder());
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken());
			A[a].add(new Node(b, v));
		}
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		queue.add(new Node(0, 0));
		distance[0].add(0);
		while (!queue.isEmpty()) {
			Node now = queue.poll();
			for (Node node : A[now.node])
				if (distance[node.node].size() < k) {
					distance[node.node].add(node.value + now.value);
					queue.add(new Node(node.node, node.value + now.value));
				} else if (distance[node.node].peek() > node.value + now.value) {
					distance[node.node].poll();
					distance[node.node].add(node.value + now.value);
					queue.add(new Node(node.node, node.value + now.value));
				}
		}
		for (int i = 0; i < n; i++)
			System.out.println(distance[i].size() == k ? distance[i].poll() : -1);
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
