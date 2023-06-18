import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int cheese[][] = new int[N][M];
		int outside_air[][];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				cheese[i][j] = Integer.parseInt(st.nextToken());
		}
		int time = 0;
		while (true) {
			outside_air = new int[N][M];
			outside_air[0][0] = 1;
			visit_outside(0, 0, N, M, cheese, outside_air);
			melt_cheese(N, M, cheese, outside_air);
			time++;
			if (check(cheese, N, M))
				break;
		}
		System.out.println(time);
	}

	static void visit_outside(int r, int c, int N, int M, int cheese[][], int outside_air[][]) {
		for (int i = 0; i < 4; i++) {
			int x = r + dx[i];
			int y = c + dy[i];
			if (0 <= x && x < N && 0 <= y && y < M)
				if (cheese[x][y] == 0 && outside_air[x][y] == 0) {
					outside_air[x][y] = 1;
					visit_outside(x, y, N, M, cheese, outside_air);
				}
		}
	}

	static void melt_cheese(int N, int M, int cheese[][], int outside_air[][]) {
		int cheese_copy[][] = new int[N][M];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if (cheese[i][j] != 0) {
					int air_count = 0;
					for (int k = 0; k < 4; k++) {
						int x = i + dx[k];
						int y = j + dy[k];
						if (0 <= x && x < N && 0 <= y && y < M && cheese[x][y] == 0 && outside_air[x][y] == 1)
							air_count++;
					}
					if (air_count >= 2)
						cheese_copy[i][j] = -1;
				}
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				cheese[i][j] += cheese_copy[i][j];
	}

	static boolean check(int cheese[][], int N, int M) {
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if (cheese[i][j] == 1)
					return false;
		return true;
	}
}
