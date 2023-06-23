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
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		ArrayList<Integer> s[] = new ArrayList[n];
		int d[] = new int[n];
		for (int i = 0; i < n; i++)
			s[i] = new ArrayList<Integer>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			s[a].add(b);
			d[b]++;
		}
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < n; i++)
			if (d[i] == 0) 
				q.add(i);
		while (!q.isEmpty()) {
			int now = q.poll();
			System.out.print(now + 1 + " ");
			for (int i : s[now]) {
				d[i]--;
				if (d[i] == 0)
					q.add(i);
			}
		}
	}
}
