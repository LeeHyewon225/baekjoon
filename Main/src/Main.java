import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean binary_graph = true;
	static int result[] = new int[999999];
	static int index = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		result = new int[C + 1];
		int visit[][] = new int[A + 1][B + 1];
		BFS(A, B, C, visit);
		for (int i = 0; i <= C; i++)
			System.out.print(result[i] == 0 ? "" : i + " ");
	}

	static void BFS(int A, int B, int C, int visit[][]) {
		Queue<water> q = new LinkedList<water>();
		visit[0][0] = 1;
		q.add(new water(0, 0));
		while (!q.isEmpty()) {
			int a = -1, b = -1;
			water now = q.poll();
			int now_c = C - now.a - now.b;
			if (now.a == 0)
				result[now_c]++;
			//C->A,B
			a = now.a + now_c >= A ? A : now.a + now_c;
			if (visit[a][now.b] == 0) {
				visit[a][now.b] = 1;
				q.add(new water(a, now.b));
			}
			b = now.b + now_c >= B ? B : now.b + now_c;
			if (visit[now.a][b] == 0) {
				visit[now.a][b] = 1;
				q.add(new water(now.a, b));
			}
			//B->A,C
			a = now.a + now.b >= A ? A : now.a + now.b;
			b = a == A ? now.b - A + now.a : 0;
			if (visit[a][b] == 0) {
				visit[a][b] = 1;
				q.add(new water(a, b));
			}
			b = now.b + now_c >= C ? now.b - C + now_c : 0;
			if (visit[now.a][b] == 0) {
				visit[now.a][b] = 1;
				q.add(new water(now.a, b));
			}
			//A->B,C
			b = now.b + now.a >= B ? B : now.b + now.a;
			a = b == B ? now.a - B + now.b : 0;
			if (visit[a][b] == 0) {
				visit[a][b] = 1;
				q.add(new water(a, b));
			}
			a = now.a + now_c >= C ? now.a - C + now_c : 0;
			if (visit[a][now.b] == 0) {
				visit[a][now.b] = 1;
				q.add(new water(a, now.b));
			}
		}
	}

	static class water {
		int a;
		int b;

		public water(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}
}
