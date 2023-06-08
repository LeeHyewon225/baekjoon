import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(bf.readLine());
		ArrayList<Node> A[] = new ArrayList[N];
		for (int i = 0; i < N; i++)
			A[i] = new ArrayList<Node>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			int v1 = Integer.parseInt(st.nextToken()) - 1;
			while (true) {
				int v2 = Integer.parseInt(st.nextToken()) - 1;
				if (v2 == -2)
					break;
				int d = Integer.parseInt(st.nextToken());
				A[v1].add(new Node(v2, d));
			}
		}
		int visit[] = new int[N];
		long distance[] = new long[N];
		BFS(0, A, visit, distance);
		int max_index = 0;
		for (int i = 0; i < N; i++)
			if (distance[i] > distance[max_index])
				max_index = i;
		visit = new int[N];
		distance = new long[N];
		BFS(max_index, A, visit, distance);
		Arrays.sort(distance);
		System.out.println(distance[N - 1]);
	}

	static void BFS(int v, ArrayList<Node> A[], int visit[], long distance[]) {
		Queue<Integer> queue = new LinkedList<Integer>();
		visit[v] = 1;
		for (int i = 0; i < A[v].size(); i++) {
			visit[A[v].get(i).V] = 1;
			queue.add(A[v].get(i).V);
			distance[A[v].get(i).V] = A[v].get(i).D;
		}
		while (!queue.isEmpty()) {
			int now = queue.poll();
			for (int i = 0; i < A[now].size(); i++) {
				Node next = A[now].get(i);
				if (visit[next.V] == 0) {
					visit[next.V] = 1;
					queue.add(next.V);
					distance[next.V] = distance[now] + next.D;
				}
			}
		}
	}
}

class Node {
	int V;
	int D;

	public Node(int v, int d) {
		V = v;
		D = d;
	}
}
