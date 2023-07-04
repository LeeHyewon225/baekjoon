import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int result[];
	static int visit[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> a[] = new ArrayList[n + 1];
		result = new int[n + 1];
		visit = new int[n + 1];
		visit[1] = 1;
		for (int i = 0; i < a.length; i++)
			a[i] = new ArrayList<Integer>();
		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int q = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			a[q].add(b);
			a[b].add(q);
		}
		BFS(1, a);
		for (int i = 2; i < result.length; i++)
			System.out.println(result[i]);
	}

	static void BFS(int n, ArrayList<Integer> a[]) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);
		while (!q.isEmpty()) {
			int now = q.poll();
			for (int next : a[now])
				if (visit[next] == 0) {
					visit[next] = 1;
					result[next] = now;
					q.add(next);
				}
		}
	}
}
