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
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		ArrayList<rode> A[] = new ArrayList[n];
		ArrayList<rode> reverse_A[] = new ArrayList[n];
		int result[] = new int[n];
		int indegree[] = new int[n];
		int visit[] = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = new ArrayList<rode>();
			reverse_A[i] = new ArrayList<rode>();
		}
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken());
			A[a].add(new rode(b, d));
			indegree[b]++;
			reverse_A[b].add(new rode(a, d));
		}
		st = new StringTokenizer(br.readLine());
		int start_city = Integer.parseInt(st.nextToken()) - 1;
		int end_city = Integer.parseInt(st.nextToken()) - 1;
		Queue<rode> q = new LinkedList<rode>();
		q.add(new rode(start_city, 0));
		while (!q.isEmpty()) {
			rode now = q.poll();
			for (rode i : A[now.city]) {
				indegree[i.city]--;
				result[i.city] = Math.max(result[i.city], result[now.city] + i.d);
				if (indegree[i.city] == 0)
					q.add(new rode(i.city, result[i.city]));
			}
		}
		System.out.println(result[end_city]);
		visit[end_city] = 1;
		int count = 0;
		q.add(new rode(end_city, 0));
		while (!q.isEmpty()) {
			rode now = q.poll();
			for (rode i : reverse_A[now.city]) {
				if (result[now.city] == result[i.city] + i.d) {
					count++;
					if (visit[i.city] == 0)
						q.add(new rode(i.city, result[i.city]));
					visit[i.city] = 1;
				}
			}
		}
		System.out.println(count);
	}

	static class rode {
		int city;
		int d;

		public rode(int city, int d) {
			this.city = city;
			this.d = d;
		}
	}
}
