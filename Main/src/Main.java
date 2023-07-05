import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer> A[];
	static int visit[];
	static int parent[];
	static int level[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		A = new ArrayList[N + 1];
		visit = new int[N + 1];
		parent = new int[N + 1];
		level = new int[N + 1];
		for (int i = 0; i < A.length; i++)
			A[i] = new ArrayList<Integer>();
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			A[a].add(b);
			A[b].add(a);
		}
		visit[1] = 1;
		DFS(1);
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			System.out.println(LCA(a, b));
		}
	}

	static void DFS(int a) {
		for (int i : A[a])
			if (visit[i] == 0) {
				visit[i] = 1;
				parent[i] = a;
				level[i] = level[a] + 1;
				DFS(i);
			}
	}

	static int LCA(int a, int b) {
		if (level[a] < level[b]) {
			int temp = a;
			a = b;
			b = temp;
		}
		int n = 0;
		int l = level[a] - level[b];
		while (n < l) {
			a = parent[a];
			n++;
		}
		while (a != b) {
			a = parent[a];
			b = parent[b];
		}
		return a;
	}
}
