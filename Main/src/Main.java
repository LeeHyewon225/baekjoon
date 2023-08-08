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
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int build_time[] = new int[N];
			ArrayList<Integer> a[] = new ArrayList[N];
			int d[] = new int[N];
			int min_time[] = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				a[j] = new ArrayList<Integer>();
				build_time[j] = Integer.parseInt(st.nextToken());
			}
			for (int j = 0; j < M; j++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken()) - 1;
				int Y = Integer.parseInt(st.nextToken()) - 1;
				a[X].add(Y);
				d[Y]++;
			}
			int W = Integer.parseInt(br.readLine()) - 1;
			Queue<Integer> q = new LinkedList<Integer>();
			for (int j = 0; j < d.length; j++)
				if (d[j] == 0) {
					q.add(j);
					min_time[j] = build_time[j];
				}
			while (!q.isEmpty()) {
				int now = q.poll();
				if (now == W) {
					System.out.println(min_time[now]);
					break;
				}
				for (int j : a[now]) {
					d[j]--;
					min_time[j] = Math.max(min_time[now] + build_time[j], min_time[j]);
					if (d[j] == 0)
						q.add(j);
				}
			}
		}
	}
}
