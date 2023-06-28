import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Edge edge[] = new Edge[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			edge[i] = new Edge(A, B, V);
		}
		long money[] = new long[N];
		long distance[] = new long[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < money.length; i++) {
			money[i] = Integer.parseInt(st.nextToken());
			distance[i] = Long.MIN_VALUE;
		}
		distance[S] = money[S];
		for (int i = 1; i < 100; i++)
			for (int j = 0; j < M; j++) {
				Edge e = edge[j];
				if (distance[e.start_node] == Long.MAX_VALUE)
					distance[e.end_node] = Long.MAX_VALUE;
				else if (distance[e.start_node] != Long.MIN_VALUE
						&& distance[e.end_node] < distance[e.start_node] - e.value + money[e.end_node]) {
					distance[e.end_node] = distance[e.start_node] - e.value + money[e.end_node];
					if (i >= N)
						distance[e.end_node] = Long.MAX_VALUE;
				}
			}
		if (distance[E] == Long.MAX_VALUE)
			System.out.println("Gee");
		else if (distance[E] == Long.MIN_VALUE)
			System.out.println("gg");
		else
			System.out.println(distance[E]);
	}

	static class Edge {
		public int start_node;
		public int end_node;
		public int value;

		public Edge(int start_node, int end_node, int value) {
			this.start_node = start_node;
			this.end_node = end_node;
			this.value = value;
		}
	}
}
