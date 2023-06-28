import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		ArrayList<Node> a[] = new ArrayList[n];
		ArrayList<Node> a_reverse[] = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			a[i] = new ArrayList<Node>();
			a_reverse[i] = new ArrayList<Node>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken());
			a[s].add(new Node(e, v));
			a_reverse[e].add(new Node(s, v));
		}
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken()) - 1;
		int B = Integer.parseInt(st.nextToken()) - 1;

		int visit[] = new int[n];
		int distance[] = new int[n];
		for (int i = 0; i < distance.length; i++)
			distance[i] = Integer.MAX_VALUE;
		distance[A] = 0;
		PriorityQueue<Node> q = new PriorityQueue<Node>();
		q.add(new Node(A, 0));
		while (!q.isEmpty()) {
			Node now = q.poll();
			if (visit[now.node] == 1)
				continue;
			visit[now.node] = 1;
			for (Node N : a[now.node])
				if (visit[N.node] == 0 && distance[N.node] > distance[now.node] + N.value) {
					distance[N.node] = distance[now.node] + N.value;
					q.add(new Node(N.node, distance[N.node]));
				}
		}
		System.out.println(distance[B]);

		int count = 0;
		ArrayList<Integer> result = new ArrayList<Integer>();
		q.add(new Node(B, 0));
		while (!q.isEmpty()) {
			Node now = q.poll();
			result.add(now.node + 1);
			count++;
			if (now.node == A)
				break;
			for (Node N : a_reverse[now.node])
				if (now.value + N.value + distance[N.node] == distance[B]) {
					q.add(new Node(N.node, now.value + N.value));
					break;
				}
		}
		System.out.println(count);
		for (int i = result.size() - 1; i >= 0; i--)
			System.out.print(result.get(i) + " ");
	}

	static class Node implements Comparable<Node> {
		int node;
		int value;

		public Node(int node, int value) {
			this.node = node;
			this.value = value;
		}

		public int compareTo(Node n) {
			return this.value - n.value;
		}
	}
}
