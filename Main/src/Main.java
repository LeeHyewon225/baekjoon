import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean binary_graph = true;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		for (int k = 0; k < K; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			ArrayList<Integer> A[] = new ArrayList[N];
			int visit[] = new int[N];
			for (int i = 0; i < N; i++)
				A[i] = new ArrayList<Integer>();
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;
				A[a].add(b);
				A[b].add(a);
			}
			binary_graph = true;
			for (int i = 0; i < N; i++)
				if (visit[i] == 0)
					BFS(i, A, visit);
			System.out.println(binary_graph ? "YES" : "NO");
		}
	}

	static void BFS(int n, ArrayList<Integer> A[], int visit[]) {
		Queue<Integer> q = new LinkedList<Integer>();
		visit[n] = 1;
		q.add(n);
		while (!q.isEmpty()) {
			int now = q.poll();
			for (int i = 0; i < A[now].size(); i++) {
				int a = A[now].get(i);
				if (visit[a] == 0) {
					visit[a] = -visit[now];
					q.add(a);
				} else if (visit[a] == visit[now]) {
					binary_graph = false;
					return;
				}
			}
		}
	}
}
