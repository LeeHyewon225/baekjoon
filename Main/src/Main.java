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
		int n = Integer.parseInt(br.readLine());
		int time[] = new int[n];
		int result[] = new int[n];
		ArrayList<Integer> s[] = new ArrayList[n];
		int d[] = new int[n];
		for (int i = 0; i < n; i++)
			s[i] = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			while (true) {
				int node = Integer.parseInt(st.nextToken()) - 1;
				if (node == -2)
					break;
				s[node].add(i);
				d[i]++;
			}
		}
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < n; i++)
			if (d[i] == 0) {
				q.add(i);
				result[i] = time[i];
			}
		while (!q.isEmpty()) {
			int now = q.poll();
			for (int i : s[now]) {
				d[i]--;
				result[i] = Math.max(result[i], result[now] + time[i]);
				if (d[i] == 0) 
					q.add(i);
			}
		}
		for (int i = 0; i < n; i++)
			System.out.println(result[i]);
	}
}
