import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		char picture[][] = new char[N][N];
		int visit[][] = new int[N][N];
		for (int i = 0; i < N; i++) {
			picture[i] = br.readLine().toCharArray();
		}
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visit[i][j] == 0) {
					DFS_RGB(picture[i][j], i, j, visit, picture);
					count++;
				}
			}
		}
		visit = new int[N][N];
		System.out.print(count + " ");
		count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visit[i][j] == 0) {
					DFS_RB(picture[i][j], i, j, visit, picture);
					count++;
				}
			}
		}
		System.out.print(count);
	}

	static void DFS_RGB(char c, int i, int j, int visit[][], char picture[][]) {
		for (int k = 0; k < 4; k++) {
			int x = i + dx[k];
			int y = j + dy[k];
			if (x >= 0 && x < N && y >= 0 && y < N) {
				if (visit[x][y] == 0 && picture[x][y] == c) {
					visit[x][y] = 1;
					DFS_RGB(c, x, y, visit, picture);
				}
			}
		}
	}

	static void DFS_RB(char c, int i, int j, int visit[][], char picture[][]) {
		for (int k = 0; k < 4; k++) {
			int x = i + dx[k];
			int y = j + dy[k];
			if (x >= 0 && x < N && y >= 0 && y < N) {
				if (visit[x][y] == 0) {
					if ((c == 'B' && picture[x][y] == c)
							|| (c != 'B' && (picture[x][y] == 'R' || picture[x][y] == 'G'))) {
						visit[x][y] = 1;
						DFS_RB(c, x, y, visit, picture);
					}
				}
			}
		}
	}
}
