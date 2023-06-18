import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
	static int count = 0;
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int item[] = new int[N];
		for (int i = 0; i < N; i++)
			item[i] = Integer.parseInt(st.nextToken());
		ArrayList<Node> A[] = new ArrayList[N];
		for (int i = 0; i < N; i++)
			A[i] = new ArrayList<Node>();
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int t = Integer.parseInt(st.nextToken());
			A[a].add(new Node(b, t));
			A[b].add(new Node(a, t));
		}
		for (int i = 0; i < N; i++) 
			BFS(i, N, M, A, item);
		System.out.println(max);
	}

	static void BFS(int n, int N, int M, ArrayList<Node> A[], int item[]) {
		PriorityQueue<Node> q = new PriorityQueue<Node>();
		int visit[] = new int[N];
		visit[n] = 1;
		int item_count = item[n];
		for (int i = 0; i < A[n].size(); i++) 
			q.add(new Node(A[n].get(i).n, A[n].get(i).d));
		while (!q.isEmpty()) {
			Node now = q.poll();
			if (visit[now.n] == 0 && now.d <= M) {
				visit[now.n] = now.d;
				item_count += item[now.n];
				for (int i = 0; i < A[now.n].size(); i++) {
					Node a = A[now.n].get(i);
					q.add(new Node(a.n, now.d + a.d));
				}
			}
		}
		max = Math.max(max, item_count);
	}

	static class Node implements Comparable<Node>{
		int n;
		int d;

		public Node(int n, int d) {
			this.n = n;
			this.d = d;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.d - o.d;
		}
	}
}
