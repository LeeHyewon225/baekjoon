import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int Node[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Node = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			Node[i] = i;
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (t == 0)
				union(a, b);
			else
				System.out.println(find(a) == find(b) ? "YES" : "NO");
		}
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
