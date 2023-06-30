import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int row[] = { -1, 0, 1, 0 };
	static int col[] = { 0, 1, 0, -1 };
	static int answer = 11;
	static int O_row;
	static int O_col;
	static int N;
	static int M;
	static char map[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		int R_row = 0;
		int B_row = 0;
		int R_col = 0;
		int B_col = 0;
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'R') {
					R_row = i;
					R_col = j;
					map[i][j] = '.';
				} else if (map[i][j] == 'B') {
					B_row = i;
					B_col = j;
					map[i][j] = '.';
				} else if (map[i][j] == 'O') {
					O_row = i;
					O_col = j;
				}
			}
		}
		DFS(R_row, R_col, B_row, B_col, 0, 1);
		DFS(R_row, R_col, B_row, B_col, 1, 1);
		DFS(R_row, R_col, B_row, B_col, 2, 1);
		DFS(R_row, R_col, B_row, B_col, 3, 1);
		System.out.println(answer == 11 ? -1 : answer);
	}

	static void DFS(int R_row, int R_col, int B_row, int B_col, int direction, int count) {
		if (answer <= count)
			return;
		if (R_row < B_row && direction == 0 || R_col > B_col && direction == 1 || R_row > B_row && direction == 2
				|| R_col < B_col && direction == 3) {
			while (map[R_row + row[direction]][R_col + col[direction]] == '.') {
				if (R_row + row[direction] == B_row && R_col + col[direction] == B_col)
					break;
				R_row += row[direction];
				R_col += col[direction];
			}
			if (R_row + row[direction] == O_row && R_col + col[direction] == O_col) {
				R_row += row[direction];
				R_col += col[direction];
			}
			while (map[B_row + row[direction]][B_col + col[direction]] == '.') {
				if (B_row + row[direction] == R_row && B_col + col[direction] == R_col) {
					break;
				}
				B_row += row[direction];
				B_col += col[direction];
			}
			if (B_row + row[direction] == O_row && B_col + col[direction] == O_col) {
				B_row += row[direction];
				B_col += col[direction];
			}
		} else {
			while (map[B_row + row[direction]][B_col + col[direction]] == '.') {
				if (B_row + row[direction] == R_row && B_col + col[direction] == R_col)
					break;
				B_row += row[direction];
				B_col += col[direction];
			}
			if (B_row + row[direction] == O_row && B_col + col[direction] == O_col) {
				B_row += row[direction];
				B_col += col[direction];
			}
			while (map[R_row + row[direction]][R_col + col[direction]] == '.') {
				if (R_row + row[direction] == B_row && R_col + col[direction] == B_col)
					break;
				R_row += row[direction];
				R_col += col[direction];
			}
			if (R_row + row[direction] == O_row && R_col + col[direction] == O_col) {
				R_row += row[direction];
				R_col += col[direction];
			}

		}
		if (B_row == O_row && B_col == O_col) {
			return;
		}
		if (R_row == O_row && R_col == O_col) {
			if (answer > count)
				answer = count;
			return;
		}
		if (direction != 0)
			DFS(R_row, R_col, B_row, B_col, 0, count + 1);
		if (direction != 1)
			DFS(R_row, R_col, B_row, B_col, 1, count + 1);
		if (direction != 2)
			DFS(R_row, R_col, B_row, B_col, 2, count + 1);
		if (direction != 3)
			DFS(R_row, R_col, B_row, B_col, 3, count + 1);
	}
}
