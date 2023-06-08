import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken()) - 1;
		ArrayList<Integer> A[] = new ArrayList[N];
		for (int i = 0; i < N; i++)
			A[i] = new ArrayList<Integer>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			A[a].add(b);
			A[b].add(a);
		}
		for (int i = 0; i < N; i++)
			Collections.sort(A[i]);
		int visit[] = new int[N];
		DFS(V, A, visit);
		System.out.println();
		visit = new int[N];
		BFS(V, A, visit);
	}

	static void DFS(int V, ArrayList<Integer>[] A, int visit[]) {
		System.out.print(V + 1 + " ");
		visit[V] = 1;
		for (int j = 0; j < A[V].size(); j++) {
			if (visit[(int) A[V].get(j)] == 0)
				DFS((int) A[V].get(j), A, visit);
		}

	}

	static void BFS(int V, ArrayList<Integer>[] A, int visit[]) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(V);
		visit[V] = 1;
		while (!queue.isEmpty()) {
			V = queue.poll();
			System.out.print(V + 1 + " ");
			for (int i = 0; i < A[V].size(); i++)
				if (visit[A[V].get(i)] == 0) {
					visit[A[V].get(i)] = 1;
					queue.add(A[V].get(i));
				}
		}
	}
}
