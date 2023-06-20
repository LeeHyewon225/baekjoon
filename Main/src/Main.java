import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int max_list[];
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer> A[] = new ArrayList[N];
		max_list = new int[N];
		for (int i = 0; i < N; i++)
			A[i] = new ArrayList<Integer>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			A[b].add(a);
		}
		for (int i = 0; i < N; i++)
			BFS(i, N, A);
		for (int i = 0; i < N; i++)
			if (max == max_list[i])
				System.out.print(i + 1 + " ");
	}

	static void BFS(int n, int N, ArrayList<Integer> A[]) {
		int visit[] = new int[N];
		Queue<Integer> q = new LinkedList<Integer>();
		visit[n] = 1;
		q.add(n);
		int count = 0;
		while (!q.isEmpty()) {
			int now = q.poll();
			for (int i = 0; i < A[now].size(); i++) {
				int a = A[now].get(i);
				if (visit[a] == 0) {
					visit[a] = visit[now] + 1;
					q.add(a);
				}
			}
			count++;
		}
		max_list[n] = count;
		max = Math.max(max, max_list[n]);
	}
}
