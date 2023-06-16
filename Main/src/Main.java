import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
	static int map[][];
	static int visit[][];
	static int N;
	static int M;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		while (true) {
			if (check_iceberg()) {
				System.out.println(count);
				break;
			} else {
				count++;
				if (after_1year()) {
					System.out.println("0");
					break;
				}
			}
		}
	}

	static boolean check_iceberg() {
		visit = new int[N][M];
		int count = 0;
		for (int i = 0; i < N; i++) 
			for (int j = 0; j < M; j++) 
				if (map[i][j] > 0 && visit[i][j] == 0) {
					if (count == 1)
						return true;
					count++;
					DFS(i, j);
				}
		return false;
	}

	static void DFS(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int x2 = x + dx[i];
			int y2 = y + dy[i];
			if (0 <= x2 && x2 < N && 0 <= y2 && y2 < M && visit[x2][y2] == 0) 
				if (map[x2][y2] > 0) {
					visit[x2][y2] = 1;
					DFS(x2, y2);
				}
		}
	}

	static boolean after_1year() {
		boolean melt_all = true;
		int count_melt[][] = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] > 0) 
					for (int k = 0; k < 4; k++) {
						int x1 = i + dx[k];
						int y1 = j + dy[k];
						if (0 <= x1 && x1 < N && 0 <= y1 && y1 < M)
							if (map[x1][y1] <= 0)
								count_melt[i][j]++;
					}
				if (map[i][j] > 0)
					melt_all = false;
			}
		}
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if (map[i][j] > 0)
					map[i][j] -= count_melt[i][j];

		return melt_all;
	}
}
