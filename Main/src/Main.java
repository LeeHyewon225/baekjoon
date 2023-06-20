import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken()) + 1;
		int X = Integer.parseInt(st.nextToken()) - 1;
		ArrayList<Integer> A[] = new ArrayList[N];
		for (int i = 0; i < N; i++)
			A[i] = new ArrayList<Integer>();
		int visit[] = new int[N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			A[a].add(b);
		}
		BFS(X, N, A, visit);
		boolean result = false;
		for (int i = 0; i < N; i++) 
			if (visit[i] == K) {
				result = true;
				System.out.println(i + 1);
			}
		if (!result)
			System.out.println(-1);
	}

	static void BFS(int n, int N, ArrayList<Integer> A[], int visit[]) {
		Queue<Integer> q = new LinkedList<Integer>();
		visit[n] = 1;
		q.add(n);
		while (!q.isEmpty()) {
			int now = q.poll();
			for (int i = 0; i < A[now].size(); i++) {
				int a = A[now].get(i);
				if (visit[a] == 0) {
					visit[a] = visit[now] + 1;
					q.add(a);
				}
			}
		}
	}
}
