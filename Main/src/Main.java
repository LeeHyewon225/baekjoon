import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int x[] = { -1, 1, 0, 0 };
	static int y[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		char A[][] = new char[N][M];
		for (int i = 0; i < N; i++) {
			A[i] = bf.readLine().toCharArray();
			for (int j = 0; j < N; j++) {

			}
		}
		int visit[][] = new int[N][M];
		BFS(0, 0, A, visit);
	}

	static void BFS(int i, int j, char A[][], int visit[][]) {
		Queue<int[]> queue = new LinkedList<int[]>();
		int a[] = { i, j };
		queue.add(a);
		visit[i][j] = 1;
		while (!queue.isEmpty()) {
			int now[] = queue.poll();
			visit[now[0]][now[1]] = 1;
			if (now[0] == N - 1 && now[1] == M - 1) {
				System.out.println(A[now[0]][now[1]] - '0');
				break;
			}
			for (int k = 0; k < 4; k++) {
				int x1 = now[0] + x[k];
				int y1 = now[1] + y[k];
				if (x1 >= 0 && x1 < N && y1 >= 0 && y1 < M) {
					if (A[x1][y1] != '0' && visit[x1][y1] == 0) {
						visit[x1][y1] = 1;
						A[x1][y1] = (char) (A[now[0]][now[1]] + 1);
						queue.add(new int[] { x1, y1 });
					}
				}
			}
		}
	}
}
