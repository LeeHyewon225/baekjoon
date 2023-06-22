import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int Node[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		Node = new int[n + 1];
		for (int i = 1; i <= n; i++)
			Node[i] = i;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++)
				if (Integer.parseInt(st.nextToken()) == 1)
					union(i, j);
		}
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		for (int i = 1; i < m; i++) {
			int b = Integer.parseInt(st.nextToken());
			if (find(a) != find(b)) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}

	static void union(int a, int b) {
		Node[find(b)] = find(a);
	}

	static int find(int a) {
		if (a == Node[a])
			return a;
		else
			return Node[a] = find(Node[a]);
	}
}
