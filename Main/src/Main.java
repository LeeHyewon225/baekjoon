import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int Go_Back[];
	static int N, M, X;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken()) - 1;
		int max = 0;
		ArrayList<Node> Go_a[] = new ArrayList[N];
		ArrayList<Node> Back_a[] = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			Go_a[i] = new ArrayList<Node>();
			Back_a[i] = new ArrayList<Node>();
		}
		Go_Back = new int[N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()) - 1;
			int B = Integer.parseInt(st.nextToken()) - 1;
			int T = Integer.parseInt(st.nextToken());
			Go_a[B].add(new Node(A, T));
			Back_a[A].add(new Node(B, T));
		}
		party(Go_a);
		party(Back_a);
		for (int i = 0; i < Go_Back.length; i++)
			if (max < Go_Back[i])
				max = Go_Back[i];
		System.out.println(max);
	}

	static void party(ArrayList<Node> a[]) {
		PriorityQueue<Node> q = new PriorityQueue<Node>();
		int visit[] = new int[N];
		int distance[] = new int[N];
		for (int j = 0; j < distance.length; j++) 
			distance[j] = Integer.MAX_VALUE;
		distance[X] = 0;
		q.add(new Node(X, 0));
		while (!q.isEmpty()) {
			Node now = q.poll();
			if (visit[now.node] == 1)
				continue;
			visit[now.node] = 1;
			for (Node n : a[now.node]) 
				if (visit[n.node] == 0 && distance[n.node] > distance[now.node] + n.time) {
					distance[n.node] = distance[now.node] + n.time;
					q.add(new Node(n.node, distance[n.node]));
				}		
		}
		for (int i = 0; i < distance.length; i++) 
			Go_Back[i] += distance[i];
	}

	static class Node implements Comparable<Node> {
		public int node;
		public int time;

		public Node(int node, int time) {
			this.node = node;
			this.time = time;
		}

		public int compareTo(Node n) {
			return this.time - n.time;
		}
	}
}
