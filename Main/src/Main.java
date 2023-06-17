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
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int map[][] = new int[R][C];
		int air_purifier = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1)
					air_purifier = i;
			}
		}
		for (int i = 0; i < T; i++) {
			spread_dust(R, C, map);
			operate_air_purifier(R, C, map, air_purifier);
		}
		int sum = 0;
		for (int i = 0; i < R; i++)
			for (int j = 0; j < C; j++)
				sum += map[i][j];
		System.out.println(sum + 2);

	}

	static void spread_dust(int R, int C, int map[][]) {
		int map2[][] = new int[R][C];
		for (int i = 0; i < R; i++)
			for (int j = 0; j < C; j++) {
				if (map[i][j] == -1)
					continue;
				if (map[i][j] != 0) {
					int sum = 0;
					for (int k = 0; k < 4; k++) {
						int x = i + dx[k];
						int y = j + dy[k];
						if (0 <= x && x < R && 0 <= y && y < C && map[x][y] != -1) {
							map2[x][y] += map[i][j] / 5;
							sum += map[i][j] / 5;
						}
					}
					map2[i][j] -= sum;
				}
			}
		for (int i = 0; i < R; i++)
			for (int j = 0; j < C; j++)
				map[i][j] += map2[i][j];
	}

	static void operate_air_purifier(int R, int C, int map[][], int air_purifier) {
		for (int i = air_purifier - 2; i > 0; i--)
			map[i][0] = map[i - 1][0];
		for (int i = air_purifier + 1; i < R - 1; i++)
			map[i][0] = map[i + 1][0];
		for (int i = 0; i < C - 1; i++) {
			map[0][i] = map[0][i + 1];
			map[R - 1][i] = map[R - 1][i + 1];
		}
		for (int i = R - 1; i > air_purifier; i--)
			map[i][C - 1] = map[i - 1][C - 1];
		for (int i = 0; i < air_purifier - 1; i++)
			map[i][C - 1] = map[i + 1][C - 1];
		for (int i = C - 1; i > 1; i--) {
			map[air_purifier - 1][i] = map[air_purifier - 1][i - 1];
			map[air_purifier][i] = map[air_purifier][i - 1];
		}
		map[air_purifier - 1][1] = 0;
		map[air_purifier][1] = 0;
	}
}
