import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int map[][] = new int[N][M];
		int distance[][] = new int[N][M];
		int x = 0, y = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					x = i;
					y = j;
				}
			}
		}
		BFS(x, y, map, distance);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++)
				if (i == x && j == y)
					bw.write("0 ");
				else if (map[i][j] == 0)
					bw.write(Integer.toString(distance[i][j]) + " ");
				else
					bw.write(Integer.toString(distance[i][j] - 1) + " ");
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}

	static void BFS(int x, int y, int map[][], int distance[][]) {
		Queue<Node> q = new LinkedList();
		q.add(new Node(x, y));
		distance[x][y] = 1;
		while (!q.isEmpty()) {
			Node now = q.poll();
			for (int i = 0; i < 4; i++) {
				int x2 = now.x + dx[i];
				int y2 = now.y + dy[i];
				if (x2 >= 0 && x2 < N && y2 >= 0 && y2 < M && map[x2][y2] == 1 && distance[x2][y2] == 0) {
					q.add(new Node(x2, y2));
					distance[x2][y2] = distance[now.x][now.y] + 1;
				}
			}
		}
	}

	static class Node {
		int x;
		int y;

		public Node(int a, int b) {
			x = a;
			y = b;
		}
	}
}
