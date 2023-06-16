import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
	static char map[][];
	static int visit[][][];
	static int N;
	static int M;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visit = new int[N][M][2];
		for (int i = 0; i < N; i++)
			map[i] = br.readLine().toCharArray();
		DFS(0, 0);
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

	static void DFS(int x, int y) {
		Queue<Map> queue = new LinkedList<Map>();
		visit[0][0][0] = 1;
		queue.add(new Map(x, y, 0));
		while (!queue.isEmpty()) {
			Map now = queue.poll();
			if (now.x == N - 1 && now.y == M - 1) {
				min = visit[now.x][now.y][now.wall];
				return;
			} else
				for (int i = 0; i < 4; i++) {
					int x2 = now.x + dx[i];
					int y2 = now.y + dy[i];
					if (0 <= x2 && x2 < N && 0 <= y2 && y2 < M)
						if (now.wall == 0) {
							if (map[x2][y2] == '0' && visit[x2][y2][0] == 0) {
								visit[x2][y2][0] = visit[now.x][now.y][0] + 1;
								queue.add(new Map(x2, y2, now.wall));
							} else if (now.wall == 0 && map[x2][y2] == '1') {
								visit[x2][y2][1] = visit[now.x][now.y][0] + 1;
								queue.add(new Map(x2, y2, 1));
							}
						} else if (map[x2][y2] == '0' && visit[x2][y2][1] == 0) {
							visit[x2][y2][1] = visit[now.x][now.y][1] + 1;
							queue.add(new Map(x2, y2, 1));
						}
				}

		}
	}

	static class Map {
		int x;
		int y;
		int wall;

		public Map(int x, int y, int wall) {
			this.x = x;
			this.y = y;
			this.wall = wall;
		}
	}
}
