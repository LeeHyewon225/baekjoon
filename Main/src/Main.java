import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
	static int count = 0;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int pipe[][] = new int[N][N];
		int visit[][] = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				pipe[i][j] = Integer.parseInt(st.nextToken());
		}
		DFS(0, 1, 0, pipe, visit);
		System.out.println(count);
	}

	static void DFS(int i, int j, int state, int pipe[][], int visit[][]) {
		if (i == N - 1 && j == N - 1) {
			count++;
			return;
		}
		if (state != 1)
			if (j + 1 < N && pipe[i][j + 1] == 0 && visit[i][j + 1] == 0) {
				visit[i][j + 1] = 1;
				DFS(i, j + 1, 0, pipe, visit);
				visit[i][j + 1] = 0;
			}
		if (state != 0)
			if (i + 1 < N && pipe[i + 1][j] == 0 && visit[i + 1][j] == 0) {
				visit[i + 1][j] = 1;
				DFS(i + 1, j, 1, pipe, visit);
				visit[i + 1][j] = 0;
			}
		if (i + 1 < N && j + 1 < N && pipe[i + 1][j + 1] == 0 && pipe[i][j + 1] == 0 && pipe[i + 1][j] == 0
				&& visit[i + 1][j + 1] == 0) {
			visit[i + 1][j + 1] = 1;
			DFS(i + 1, j + 1, 2, pipe, visit);
			visit[i + 1][j + 1] = 0;
		}
	}
}
