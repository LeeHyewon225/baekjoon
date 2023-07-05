import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer> A[];
	static int visit[];
	static int parent[];
	static int max_level = 0;
	static int parent2[][];
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
		parent2 = new int[(int) (Math.log(N) / Math.log(2)) + 1][N + 1];
		for (int i = 0; i < parent.length; i++)
			parent2[0][i] = parent[i];
		for (int i = 1; i < parent2.length; i++)
			for (int j = 1; j < N + 1; j++)
				parent2[i][j] = parent2[i - 1][parent2[i - 1][j]];
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			System.out.println(LCA2(a, b));
		}
	}

	static void DFS(int a) {
		for (int i : A[a])
			if (visit[i] == 0) {
				visit[i] = 1;
				parent[i] = a;
				level[i] = level[a] + 1;
				max_level = Math.max(max_level, level[i]);
				DFS(i);
			}
	}

	static int LCA2(int a, int b) {
		if (level[a] < level[b]) {
			int temp = a;
			a = b;
			b = temp;
		}
		while (level[a] != level[b]) {
			int l = (int) (Math.log(level[a] - level[b]) / Math.log(2));
			a = parent2[l][a];
		}
		if (a == b)
			return a;
		int k = 0;
		while (parent2[k][a] != parent2[k][b]) {
			k++;
		}
		if (k <= 1)
			return parent2[k][a];
		else
			return LCA2(parent2[k - 1][a], parent2[k - 1][b]);
	}
}
