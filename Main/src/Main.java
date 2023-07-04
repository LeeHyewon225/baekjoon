import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int visit[];
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> a[] = new ArrayList[n + 1];
		visit = new int[n];
		int root = -1;
		for (int i = 0; i < a.length; i++)
			a[i] = new ArrayList<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int q = Integer.parseInt(st.nextToken());
			if (q == -1)
				root = i;
			else
				a[q].add(i);
		}
		int d = Integer.parseInt(br.readLine());
		if (d == root) {
			System.out.println(0);
			return;
		}
		BFS(root, a, d);
		System.out.println(answer);
	}

	static void BFS(int n, ArrayList<Integer> a[], int d) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);
		while (!q.isEmpty()) {
			int now = q.poll();
			int count = 0;
			for (int next : a[now]) {
				if (next == d)
					continue;
				if (visit[next] == 0) {
					visit[next] = 1;
					q.add(next);
				}
				count++;
			}
			if (count == 0)
				answer++;
		}
	}
}
